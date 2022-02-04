package com.patika.paycore.DebitCardManagement.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bank")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @Transient
    private List<Address> addresses;

    public List<Address> formatToAddressList(){
        String[] splitedAddresses = address.split("//");
        List<Address> response = new ArrayList<>();
        Arrays.stream(splitedAddresses).forEach(split -> {
            String[] splited = split.trim().split("/");
            response.add(new Address(splited[1], splited[0]));

        });
        return response;
    }
}
