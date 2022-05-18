package com.example.demo.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public void addNewProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        if (!productRepository.existsById(productId)) {
            throw new IllegalStateException("product with id: " + productId + " does not exist");
        } else {
            productRepository.deleteById(productId);
        }
    }

    @Transactional
    public void updateProduct(Long productId, String name, float price) {

        Product product = productRepository.findById(productId).orElse(null);

        if (product == null) {
            throw new IllegalStateException("product with id: " + productId + " does not exist");
        } else {
            product.setName(name);
            product.setPrice(price);
        }
    }

}