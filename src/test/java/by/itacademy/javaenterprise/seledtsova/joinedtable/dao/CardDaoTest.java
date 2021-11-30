package by.itacademy.javaenterprise.seledtsova.joinedtable.dao;

import by.itacademy.javaenterprise.seledtsova.joinedtable.dao.impl.CardDaoImpl;
import by.itacademy.javaenterprise.seledtsova.joinedtable.entity.Card;
import by.itacademy.javaenterprise.seledtsova.singletable.dao.CircleDao;
import by.itacademy.javaenterprise.seledtsova.singletable.dao.impl.CircleDaoImpl;
import by.itacademy.javaenterprise.seledtsova.singletable.entity.Circle;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

public class CardDaoTest {
    private EntityManager entityManagerMock;
    private EntityTransaction entityTransactionMock;
    private CardDaoImpl cardDao;

    @BeforeEach
    public void setUpBeforeEachTest() {
        entityManagerMock = Mockito.mock(EntityManager.class);
        entityTransactionMock = Mockito.mock(EntityTransaction.class);
        cardDao = new CardDaoImpl(entityManagerMock);
    }

    @Test
    void shouldFindCardByIdTest() {
        Card card=new Card();
        Long id = 1L;
        card.setId(id);
        when(entityManagerMock.find(Card.class, id)).thenReturn(card);
        Card card1= cardDao.findById(id);
        assertEquals(id, card1.getId());
    }

    @Test
    void shouldFindCardWithWrongIdTest() {
        Long id = -1L;
        assertNull(cardDao.findById(id));
    }

    @Test
    public void shouldSaveUpdateCardTest() {
        Long id = 4L;
        Card card=new Card();
        card.setId(id);;
       card.setCardType("Order");
       card.setCardNumber(121);
        when(entityManagerMock.find(Card.class, id)).thenReturn(card);
        assertEquals(card.getId(), id);
    }

    @Test
    public void shouldDeleteCardTest() {
        Long id = 2L;
        Card card=new Card();
        card.setId(id);
        when(entityManagerMock.getTransaction()).thenReturn(entityTransactionMock);
        when(entityManagerMock.find(Card.class, id)).thenReturn(card).thenReturn(null);
        cardDao.deleteById(id);
        assertNull(cardDao.findById(id));
    }
}
