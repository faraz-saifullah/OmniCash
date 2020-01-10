package com.scaler.omnicash.Omnicash.Controllers;

import com.scaler.omnicash.Omnicash.Models.Customer;
import com.scaler.omnicash.Omnicash.Models.Shopkeeper;
import com.scaler.omnicash.Omnicash.Models.Transaction;
import com.scaler.omnicash.Omnicash.Repositories.CustomerRepository;
import com.scaler.omnicash.Omnicash.Repositories.ShopkeeperRepository;
import com.scaler.omnicash.Omnicash.Repositories.TransactionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    CustomerRepository customerRepository;
    ShopkeeperRepository shopkeeperRepository;
    TransactionRepository transactionRepository;

    @GetMapping("/add-money/{id}/{amount}")
    public String addMoney(@PathVariable(value = "id") Long id,@PathVariable(value = "amount")Long amount) throws Exception {

        Customer customer = customerRepository.findById(id).orElseThrow(()->new Exception("User not found."));
        customer.setWalletBalance(customer.getWalletBalance()+amount);
        customerRepository.save(customer);
        return "Money added successfully";
    }
    @GetMapping("/send-money/{uid}/{sid}/{amount}")
    public String sendMoney(@PathVariable(value = "uid") Long customerId,@PathVariable(value = "sid") Long shopkeeperId,@PathVariable(value = "amount")Long amount) throws Exception {

        Customer customer = customerRepository.findById(customerId).orElseThrow(()->new Exception("User not found."));
        Shopkeeper shopkeeper = shopkeeperRepository.findById(shopkeeperId).orElseThrow(()->new Exception("Shopkeeper not found."));
        customer.setWalletBalance(customer.getWalletBalance()-amount);
        shopkeeper.setWalletBalance(shopkeeper.getWalletBalance()+amount);
        customerRepository.save(customer);
        shopkeeperRepository.save(shopkeeper);
        Transaction transaction = new Transaction();
        transaction.setShopkeeper(shopkeeper);
        transaction.setCustomer(customer);
        transaction.setDate(java.time.LocalDate.now());
        transaction.setTime(java.time.LocalTime.now());
        transactionRepository.save(transaction);
        return "Money sent successfully";
    }
    @GetMapping("/transfer-history/{uid}")
    public List<Transaction> transferHistory(@PathVariable(value = "uid")Long userId){

        return transactionRepository.findByCustomers_Id(userId);
    }

}
