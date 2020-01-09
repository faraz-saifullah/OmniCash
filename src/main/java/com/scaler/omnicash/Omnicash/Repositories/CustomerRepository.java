package com.scaler.omnicash.Omnicash.Repositories;

import com.scaler.omnicash.Omnicash.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
