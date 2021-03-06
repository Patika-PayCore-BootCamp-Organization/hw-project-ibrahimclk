package com.patika.paycore.DebitCardManagement.repository;


import com.patika.paycore.DebitCardManagement.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {
}
