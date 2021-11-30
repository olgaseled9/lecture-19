package by.itacademy.javaenterprise.seledtsova.singletable.dao;

import by.itacademy.javaenterprise.seledtsova.singletable.dao.impl.CircleDaoImpl;
import by.itacademy.javaenterprise.seledtsova.singletable.entity.Circle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

public class CircleDaoTest {

    private EntityManager entityManagerMock;
    private EntityTransaction entityTransactionMock;
    private CircleDao circleDao;

    @BeforeEach
    public void setUpBeforeEachTest() {
        entityManagerMock = Mockito.mock(EntityManager.class);
        entityTransactionMock = Mockito.mock(EntityTransaction.class);
        circleDao = new CircleDaoImpl(entityManagerMock);
    }

    @Test
    void shouldFindCicleByIdTest() {
        Circle circle = new Circle();
        Long id = 1L;
        circle.setShapeId(id);
        when(entityManagerMock.find(Circle.class, id)).thenReturn(circle);
        Circle circle1 = circleDao.findById(id);
        assertEquals(id, circle1.getShapeId());
    }

    @Test
    void shouldFindCircleWithWrongIdTest() {
        Long id = -1L;
        assertNull(circleDao.findById(id));
    }

    @Test
    public void shouldSaveUpdateCircleTest() {
        Long id = 4L;
        Circle circle = new Circle();
        circle.setShapeId(id);
        circle.setRadius(14);
        when(entityManagerMock.find(Circle.class, id)).thenReturn(circle);
        assertEquals(circle.getShapeId(), id);
    }

    @Test
    public void shouldDeleteCircleTest() {
        Long id = 2L;
        Circle circle = new Circle();
        circle.setShapeId(id);
        when(entityManagerMock.getTransaction()).thenReturn(entityTransactionMock);
        when(entityManagerMock.find(Circle.class, id)).thenReturn(circle).thenReturn(null);
        circleDao.deleteById(id);
        assertNull(circleDao.findById(id));
    }
}
