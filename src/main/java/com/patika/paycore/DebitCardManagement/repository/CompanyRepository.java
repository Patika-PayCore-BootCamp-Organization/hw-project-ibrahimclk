package com.patika.paycore.DebitCardManagement.repository;

import com.patika.paycore.DebitCardManagement.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
