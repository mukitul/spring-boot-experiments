package com.app.springdataexp.cacheexp;

import com.app.springdataexp.specexp.Product;
import com.app.springdataexp.specexp.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CacheService {
    private final ProductRepository productRepository;
    private final List<Product> productList = new ArrayList<>();

    @PostConstruct
    private void populateData() {
        productRepository.deleteAll();

        for (int i = 0; i < 10000; i++) {
            Product product = new Product();
            product.setProductName("PD_" + i);
            product.setPrice(100.0);
            productList.add(product);
        }
        productRepository.saveAll(productList);
    }

    @Cacheable(cacheNames = "allProductCache")
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Cacheable(value = "products")
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}