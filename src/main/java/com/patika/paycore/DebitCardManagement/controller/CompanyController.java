package com.patika.paycore.DebitCardManagement.controller;

import com.patika.paycore.DebitCardManagement.model.Company;
import com.patika.paycore.DebitCardManagement.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
