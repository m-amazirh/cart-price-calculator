module capco.customer.management {
    requires static lombok;
    requires capco.shared;
    requires spring.context;

    exports com.capco.customermanagement.application.service;
    exports com.capco.customermanagement.application.dto;
    exports com.capco.customermanagement.application.config;
}