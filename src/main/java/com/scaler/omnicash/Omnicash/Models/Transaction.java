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

    public Transaction(){ }

    private Transaction(TransactionBuilder transactionBuilder){
        setShopkeeper(transactionBuilder.shopkeeper);
        setCustomer(transactionBuilder.customer);
        setDate(transactionBuilder.date);
        setTime(transactionBuilder.time);
        setAmount(transactionBuilder.amount);
        setUserRating(transactionBuilder.userRating);
        setShopkeeperRating(transactionBuilder.shopkeeperRating);
    }
    public static final class TransactionBuilder {
        private Shopkeeper shopkeeper;
        private Customer customer;
        private Date date;
        private Time time;
        private Long amount;
        private Long userRating;
        private Long shopkeeperRating;

        private TransactionBuilder() {
        }

        public static TransactionBuilder aTransaction() {
            return new TransactionBuilder();
        }

        public TransactionBuilder withShopkeeper(Shopkeeper shopkeeper) {
            this.shopkeeper = shopkeeper;
            return this;
        }

        public TransactionBuilder withCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public TransactionBuilder withDate(Date date) {
            this.date = date;
            return this;
        }

        public TransactionBuilder withTime(Time time) {
            this.time = time;
            return this;
        }

        public TransactionBuilder withAmount(Long amount) {
            this.amount = amount;
            return this;
        }

        public TransactionBuilder withUserRating(Long userRating) {
            this.userRating = userRating;
            return this;
        }

        public TransactionBuilder withShopkeeperRating(Long shopkeeperRating) {
            this.shopkeeperRating = shopkeeperRating;
            return this;
        }

        public Transaction build() {
            Transaction transaction = new Transaction();
            transaction.setShopkeeper(shopkeeper);
            transaction.setCustomer(customer);
            transaction.setDate(date);
            transaction.setTime(time);
            transaction.setAmount(amount);
            transaction.setUserRating(userRating);
            transaction.setShopkeeperRating(shopkeeperRating);
            return transaction;
        }
    }
}
