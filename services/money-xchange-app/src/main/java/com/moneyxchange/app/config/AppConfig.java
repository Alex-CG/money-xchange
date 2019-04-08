package com.moneyxchange.app.config;

import com.moneyxchange.app.consts.Constants;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = Constants.PKG_BASE)
public class AppConfig {
}
