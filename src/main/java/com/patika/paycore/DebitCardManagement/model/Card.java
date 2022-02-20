package com.patika.paycore.DebitCardManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="customer_id", referencedColumnName = "id")
    private Customer customer;

    @NotNull
    private String card_number;

    @NotNull
    private String card_type;

    @NotNull
    private Date expired_date;

    @NotNull
    private String csv;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="bank_id", referencedColumnName = "id")
    private Bank bank;

}
