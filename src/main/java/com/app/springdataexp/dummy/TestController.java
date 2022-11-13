package com.app.springdataexp.dummy;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@CrossOrigin(origins = "*", methods = {GET, POST, PUT, DELETE, OPTIONS}, allowedHeaders = "*")
@RestController
@RequestMapping("/test-api")
public class TestController {
    @PostMapping("/api-one")
    public List<DummyResponse> getCustomerById(@RequestBody DummyRequest dummyRequest) {
        return Arrays.asList(
                new DummyResponse(1, "TITLE-ONE", "TITLE-ONE-LINK"),
                new DummyResponse(2, "TITLE-TWO", "TITLE-ONE-LINK"),
                new DummyResponse(3, "TITLE-THREE", "TITLE-ONE-LINK"),
                new DummyResponse(4, "TITLE-FOUR", "TITLE-ONE-LINK")
        );
    }
}
