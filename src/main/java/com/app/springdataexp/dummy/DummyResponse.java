package com.app.springdataexp.dummy;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DummyResponse {
    private int rank;
    private String docTitle;
    private String docLink;
}
