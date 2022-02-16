package com.app.springdataexp.enumexp;

public enum CountryCode {
    ONE("1"),
    EIGHT_EIGHT_ZERO("880");

    private final String countryCode;

    CountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
