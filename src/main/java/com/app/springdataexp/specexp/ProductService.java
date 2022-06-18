package com.app.springdataexp.specexp;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllBasicImpl(SearchQueryDto queryDto) {
        ProductSpecification productSpecification = new ProductSpecification();
        productSpecification.add(queryDto);
        return productRepository.findAll(productSpecification);
    }

    public List<Product> getAll(SearchQueryDto queryDto) {
        Specification<Product> productSpecification = _findAllExampleOne(queryDto);
        return productRepository.findAll(productSpecification);
    }

    public List<Product> getAllWithLambda(SearchQueryDto queryDto) {
        Specification<Product> productSpecification = _findAllExampleWithLambda(queryDto);
        return productRepository.findAll(productSpecification);
    }

    private Specification<Product> _findAllExampleOne(SearchQueryDto queryDto) {
        return new Specification<Product>() {
            final List<Predicate> predicateList = new ArrayList<>();

            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (queryDto.getProductName() != null) {
                    predicateList.add(criteriaBuilder.equal(root.get(Product_.PRODUCT_NAME), queryDto.getProductName()));
                }
                if (queryDto.getPrice() != null) {
                    predicateList.add(criteriaBuilder.equal(root.get(Product_.PRICE), queryDto.getPrice()));
                }
                if (queryDto.getProductType() != null) {
                    predicateList.add(criteriaBuilder.equal(root.get(Product_.PRODUCT_TYPE), queryDto.getProductType()));
                }
                return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
            }
        };
    }

    private Specification<Product> _findAllExampleWithLambda(SearchQueryDto queryDto) {
        return ((root, query, criteriaBuilder) -> {
            final List<Predicate> predicateList = new ArrayList<>();
            if (queryDto.getProductName() != null) {
                predicateList.add(criteriaBuilder.equal(root.get(Product_.PRODUCT_NAME), queryDto.getProductName()));
            }
            if (queryDto.getPrice() != null) {
                predicateList.add(criteriaBuilder.equal(root.get(Product_.PRICE), queryDto.getPrice()));
            }
            if (queryDto.getProductType() != null) {
                predicateList.add(criteriaBuilder.equal(root.get(Product_.PRODUCT_TYPE), queryDto.getProductType()));
            }
            return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
        });
    }
}