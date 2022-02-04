package com.patika.paycore.DebitCardManagement.controller;


import com.patika.paycore.DebitCardManagement.model.Bank;
import com.patika.paycore.DebitCardManagement.model.BankDTO;
import com.patika.paycore.DebitCardManagement.model.mapper.BankMapper;
import com.patika.paycore.DebitCardManagement.service.BankService;
import com.patika.paycore.DebitCardManagement.service.impl.BankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/bank")
public class BankController {

    @Autowired
    private BankService bankService;



    @GetMapping(path = "/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping(path = "/all")
    public List<BankDTO> getAllBanks(){
        return bankService.getAllBanks();
    }

    @PostMapping(path = "/get")
    public BankDTO getBank(@RequestParam Integer id){

        return bankService.getBank(id);
    }

    @PostMapping(path = "/add")
    public boolean addBank(@RequestBody BankDTO bank){
        return bankService.addBank(BankMapper.toEntity(bank));
    }

    @PutMapping(value = "/update")
    public BankDTO updateBank(@RequestBody BankDTO bank){

        return bankService.updateBank(BankMapper.toEntity(bank));
    }

    @DeleteMapping(value = "/delete/id={id}")
    public boolean deleteBank(@PathVariable Integer id){
        return bankService.deleteBank(id);
    }

}
