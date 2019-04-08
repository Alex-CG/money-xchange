package com.moneyxchange.app;

import com.moneyxchange.app.config.AppConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AppConfig.class)
public class MoneyXChangeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MoneyXChangeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

}
