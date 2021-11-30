package by.itacademy.javaenterprise.seledtsova.joinedtable.dao;

import by.itacademy.javaenterprise.seledtsova.joinedtable.dao.impl.ChequeDaoImpl;
import by.itacademy.javaenterprise.seledtsova.joinedtable.entity.Cheque;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

public class ChequeTest {

    private EntityManager entityManagerMock;
    private EntityTransaction entityTransactionMock;
    private ChequeDao chequeDao;

    @BeforeEach
    public void setUpBeforeEachTest() {
        entityManagerMock = Mockito.mock(EntityManager.class);
        entityTransactionMock = Mockito.mock(EntityTransaction.class);
        chequeDao = new ChequeDaoImpl(entityManagerMock);
    }

    @Test
    void shouldFindCardByIdTest() {
        Cheque cheque = new Cheque();
        Long id = 1L;
        cheque.setId(id);
        when(entityManagerMock.find(Cheque.class, id)).thenReturn(cheque);
        Cheque cheque1 = chequeDao.findById(id);
        assertEquals(id, cheque1.getId());
    }

    @Test
    void shouldFindCardWithWrongIdTest() {
        Long id = -1L;
        assertNull(chequeDao.findById(id));
    }

    @Test
    public void shouldSaveUpdateCardTest() {
        Long id = 4L;
        Cheque cheque = new Cheque();
        cheque.setId(id);
        ;
        cheque.setChequeType("Order");
        cheque.setChequeNumber(1247);
        when(entityManagerMock.find(Cheque.class, id)).thenReturn(cheque);
        assertEquals(cheque.getId(), id);
    }

    @Test
    public void shouldDeleteCardTest() {
        Long id = 2L;
        Cheque cheque = new Cheque();
        cheque.setId(id);
        when(entityManagerMock.getTransaction()).thenReturn(entityTransactionMock);
        when(entityManagerMock.find(Cheque.class, id)).thenReturn(cheque).thenReturn(null);
        chequeDao.deleteById(id);
        assertNull(chequeDao.findById(id));
    }
}
