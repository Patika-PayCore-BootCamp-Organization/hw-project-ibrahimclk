package com.patika.paycore.DebitCardManagement.service;

import com.patika.paycore.DebitCardManagement.model.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();

    Company getCompany(Integer id);

    void addCompany(Company company);

    Company updateCompany(Company company);

    boolean deleteCompany(Integer id);

}
