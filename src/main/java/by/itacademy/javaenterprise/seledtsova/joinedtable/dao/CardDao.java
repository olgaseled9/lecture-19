package by.itacademy.javaenterprise.seledtsova.joinedtable.dao;

import by.itacademy.javaenterprise.seledtsova.joinedtable.entity.Card;

public interface CardDao {

    void saveOrUpdate(Card card);

    Card findById(Long id);

    void deleteById(Long id);
}
