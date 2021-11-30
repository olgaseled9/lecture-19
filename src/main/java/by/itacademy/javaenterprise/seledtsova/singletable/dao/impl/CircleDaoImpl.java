package by.itacademy.javaenterprise.seledtsova.singletable.dao.impl;

import by.itacademy.javaenterprise.seledtsova.singletable.dao.CircleDao;
import by.itacademy.javaenterprise.seledtsova.singletable.entity.Circle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class CircleDaoImpl implements CircleDao {

    private static final Logger logger = LoggerFactory.getLogger(CircleDaoImpl.class);

    private EntityManager entityManager;

    public CircleDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveOrUpdate(Circle circle) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(circle);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            logger.error("Cannot save or update circle " + e.getMessage(), e);
        }
    }

    @Override
    public Circle findById(Long id) {
        Circle circle = new Circle();
        try {
            circle = entityManager.find(Circle.class, id);
        } catch (Exception e) {
            logger.error("Cannot find circle by id" + e.getMessage(), e);
        }
        return circle;
    }

    @Override
    public void deleteById(Long id) {
        try {
            entityManager.getTransaction().begin();
            Circle circle = entityManager.find(Circle.class, id);
            entityManager.remove(circle);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            logger.error("Cannot delete circle " + e.getMessage(), e);
        }
    }
}

