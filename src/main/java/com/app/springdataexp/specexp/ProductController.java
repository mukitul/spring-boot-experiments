package com.app.springdataexp.specexp;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @RequestMapping(value = "/get-all", method = RequestMethod.POST)
    public ResponseEntity<?> getRequiredDocument(@Valid @RequestBody SearchQueryDto queryDto) {
        List<Product> response = productService.getAll(queryDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
