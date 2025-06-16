module capco.price.calculator.app {
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires capco.cart.management;
    requires static lombok;
    requires capco.product.management;
    requires capco.customer.management;
    requires spring.context;

    exports com.capco.pricecalculator;

}