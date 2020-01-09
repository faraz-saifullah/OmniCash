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

    public Customer(){ }

    private Customer(CustomerBuilder customerBuilder){
        setEmail(customerBuilder.email);
        setName(customerBuilder.name);
        setPhoneNumber(customerBuilder.phoneNumber);
        setWalletBalance(customerBuilder.walletBalance);
    }
    public static final class CustomerBuilder {
        private String name;
        private String email;
        private String phoneNumber;
        private Long walletBalance;

        private CustomerBuilder() {
        }

        public static CustomerBuilder aCustomer() {
            return new CustomerBuilder();
        }

        public CustomerBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CustomerBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public CustomerBuilder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public CustomerBuilder withWalletBalance(Long walletBalance) {
            this.walletBalance = walletBalance;
            return this;
        }

        public Customer build() {
            Customer customer = new Customer();
            customer.setName(name);
            customer.setEmail(email);
            customer.setPhoneNumber(phoneNumber);
            customer.setWalletBalance(walletBalance);
            return customer;
        }
    }
}
