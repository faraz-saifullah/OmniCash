package com.scaler.omnicash.Omnicash.Repositories;

import com.scaler.omnicash.Omnicash.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
