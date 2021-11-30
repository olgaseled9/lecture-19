package by.itacademy.javaenterprise.seledtsova.mappedsuperclass.dao.impl;

import by.itacademy.javaenterprise.seledtsova.mappedsuperclass.dao.FullTimeEmployeeDao;
import by.itacademy.javaenterprise.seledtsova.mappedsuperclass.entity.FullTimeEmployee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class FullTimeEmployeeDaoImpl implements FullTimeEmployeeDao {

    private static final Logger logger = LoggerFactory.getLogger(FullTimeEmployeeDaoImpl.class);

    private EntityManager entityManager;

    public FullTimeEmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveOrUpdate(FullTimeEmployee fullTimeEmployee) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(fullTimeEmployee);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            logger.error("Cannot save or update fullTimeEmployee " + e.getMessage(), e);
        }
    }

    @Override
    public FullTimeEmployee findById(Long id) {
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee();
        try {
            fullTimeEmployee = entityManager.find(FullTimeEmployee.class, id);
        } catch (Exception e) {
            logger.error("Cannot find fullTimeEmployee by id" + e.getMessage(), e);
        }
        return fullTimeEmployee;
    }

    @Override
    public void deleteById(Long id) {
        try {
            entityManager.getTransaction().begin();
            FullTimeEmployee fullTimeEmployee = entityManager.find(FullTimeEmployee.class, id);
            entityManager.remove(fullTimeEmployee);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            logger.error("Cannot delete fullTimeEmployee " + e.getMessage(), e);
        }
    }
}
