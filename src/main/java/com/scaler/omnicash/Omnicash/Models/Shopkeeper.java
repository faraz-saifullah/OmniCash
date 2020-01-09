package com.scaler.omnicash.Omnicash.Models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "shopkeepers")
public class Shopkeeper extends User {

    @Getter
    @Setter
    @NotBlank
    private String shopName;

    @Getter
    @Setter
    @NotBlank
    private String locality;

    @Getter
    @Setter
    @NotBlank
    private String city;

    @Getter
    @Setter
    @NotBlank
    private String address;

    @Getter
    @Setter
    @NotNull
    private Long longitude;

    @Getter
    @Setter
    @NotNull
    private Long latitude;

    @Getter
    @Setter
    @NotBlank
    @NotNull
    private Long dailyLimit;
}
