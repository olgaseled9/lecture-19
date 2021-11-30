package by.itacademy.javaenterprise.seledtsova.singletable.dao;

import by.itacademy.javaenterprise.seledtsova.singletable.dao.impl.RectangleDaoImpl;
import by.itacademy.javaenterprise.seledtsova.singletable.entity.Rectangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

public class RectangleDaoTest {

    private EntityManager entityManagerMock;
    private EntityTransaction entityTransactionMock;
    private RectangleDao rectangleDao;

    @BeforeEach
    public void setUpBeforeEachTest() {
        entityManagerMock = Mockito.mock(EntityManager.class);
        entityTransactionMock = Mockito.mock(EntityTransaction.class);
        rectangleDao = new RectangleDaoImpl(entityManagerMock);
    }

    @Test
    void shouldFindRectangleByIdTest() {
        Rectangle rectangle = new Rectangle();
        Long id = 1L;
        rectangle.setShapeId(id);
        when(entityManagerMock.find(Rectangle.class, id)).thenReturn(rectangle);
        Rectangle rectangle1 = rectangleDao.findById(id);
        assertEquals(id, rectangle1.getShapeId());
    }

    @Test
    void shouldFindRectangleWithWrongIdTest() {
        Long id = -1L;
        assertNull(rectangleDao.findById(id));
    }

    @Test
    public void shouldSaveUpdateRectangleTest() {
        Long id = 4L;
        Rectangle rectangle = new Rectangle();
        rectangle.setShapeId(id);
        rectangle.setLength(10);
        rectangle.setBreadth(27);
        when(entityManagerMock.find(Rectangle.class, id)).thenReturn(rectangle);
        assertEquals(rectangle.getShapeId(), id);
    }

    @Test
    public void shouldDeleteRectangleTest() {
        Long id = 2L;
        Rectangle rectangle = new Rectangle();
        rectangle.setShapeId(id);
        when(entityManagerMock.getTransaction()).thenReturn(entityTransactionMock);
        when(entityManagerMock.find(Rectangle.class, id)).thenReturn(rectangle).thenReturn(null);
        rectangleDao.deleteById(id);
        assertNull(rectangleDao.findById(id));
    }
}
