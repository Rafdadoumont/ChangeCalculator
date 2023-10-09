package com.example.changecalculator;

public enum ChangeEnum {
    FIVE_HUNDRED_EURO(500, "500Euro"),
    TWO_HUNDRED_EURO(200, "200Euro"),
    ONE_HUNDRED_EURO(100, "100Euro"),
    FIFTY_EURO(50, "50Euro"),
    TWENTY_EUR0(20, "20Euro"),
    TEN_EURO(10, "10Euro"),
    FIVE_EURO(5, "5Euro"),
    TWO_EURO(2, "2Euro"),
    ONE_EURO(1, "1Euro"),
    FIFTY_EURO_CENT(.50, "50EuroCent"),
    TWENTY_EURO_CENT(.20, "20EuroCent"),
    TEN_EURO_CENT(.10, "10EuroCent"),
    FIVE_EURO_CENT(.05, "5EuroCent"),
    TWO_EURO_CENT(.02, "2EuroCent"),
    ONE_EURO_CENT(0.01, "1EuroCent");
    private final double value;
    private final String stringValue;

    ChangeEnum(double value, String stringValue) {
        this.value = value;
        this.stringValue = stringValue;
    }

    public double getValue() {
        return value;
    }

    public String getStringValue() {
        return stringValue;
    }
}
