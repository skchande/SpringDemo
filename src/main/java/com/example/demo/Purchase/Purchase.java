package com.example.demo.Purchase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table
public class Purchase {

    @Id
    @SequenceGenerator(name = "purchase_sequence", sequenceName = "purchase_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "purchase_sequence")
    private Long id;
    @NaturalId
    @Column(nullable = false, updatable = false, unique = true, length = 5)
    private String orderNumber;
    private String productName;
    private String buyerName;

    public Purchase() {

    }

    public Purchase(Long id, String orderNumber, String productName, String buyerName) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.productName = productName;
        this.buyerName = buyerName;
    }

    public Purchase(String orderNumber, String productName, String buyerName) {
        this.orderNumber = orderNumber;
        this.productName = productName;
        this.buyerName = buyerName;
    }

    public Purchase(String productName, String buyerName) {
        this.productName = productName;
        this.buyerName = buyerName;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBuyerName() {
        return this.buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String toOrderedString() {
        return this.id + "," + this.orderNumber + "," + this.productName + "," + this.buyerName;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + this.id +
                ", orderNumber=" + this.orderNumber + '\'' +
                ", productName=" + this.productName + '\'' +
                ", buyerName=" + this.buyerName + '\'' +
                "}";
    }

}
