package com.scaler.omnicash.Omnicash.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction extends Auditable {

    @Getter
    @Setter
    @ManyToOne
    private Shopkeeper shopkeeper;

    @Getter
    @Setter
    @ManyToOne
    private Customer customer;

    @Getter
    @Setter
    @NotNull
    @NotBlank
    private Date date;

    @Getter
    @Setter
    @NotBlank
    @NotNull
    private Time time;

    @Getter
    @Setter
    @NotNull
    @NotBlank
    private Long amount;

    @Getter
    @Setter
    private Long userRating;

    @Getter
    @Setter
    private Long shopkeeperRating;
}
