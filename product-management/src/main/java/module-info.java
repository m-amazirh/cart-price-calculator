module capco.product.management {
    requires static lombok;
    requires capco.shared;
    exports com.capco.productmanagement.application.dto;
    exports com.capco.productmanagement.application.service;
}