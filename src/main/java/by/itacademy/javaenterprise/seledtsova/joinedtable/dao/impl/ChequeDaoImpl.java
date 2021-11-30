package by.itacademy.javaenterprise.seledtsova.joinedtable.dao.impl;

import by.itacademy.javaenterprise.seledtsova.joinedtable.dao.ChequeDao;
import by.itacademy.javaenterprise.seledtsova.joinedtable.entity.Cheque;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class ChequeDaoImpl implements ChequeDao {

    private static final Logger logger = LoggerFactory.getLogger(ChequeDaoImpl.class);

    private EntityManager entityManager;

    public ChequeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveOrUpdate(Cheque cheque) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cheque);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            logger.error("Cannot save or update cheque " + e.getMessage(), e);
        }
    }

    @Override
    public Cheque findById(Long id) {
        Cheque cheque = new Cheque();
        try {
            cheque = entityManager.find(Cheque.class, id);
        } catch (Exception e) {
            logger.error("Cannot find cheque by id" + e.getMessage(), e);
        }
        return cheque;
    }

    @Override
    public void deleteById(Long id) {
        try {
            entityManager.getTransaction().begin();
            Cheque cheque = entityManager.find(Cheque.class, id);
            entityManager.remove(cheque);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            logger.error("Cannot delete cheque " + e.getMessage(), e);
        }
    }
}
