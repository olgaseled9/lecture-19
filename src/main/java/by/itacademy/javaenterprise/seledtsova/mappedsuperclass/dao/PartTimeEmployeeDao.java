package by.itacademy.javaenterprise.seledtsova.mappedsuperclass.dao;

import by.itacademy.javaenterprise.seledtsova.mappedsuperclass.entity.PartTimeEmployee;

public interface PartTimeEmployeeDao {

    void saveOrUpdate(PartTimeEmployee partTimeEmployee);

    PartTimeEmployee findById(Long id);

    void deleteById(Long id);
}
