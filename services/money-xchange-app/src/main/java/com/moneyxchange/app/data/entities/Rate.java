package com.moneyxchange.app.data.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "rate")
public class Rate {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "base")
    private String base;

    @Column(name = "currency")
    private String currency;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "rate")
    private Double rate;

}
