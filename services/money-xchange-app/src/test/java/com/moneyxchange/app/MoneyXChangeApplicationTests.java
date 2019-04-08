package com.moneyxchange.app;

import com.moneyxchange.app.domain.Currency;
import com.moneyxchange.app.config.AppConfig;
import com.moneyxchange.app.data.entities.Rate;
import com.moneyxchange.app.data.repo.RateRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppConfig.class)
public class MoneyXChangeApplicationTests {

	@Autowired
	private RateRepository rateRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void loadCurrenciesForASingleBase() {
		Iterable<Rate> rates = rateRepository.findAllByBase(Currency.USD.getShortName());
		Iterator<Rate> rateIterator = rates.iterator();
		System.out.print("XXXXXXXXXXXXXXXXXXXX :");
		boolean hashNext = rateIterator.hasNext();
		System.out.print(hashNext);
		System.out.print(": XXXXXXXXXXXXXXXXXXXX");
		Assert.assertTrue(hashNext);
	}

	@Test
	public void loadSingleRateForBaseAndCurrency() {
		Optional<Rate> rate = rateRepository.findByBaseAndCurrency(Currency.USD.getShortName(), Currency.EUR.getShortName());
		System.out.print("XXXXXXXXXXXXXXXXXXXX :");
		System.out.print(rate.get().getBase());
		System.out.print(": XXXXXXXXXXXXXXXXXXXX");
		Assert.assertNotNull(rate.get());
	}

}
