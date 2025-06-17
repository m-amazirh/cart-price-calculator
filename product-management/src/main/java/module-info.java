module capco.product.management {
    requires static lombok;
    requires capco.shared;
    requires spring.context;
    exports com.capco.productmanagement.application.dto;
    exports com.capco.productmanagement.application.service;
    exports com.capco.productmanagement.application.config;

    opens com.capco.productmanagement.application.config;
}