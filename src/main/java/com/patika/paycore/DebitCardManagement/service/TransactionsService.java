package com.patika.paycore.DebitCardManagement.service;

import com.patika.paycore.DebitCardManagement.model.Transactions;

import java.util.List;

public interface TransactionsService {

    List<Transactions> getAllTransactions();

    Transactions getTransactions(Integer id);

    void addTransactions(Transactions transactions);

    Transactions updateTransactions(Transactions transactions);

    boolean deleteTransactions(Integer id);

}
