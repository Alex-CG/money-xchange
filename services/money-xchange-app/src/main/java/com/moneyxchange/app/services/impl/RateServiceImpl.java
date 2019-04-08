package com.moneyxchange.app.services.impl;

import com.moneyxchange.app.consts.InstanceConstants;
import com.moneyxchange.app.data.entities.Rate;
import com.moneyxchange.app.data.repo.RateRepository;
import com.moneyxchange.app.resources.model.RateResumeModel;
import com.moneyxchange.app.services.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service(InstanceConstants.RATE_SERVICE_IMPL)
public class RateServiceImpl implements RateService {

    @Autowired
    private RateRepository rateRepository;

    @Override
    public Optional<RateResumeModel> getLatest(String base) {
        Iterable<Rate> ratesIterable = rateRepository.findAllByBase(base);
        RateResumeModel resume = new RateResumeModel(base, LocalDate.now());
        Map<String, Double> rates = StreamSupport.stream(ratesIterable.spliterator(), true)
                .collect(Collectors.toMap(Rate::getCurrency, Rate::getRate));
        resume.setRates(rates);
        return Optional.of(resume);
    }

    @Override
    public Optional<RateResumeModel> getLatest(String base, String currency) {
        Optional<Rate> optRate = rateRepository.findByBaseAndCurrency(base, currency);
        RateResumeModel resume = new RateResumeModel(base, LocalDate.now());
        optRate.ifPresent(r -> resume.getRates().put(r.getCurrency(), r.getRate()));
        return Optional.of(resume);
    }

}
