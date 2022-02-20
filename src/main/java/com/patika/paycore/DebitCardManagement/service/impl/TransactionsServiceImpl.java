package com.patika.paycore.DebitCardManagement.service.impl;

import com.patika.paycore.DebitCardManagement.exception.NotFoundException;
import com.patika.paycore.DebitCardManagement.model.Transactions;
import com.patika.paycore.DebitCardManagement.repository.TransactionsRepository;
import com.patika.paycore.DebitCardManagement.service.TransactionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionsServiceImpl implements TransactionsService {

    private final TransactionsRepository transactionsRepository;

    @Override
    public List<Transactions> getAllTransactions() {
        return transactionsRepository.findAll();
    }

    @Override
    public Transactions getTransactions(Integer id) {
        Optional<Transactions> byId = transactionsRepository.findById(id);

        return byId.orElseThrow(()-> new NotFoundException("transactions"));
    }

    @Override
    public void addTransactions(Transactions transactions) {
        transactionsRepository.save(transactions);

    }

    @Override
    public Transactions updateTransactions(Transactions transactions) {
        return transactionsRepository.save(transactions);
    }

    @Override
    public boolean deleteTransactions(Integer id) {
        transactionsRepository.delete(getTransactions(id));
        return true;
    }
}
