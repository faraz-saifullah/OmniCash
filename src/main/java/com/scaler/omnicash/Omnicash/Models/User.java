package com.scaler.omnicash.Omnicash.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class User extends Auditable{

    @Getter
    @Setter
    @NotBlank
    private String name;

    @Getter
    @Setter
    @NotBlank
    private String phoneNumber;

    @Getter
    @Setter
    private Long rating;

    @Getter
    @Setter
    @NotBlank
    @NotNull
    private Long walletBalance;
}
