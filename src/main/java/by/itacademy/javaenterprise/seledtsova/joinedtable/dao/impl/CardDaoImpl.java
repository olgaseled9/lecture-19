package by.itacademy.javaenterprise.seledtsova.joinedtable.dao.impl;

import by.itacademy.javaenterprise.seledtsova.joinedtable.dao.CardDao;
import by.itacademy.javaenterprise.seledtsova.joinedtable.entity.Card;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class CardDaoImpl implements CardDao {

    private static final Logger logger = LoggerFactory.getLogger(CardDaoImpl.class);

    private EntityManager entityManager;

    public CardDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveOrUpdate(Card card) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(card);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            logger.error("Cannot save or update card " + e.getMessage(), e);
        }
    }

    @Override
    public Card findById(Long id) {
        Card card = new Card();
        try {
            card = entityManager.find(Card.class, id);
        } catch (Exception e) {
            logger.error("Cannot find card by id" + e.getMessage(), e);
        }
        return card;
    }

    @Override
    public void deleteById(Long id) {
        try {
            entityManager.getTransaction().begin();
            Card card = entityManager.find(Card.class, id);
            entityManager.remove(card);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            logger.error("Cannot delete card " + e.getMessage(), e);
        }
    }
}
