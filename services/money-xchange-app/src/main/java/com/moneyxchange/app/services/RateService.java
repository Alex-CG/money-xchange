package com.moneyxchange.app.services;

import com.moneyxchange.app.resources.model.RateResumeModel;

import java.util.Optional;

public interface RateService {

    Optional<RateResumeModel> getLatest(String base);

    Optional<RateResumeModel> getLatest(String base, String currency);

}
