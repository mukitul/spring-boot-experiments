package com.app.springdataexp.cacheexp;

import com.app.springdataexp.specexp.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cache")
@RequiredArgsConstructor
public class CacheController {
    private final CacheService cacheService;

    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        List<Product> response = cacheService.getAllProduct();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Product response = cacheService.getProductById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
