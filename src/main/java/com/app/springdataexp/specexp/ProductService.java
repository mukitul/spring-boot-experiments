package com.app.springdataexp.specexp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAll(SearchQueryDto queryDto) {
        List<Product> productList = productRepository.findAll();
        return productList;
    }
}
