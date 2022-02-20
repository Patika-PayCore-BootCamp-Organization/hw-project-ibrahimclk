package com.patika.paycore.DebitCardManagement.service.impl;

import com.patika.paycore.DebitCardManagement.exception.NotFoundException;
import com.patika.paycore.DebitCardManagement.model.Company;
import com.patika.paycore.DebitCardManagement.repository.CompanyRepository;
import com.patika.paycore.DebitCardManagement.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompany(Integer id) {
        Optional<Company> byId = companyRepository.findById(id);

        return byId.orElseThrow(()-> new NotFoundException("company"));
    }

    @Override
    public void addCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Company updateCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public boolean deleteCompany(Integer id) {
        Company company = getCompany(id);
        companyRepository.delete(company);
        return true;
    }
}
