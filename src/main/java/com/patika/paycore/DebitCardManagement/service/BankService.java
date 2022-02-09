package com.patika.paycore.DebitCardManagement.service;

import com.patika.paycore.DebitCardManagement.model.Bank;
import com.patika.paycore.DebitCardManagement.model.BankDTO;

import java.util.List;

public interface BankService {
    List<BankDTO> getAllBanks();

    BankDTO getBank(Integer id);

    boolean addBank(Bank bank);

    BankDTO updateBank(Integer id, Bank bank);


    boolean deleteBank(Integer id);
}
