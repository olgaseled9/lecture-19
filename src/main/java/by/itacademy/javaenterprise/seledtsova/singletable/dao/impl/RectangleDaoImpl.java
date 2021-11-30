package by.itacademy.javaenterprise.seledtsova.singletable.dao.impl;

import by.itacademy.javaenterprise.seledtsova.singletable.dao.RectangleDao;
import by.itacademy.javaenterprise.seledtsova.singletable.entity.Rectangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class RectangleDaoImpl implements RectangleDao {

    private static final Logger logger = LoggerFactory.getLogger(RectangleDaoImpl.class);
    private EntityManager entityManager;

    public RectangleDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveOrUpdate(Rectangle rectangle) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(rectangle);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            logger.error("Cannot save or update rectangle " + e.getMessage(), e);
        }
    }

    @Override
    public Rectangle findById(Long id) {
        Rectangle rectangle = new Rectangle();
        try {
            rectangle = entityManager.find(Rectangle.class, id);
        } catch (Exception e) {
            logger.error("Cannot find rectangle by id" + e.getMessage(), e);
        }
        return rectangle;
    }


    @Override
    public void deleteById(Long id) {
        try {
            entityManager.getTransaction().begin();
            Rectangle rectangle = entityManager.find(Rectangle.class, id);
            entityManager.remove(rectangle);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            logger.error("Cannot delete rectangle " + e.getMessage(), e);
        }
    }
}
