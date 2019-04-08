package com.moneyxchange.app.services.mock;

import com.moneyxchange.app.domain.Currency;
import com.moneyxchange.app.consts.InstanceConstants;
import com.moneyxchange.app.resources.model.RateResumeModel;
import com.moneyxchange.app.services.RateService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service(InstanceConstants.RATE_MOCK_SERVICE_IMPL)
public class RateMockServiceImpl implements RateService {

    @Override
    public Optional<RateResumeModel> getLatest(String base) {
        if (!StringUtils.hasText(base)) {
            base = Currency.USD.getShortName();
        }
        RateResumeModel rateResume = new RateResumeModel(base, LocalDate.now());
        rateResume.setRates(getRates());
        return Optional.of(rateResume);
    }

    @Override
    public Optional<RateResumeModel> getLatest(String base, String currency) {
        if (!StringUtils.hasText(base)) {
            base = Currency.USD.getShortName();
        }
        RateResumeModel rateResume = new RateResumeModel(base, LocalDate.now());
        Map<String, Double> rates = new HashMap<>();
        rates.put(currency, 0.87912);
        rateResume.setRates(rates);
        return Optional.of(rateResume);
    }

    private Map<String, Double> getRates() {
        Map<String, Double> rates = new HashMap<>();
        rates.put(Currency.EUR.getShortName(), 0.87912);
        rates.put(Currency.PEN.getShortName(), 3.54018);
        rates.put(Currency.MEX.getShortName(), 2.20542);
        rates.put(Currency.RUB.getShortName(), 1.61844);
        return rates;
    }

}
