package com.patika.paycore.DebitCardManagement.repository;

import com.patika.paycore.DebitCardManagement.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {
}
