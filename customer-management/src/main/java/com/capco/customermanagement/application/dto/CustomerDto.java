package com.capco.customermanagement.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDto {
    String customerId;
    String name;
    String category;
}
