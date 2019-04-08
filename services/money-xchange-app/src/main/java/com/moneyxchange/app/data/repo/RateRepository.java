package com.moneyxchange.app.data.repo;

import com.moneyxchange.app.data.entities.Rate;

import java.util.Optional;

public interface RateRepository extends CustomCrudRepository<Rate, String> {

    Iterable<Rate> findAllByBase(String base);

    Optional<Rate> findByBaseAndCurrency(String base, String currency);

}
