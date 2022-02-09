package com.patika.paycore.DebitCardManagement.repository;

import com.patika.paycore.DebitCardManagement.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
