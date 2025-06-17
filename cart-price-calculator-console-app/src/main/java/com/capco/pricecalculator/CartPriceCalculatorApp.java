package com.capco.pricecalculator;

import com.capco.cartmanagement.application.config.CartManagementModuleConfiguration;
import com.capco.customermanagement.application.config.CustomerManagementModuleConfiguration;
import com.capco.pricecalculator.application.config.PriceCalculatorConfiguration;
import com.capco.productmanagement.application.config.ProductManagementModuleConfiguration;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.shell.command.annotation.CommandScan;

@SpringBootApplication
@Import({
        PriceCalculatorConfiguration.class,
        CustomerManagementModuleConfiguration.class,
        ProductManagementModuleConfiguration.class,
        CartManagementModuleConfiguration.class,
})
@CommandScan(basePackages = "com.capco.pricecalculator.application.command")
@AllArgsConstructor
public class CartPriceCalculatorApp {

    public static void main(String[] args) {
        SpringApplication.run(CartPriceCalculatorApp.class, args);
    }


}
