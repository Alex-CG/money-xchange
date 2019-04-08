package com.moneyxchange.app.resources.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Data
public class RateResumeModel {

    private String base;
    private LocalDate date;
    private Map<String, Double> rates;

    public RateResumeModel(String base, LocalDate date) {
        this.base = base;
        this.date = date;
        this.rates = new HashMap<>();
    }

}
