package com.app.springdataexp.specexp;

import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
public class ProductSpecification implements Specification<Product> {

    private List<SearchQueryDto> queryDtoList;

    public void add(SearchQueryDto queryDto) {
        queryDtoList.add(queryDto);
    }

    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        final List<Predicate> predicateList = new ArrayList<>();
        for (SearchQueryDto queryDto : queryDtoList) {
            if (queryDto.getProductName() != null) {
                predicateList.add(criteriaBuilder.equal(root.get(Product_.PRODUCT_NAME), queryDto.getProductName()));
            }
            if (queryDto.getMinPrice() != null) {
                predicateList.add(criteriaBuilder.equal(root.get(Product_.PRICE), queryDto.getMinPrice()));
            }
            if (queryDto.getProductType() != null) {
                predicateList.add(criteriaBuilder.equal(root.get(Product_.PRODUCT_TYPE), queryDto.getProductType()));
            }
        }
        return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
    }
}
