package by.itacademy.javaenterprise.seledtsova.joinedtable.dao;

import by.itacademy.javaenterprise.seledtsova.joinedtable.entity.Payment;

import java.util.List;

public interface PaymentDao {

    List<Payment> findAll();
}
