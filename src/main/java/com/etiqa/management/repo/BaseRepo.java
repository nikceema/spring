package com.etiqa.management.repo;

import com.etiqa.management.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepo extends JpaRepository<Customer, Long> {
}
