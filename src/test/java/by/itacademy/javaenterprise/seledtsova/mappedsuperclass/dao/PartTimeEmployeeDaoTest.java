package by.itacademy.javaenterprise.seledtsova.mappedsuperclass.dao;

import by.itacademy.javaenterprise.seledtsova.mappedsuperclass.dao.impl.PartTimeEmployeeDaoImpl;
import by.itacademy.javaenterprise.seledtsova.mappedsuperclass.entity.PartTimeEmployee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

public class PartTimeEmployeeDaoTest {

    private EntityManager entityManagerMock;
    private EntityTransaction entityTransactionMock;
    private PartTimeEmployeeDaoImpl partTimeEmployeeDao;

    @BeforeEach
    public void setUpBeforeEachTest() {
        entityManagerMock = Mockito.mock(EntityManager.class);
        entityTransactionMock = Mockito.mock(EntityTransaction.class);
        partTimeEmployeeDao = new PartTimeEmployeeDaoImpl(entityManagerMock);
    }

    @Test
    void shouldFindPartTimeEmployeeByIdTest() {
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee();
        Long id = 1L;
        partTimeEmployee.setId(id);
        when(entityManagerMock.find(PartTimeEmployee.class, id)).thenReturn(partTimeEmployee);
        PartTimeEmployee partTimeEmployee1 = partTimeEmployeeDao.findById(id);
        assertEquals(id, partTimeEmployee1.getId());
    }

    @Test
    void shouldPartTimeEmployeeWithWrongIdTest() {
        Long id = -1L;
        assertNull(partTimeEmployeeDao.findById(id));
    }

    @Test
    public void shouldSaveUpdatePartTimeEmployeeTest() {
        Long id = 4L;
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee();
        partTimeEmployee.setId(id);
        partTimeEmployee.setFirstName("James");
        partTimeEmployee.setLastName("Cannon");
        partTimeEmployee.setHourlyRate(BigDecimal.valueOf(215));
        when(entityManagerMock.find(PartTimeEmployee.class, id)).thenReturn(partTimeEmployee);
        assertEquals(partTimeEmployee.getId(), id);
    }

    @Test
    public void shouldDeletePartTimeEmployeeTest() {
        Long id = 2L;
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee();
        partTimeEmployee.setId(id);
        when(entityManagerMock.getTransaction()).thenReturn(entityTransactionMock);
        when(entityManagerMock.find(PartTimeEmployee.class, id)).thenReturn(partTimeEmployee).thenReturn(null);
        partTimeEmployeeDao.deleteById(id);
        assertNull(partTimeEmployeeDao.findById(id));
    }
}

