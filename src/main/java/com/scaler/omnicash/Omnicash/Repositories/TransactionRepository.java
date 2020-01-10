package com.scaler.omnicash.Omnicash.Repositories;

import com.scaler.omnicash.Omnicash.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    List<Transaction> findByShopkeepers_Id(Long id);
    List<Transaction> findByCustomers_Id(Long id);
}
