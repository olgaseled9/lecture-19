package by.itacademy.javaenterprise.seledtsova.joinedtable.dao;

import by.itacademy.javaenterprise.seledtsova.joinedtable.entity.Cheque;

public interface ChequeDao {

    void saveOrUpdate(Cheque cheque);

    Cheque findById(Long id);

    void deleteById(Long id);
}
