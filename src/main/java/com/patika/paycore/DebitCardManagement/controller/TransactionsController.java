package com.patika.paycore.DebitCardManagement.controller;

import com.patika.paycore.DebitCardManagement.model.Card;
import com.patika.paycore.DebitCardManagement.model.Transactions;
import com.patika.paycore.DebitCardManagement.service.TransactionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/transactions")
public class TransactionsController {

    private final TransactionsService transactionsService;

    @GetMapping(value = "/all")
    public List<Transactions> getAllTransactions(){
        return transactionsService.getAllTransactions();
    }

    @GetMapping(value = "/{id}")
    public Transactions getTransactions(@PathVariable Integer id){
        return transactionsService.getTransactions(id);
    }

    @PostMapping(value = "/create")
    public void saveTransactions(@Valid @RequestBody Transactions transactions){
        transactionsService.addTransactions(transactions);
    }

    @PutMapping(value = "/update")
    public Transactions updateTransactions(@Valid @RequestBody Transactions transactions){
        return transactionsService.updateTransactions(transactions);
    }

}
