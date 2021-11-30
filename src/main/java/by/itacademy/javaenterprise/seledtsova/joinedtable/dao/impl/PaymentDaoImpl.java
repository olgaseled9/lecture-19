package by.itacademy.javaenterprise.seledtsova.joinedtable.dao.impl;

import by.itacademy.javaenterprise.seledtsova.joinedtable.dao.PaymentDao;
import by.itacademy.javaenterprise.seledtsova.joinedtable.entity.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PaymentDaoImpl implements PaymentDao {

    private static final Logger logger = LoggerFactory.getLogger(PaymentDaoImpl.class);
    private EntityManager entityManager;

    public PaymentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Payment> findAll() {
        try {
            String queryString = "from " + Payment.class.getName();
            Query query = entityManager.createQuery(queryString);
            return query.getResultList();
        } catch (Exception e) {
            logger.error("Cannot get all payment " + e.getMessage(), e);
        }
        return null;
    }
}

