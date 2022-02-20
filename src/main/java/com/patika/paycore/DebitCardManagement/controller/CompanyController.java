package com.patika.paycore.DebitCardManagement.controller;

import com.patika.paycore.DebitCardManagement.model.Card;
import com.patika.paycore.DebitCardManagement.model.Company;
import com.patika.paycore.DebitCardManagement.model.Transactions;
import com.patika.paycore.DebitCardManagement.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/company")

public class CompanyController {

    private final CompanyService companyService;

    @GetMapping(value = "/all")
    public List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
    }

    @GetMapping(value = "/{id}")
    public Company getCompany(@PathVariable Integer id){
        return companyService.getCompany(id);
    }

    @PostMapping(value = "/create")
    public void saveCompany(@Valid @RequestBody Company company){
        companyService.addCompany(company);
    }

    @PutMapping(value = "/update")
    public Company updateCompany(@Valid @RequestBody Company company){
        return companyService.updateCompany(company);
    }

}
