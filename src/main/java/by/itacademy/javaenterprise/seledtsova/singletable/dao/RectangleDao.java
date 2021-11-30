package by.itacademy.javaenterprise.seledtsova.singletable.dao;

import by.itacademy.javaenterprise.seledtsova.singletable.entity.Rectangle;

public interface RectangleDao {

    void saveOrUpdate(Rectangle rectangle);

    Rectangle findById(Long id);

    void deleteById(Long id);
}
