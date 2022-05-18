package com.example.demo.Purchase;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public List<Purchase> getPurchases() {
        return purchaseRepository.findAll();
    }

    public void addNewPurchase(Purchase purchase) {
        Optional<Purchase> foundOrder = purchaseRepository.findByOrderNumber(purchase.getOrderNumber());
        if (foundOrder.isPresent()) {
            throw new IllegalStateException("Order is already being processed");
        } else {
            purchaseRepository.save(purchase);
        }
    }

    public void deletePurchase(Long purchaseId) {
        if (!purchaseRepository.existsById(purchaseId)) {
            throw new IllegalStateException("purchase with id: " + purchaseId + " does not exist");
        } else {
            purchaseRepository.deleteById(purchaseId);
        }
    }

}