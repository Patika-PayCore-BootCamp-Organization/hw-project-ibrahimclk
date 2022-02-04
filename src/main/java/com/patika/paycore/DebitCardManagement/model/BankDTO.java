package com.patika.paycore.DebitCardManagement.model;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.StringJoiner;

@Data
public class BankDTO {

    @NotBlank
    public String name;

    @NotEmpty
    private List<@Valid Address> addresses;

    public String formatBank(){
        StringJoiner strJoiner = new StringJoiner(" // ");
        this.addresses.forEach(address -> strJoiner.add(address.addressDBFormat()));
        return strJoiner.toString();

    }
}
