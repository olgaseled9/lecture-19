package by.itacademy.javaenterprise.seledtsova.mappedsuperclass.dao;

import by.itacademy.javaenterprise.seledtsova.mappedsuperclass.dao.impl.FullTimeEmployeeDaoImpl;
import by.itacademy.javaenterprise.seledtsova.mappedsuperclass.entity.FullTimeEmployee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

public class FullTimeEmployeeDaoTest {

    private EntityManager entityManagerMock;
    private EntityTransaction entityTransactionMock;
    private FullTimeEmployeeDaoImpl fullTimeEmployeeDao;

    @BeforeEach
    public void setUpBeforeEachTest() {
        entityManagerMock = Mockito.mock(EntityManager.class);
        entityTransactionMock = Mockito.mock(EntityTransaction.class);
        fullTimeEmployeeDao = new FullTimeEmployeeDaoImpl(entityManagerMock);
    }

    @Test
    void shouldFindFullTimeEmployeeByIdTest() {
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee();
        Long id = 1L;
        fullTimeEmployee.setId(id);
        when(entityManagerMock.find(FullTimeEmployee.class, id)).thenReturn(fullTimeEmployee);
        FullTimeEmployee fullTimeEmployee1 = fullTimeEmployeeDao.findById(id);
        assertEquals(id, fullTimeEmployee1.getId());
    }

    @Test
    void shouldFindFullTimeEmployeeWithWrongIdTest() {
        Long id = -1L;
        assertNull(fullTimeEmployeeDao.findById(id));
    }

    @Test
    public void shouldSaveUpdateFullTimeEmployeeTest() {
        Long id = 4L;
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee();
        fullTimeEmployee.setId(id);
        fullTimeEmployee.setFirstName("James");
        fullTimeEmployee.setLastName("Cannon");
        fullTimeEmployee.setSalary(5852);
        when(entityManagerMock.find(FullTimeEmployee.class, id)).thenReturn(fullTimeEmployee);
        assertEquals(fullTimeEmployee.getId(), id);
    }

    @Test
    public void shouldDeleteFullTimeEmployeeTest() {
        Long id = 2L;
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee();
        fullTimeEmployee.setId(id);
        when(entityManagerMock.getTransaction()).thenReturn(entityTransactionMock);
        when(entityManagerMock.find(FullTimeEmployee.class, id)).thenReturn(fullTimeEmployee).thenReturn(null);
        fullTimeEmployeeDao.deleteById(id);
        assertNull(fullTimeEmployeeDao.findById(id));
    }
}

