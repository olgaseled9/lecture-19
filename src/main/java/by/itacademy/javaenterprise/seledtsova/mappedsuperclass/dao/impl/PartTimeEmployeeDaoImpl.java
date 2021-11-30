package by.itacademy.javaenterprise.seledtsova.mappedsuperclass.dao.impl;

import by.itacademy.javaenterprise.seledtsova.mappedsuperclass.dao.PartTimeEmployeeDao;
import by.itacademy.javaenterprise.seledtsova.mappedsuperclass.entity.PartTimeEmployee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class PartTimeEmployeeDaoImpl implements PartTimeEmployeeDao {

    private static final Logger logger = LoggerFactory.getLogger(PartTimeEmployeeDaoImpl.class);

    private EntityManager entityManager;

    public PartTimeEmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveOrUpdate(PartTimeEmployee partTimeEmployee) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(partTimeEmployee);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            logger.error("Cannot save or update partTimeEmployee " + e.getMessage(), e);
        }
    }

    @Override
    public PartTimeEmployee findById(Long id) {
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee();
        try {
            partTimeEmployee = entityManager.find(PartTimeEmployee.class, id);
        } catch (Exception e) {
            logger.error("Cannot find partTimeEmployee by id" + e.getMessage(), e);
        }
        return partTimeEmployee;
    }

    @Override
    public void deleteById(Long id) {
        try {
            entityManager.getTransaction().begin();
            PartTimeEmployee partTimeEmployee = entityManager.find(PartTimeEmployee.class, id);
            entityManager.remove(partTimeEmployee);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            logger.error("Cannot delete partTimeEmployee " + e.getMessage(), e);
        }
    }
}

