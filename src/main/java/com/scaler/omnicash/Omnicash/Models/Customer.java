package com.scaler.omnicash.Omnicash.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "customers")
public class Customer extends User{

    @Getter
    @Setter
    @NotBlank
    @Email
    private String email;
}
