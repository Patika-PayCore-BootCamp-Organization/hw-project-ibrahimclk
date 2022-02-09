package com.patika.paycore.DebitCardManagement.model.mapper;

import com.patika.paycore.DebitCardManagement.model.Bank;
import com.patika.paycore.DebitCardManagement.model.BankDTO;

public class BankMapper {

    public static BankDTO toDto(Bank bank){
        BankDTO bankDTO = new BankDTO();
        bankDTO.setName(bank.getName());
        bankDTO.setAddresses(bank.formatToAddressList());
        return bankDTO;
    }

    public static Bank toEntity(BankDTO bankDTO){
        Bank bank = new Bank();
        bank.setName(bankDTO.getName());
        bank.setAddress(bankDTO.formatBank());
        return bank;
    }
}
