package com.etiqa.management.repo;

import com.etiqa.management.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    /*@Query(value = "SELECT c FROM Customer c WHERE c.id = :id")
    Optional<Customer> findById(@Param("id") UUID id);

    @Query(value = " DELETE FROM Customer c where c.id = :id")
    void deleteById(@Param("id") UUID id);*/

}
