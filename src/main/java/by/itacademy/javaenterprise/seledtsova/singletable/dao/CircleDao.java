package by.itacademy.javaenterprise.seledtsova.singletable.dao;

import by.itacademy.javaenterprise.seledtsova.singletable.entity.Circle;

public interface CircleDao {

    void saveOrUpdate(Circle circle);

    Circle findById(Long id);

    void deleteById(Long id);
}
