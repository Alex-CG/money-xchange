package com.moneyxchange.app.domain;

public enum Currency {

    USD("USD", "American Dollar"),
    EUR("EUR", "Euro"),
    PEN("PEN", "Peruvian Nuevo Sol"),
    MEX("MEX", "Mexican pesos"),
    RUB("RUB", "Rublos");

    private String shortName;
    private String name;

    Currency(String shortName, String name) {
        this.shortName = shortName;
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public String getName() {
        return name;
    }

}
