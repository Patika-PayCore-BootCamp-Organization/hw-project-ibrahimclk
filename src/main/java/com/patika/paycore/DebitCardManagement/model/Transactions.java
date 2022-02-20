package com.patika.paycore.DebitCardManagement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="customer_id", referencedColumnName = "id")
    private Card card;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="bank_id", referencedColumnName = "id")
    private Company company;

    @NotNull
    private String price;

}
