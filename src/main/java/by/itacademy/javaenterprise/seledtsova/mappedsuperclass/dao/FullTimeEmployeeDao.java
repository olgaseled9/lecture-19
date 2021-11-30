package by.itacademy.javaenterprise.seledtsova.mappedsuperclass.dao;

import by.itacademy.javaenterprise.seledtsova.mappedsuperclass.entity.FullTimeEmployee;

public interface FullTimeEmployeeDao {

    void saveOrUpdate(FullTimeEmployee fullTimeEmployee);

    FullTimeEmployee findById(Long id);

    void deleteById(Long id);
}
