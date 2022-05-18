package com.example.demo.Purchase;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    @Query("SELECT s FROM Purchase s WHERE s.orderNumber = ?1")
    Optional<Purchase> findByOrderNumber(String orderNumber);

}
