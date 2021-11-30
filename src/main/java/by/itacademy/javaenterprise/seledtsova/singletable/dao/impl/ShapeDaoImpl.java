package by.itacademy.javaenterprise.seledtsova.singletable.dao.impl;

import by.itacademy.javaenterprise.seledtsova.singletable.dao.ShapeDao;
import by.itacademy.javaenterprise.seledtsova.singletable.entity.Shape;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ShapeDaoImpl implements ShapeDao {

    private static final Logger logger = LoggerFactory.getLogger(ShapeDao.class);
    private EntityManager entityManager;

    public ShapeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Shape> findAll() {
        try {
            String queryString = "from " + Shape.class.getName();
            Query query = entityManager.createQuery(queryString);
            return query.getResultList();
        } catch (Exception e) {
            logger.error("Cannot get all items " + e.getMessage(), e);
        }
        return null;
    }
}
