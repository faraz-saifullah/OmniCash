package com.scaler.omnicash.Omnicash.Controllers;

import com.scaler.omnicash.Omnicash.Models.Shopkeeper;
import com.scaler.omnicash.Omnicash.Models.Transaction;
import com.scaler.omnicash.Omnicash.Repositories.ShopkeeperRepository;
import com.scaler.omnicash.Omnicash.Repositories.TransactionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shopkeeper")
public class ShopkeeperController {

    ShopkeeperRepository shopkeeperRepository;
    TransactionRepository transactionRepository;

    @GetMapping("/set-daily-limit/{sid}/{limit}")
    public String setDailyLimit(@PathVariable(value = "sid")Long shopkeeperId,@PathVariable(value = "limit")Long limit) throws Exception {

        Shopkeeper shopkeeper = shopkeeperRepository.findById(shopkeeperId).orElseThrow(()->new Exception("Shopkeeper not found."));
        shopkeeper.setDailyLimit(limit);
        shopkeeperRepository.save(shopkeeper);
        return "Daily Limit set successfully";
    }
    @GetMapping("/transfer-history/{uid}")
    public List<Transaction> transferHistory(@PathVariable(value = "sid")Long shopkeeperId){

        return transactionRepository.findByShopkeepers_Id(shopkeeperId);
    }

}
