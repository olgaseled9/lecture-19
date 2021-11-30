package by.itacademy.javaenterprise.seledtsova.singletable.dao;

import by.itacademy.javaenterprise.seledtsova.singletable.entity.Shape;

import java.util.List;

public interface ShapeDao {

    List<Shape> findAll();
}
