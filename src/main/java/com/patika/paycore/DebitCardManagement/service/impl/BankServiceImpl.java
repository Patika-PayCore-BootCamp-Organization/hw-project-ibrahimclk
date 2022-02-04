package com.patika.paycore.DebitCardManagement.service.impl;

import com.patika.paycore.DebitCardManagement.model.Bank;
import com.patika.paycore.DebitCardManagement.model.BankDTO;
import com.patika.paycore.DebitCardManagement.model.mapper.BankMapper;
import com.patika.paycore.DebitCardManagement.repository.BankRepository;
import com.patika.paycore.DebitCardManagement.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository bankRepository;

    @Override
    public List<BankDTO> getAllBanks() {

        List<Bank> all = bankRepository.findAll();
        return all.stream().map(BankMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public BankDTO getBank(Integer id) {

        Optional<Bank> byId = bankRepository.findById(id);
        if(byId.isPresent()){
            return BankMapper.toDto(byId.get());
        }
        return null;
    }

    @Override
    public boolean addBank(Bank bank) {

        Bank save = bankRepository.save(bank);
        if(save == null)
            return false;
        return true;
    }

    @Override
    public BankDTO updateBank(Bank bank) {

        return BankMapper.toDto(bankRepository.save(bank));
    }


    @Override
    public boolean deleteBank(Integer id) {
        bankRepository.deleteById(id);
        return true;
    }
}
