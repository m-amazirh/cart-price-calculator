package com.capco.pricecalculator.application.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods=false)
@ComponentScan(basePackages = "com.capco.pricecalculator.application")
public class PriceCalculatorConfiguration {
}
