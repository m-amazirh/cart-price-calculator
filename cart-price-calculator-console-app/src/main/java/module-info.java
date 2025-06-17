module capco.price.calculator.app {
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires capco.cart.management;
    requires static lombok;
    requires capco.product.management;
    requires capco.customer.management;
    requires spring.context;
    requires spring.shell.core;
    requires jakarta.annotation;
    requires capco.shared;

    exports com.capco.pricecalculator;
    exports com.capco.pricecalculator.application.command;
    exports com.capco.pricecalculator.application.utils;
    exports com.capco.pricecalculator.application.config;


}