module capco.cart.management {
    exports com.capco.cartmanagement.application.service;
    exports com.capco.cartmanagement.application.config;
    exports com.capco.cartmanagement.application.dto;
    requires static lombok;
    requires capco.shared;
    requires capco.product.management;
    requires capco.customer.management;
    requires spring.context;
}