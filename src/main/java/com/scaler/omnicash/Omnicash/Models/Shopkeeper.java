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

    public Shopkeeper() { }

    private Shopkeeper(ShopkeeperBuilder shopkeeperBuilder){
        setName(shopkeeperBuilder.name);
        setPhoneNumber(shopkeeperBuilder.phoneNumber);
        setShopName(shopkeeperBuilder.shopName);
        setWalletBalance(shopkeeperBuilder.walletBalance);
        setAddress(shopkeeperBuilder.address);
        setDailyLimit(shopkeeperBuilder.dailyLimit);
    }
    public static final class ShopkeeperBuilder {
        private String name;
        private String phoneNumber;
        private String shopName;
        private Long walletBalance;
        private String address;
        private Long dailyLimit;

        private ShopkeeperBuilder() {
        }

        public static ShopkeeperBuilder aShopkeeper() {
            return new ShopkeeperBuilder();
        }

        public ShopkeeperBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ShopkeeperBuilder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public ShopkeeperBuilder withShopName(String shopName) {
            this.shopName = shopName;
            return this;
        }

        public ShopkeeperBuilder withWalletBalance(Long walletBalance) {
            this.walletBalance = walletBalance;
            return this;
        }

        public ShopkeeperBuilder withAddress(String address) {
            this.address = address;
            return this;
        }

        public ShopkeeperBuilder withDailyLimit(Long dailyLimit) {
            this.dailyLimit = dailyLimit;
            return this;
        }

        public Shopkeeper build() {
            Shopkeeper shopkeeper = new Shopkeeper();
            shopkeeper.setName(name);
            shopkeeper.setPhoneNumber(phoneNumber);
            shopkeeper.setShopName(shopName);
            shopkeeper.setWalletBalance(walletBalance);
            shopkeeper.setAddress(address);
            shopkeeper.setDailyLimit(dailyLimit);
            return shopkeeper;
        }
    }
}
