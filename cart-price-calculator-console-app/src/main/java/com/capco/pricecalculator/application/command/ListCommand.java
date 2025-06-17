package com.capco.pricecalculator.application.command;

import com.capco.cartmanagement.application.service.CartService;
import com.capco.customermanagement.application.dto.CustomerDto;
import com.capco.customermanagement.application.service.CustomerService;
import com.capco.productmanagement.application.service.ProductService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.command.annotation.Command;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Command(command = "list")
@RequiredArgsConstructor
public class ListCommand {
    @NonNull
    private final CustomerService customerService;
    @NonNull
    private final ProductService productService;
    @NonNull
    private final CartService cartService;
    private final Map<String,String> categoryTranslation = Map.of("CONSUMER-CATEGORY", "Consumer", "BIG-BUSINESS-CATEGORY", "Big Business", "SMALL-BUSINESS-CATEGORY", "Small Business");

    @Command(command = "customers", description = "Lists all the customer")
    public void customers(){
        String format = "%-15s%-15s%-15s%n";
        System.out.format(format, "Name", "Category", "Id");
        System.out.println("---------------------------------------------------");
        customerService.getAllCustomers().forEach(customerDto -> {
            System.out.format(format, customerDto.getName(), categoryTranslation.get(customerDto.getCategory()), customerDto.getCustomerId());
        });
    }

    @Command(command = "products", description = "List all the products")
    public void products(){
        String format = "%-20s%-20s%-20s%-30s%-20s%n";
        System.out.format(format, "Name", "Consumer Price", "Big Business Price", "Small Business price", "Id");
        System.out.println("------------------------------------------------------------------------------------------------------");
        productService.getAllProducts().forEach(productDto -> {
            System.out.format(format,
                    productDto.getName(),
                    productDto.getPricing().get("CONSUMER-CATEGORY"),
                    productDto.getPricing().get("BIG-BUSINESS-CATEGORY"),
                    productDto.getPricing().get("SMALL-BUSINESS-CATEGORY"),
                    productDto.getProductId());
        });
    }

    @Command(command = "carts", description = "List all the carts")
    public void carts(){
        String format = "%-30s%-30s%n";
        System.out.format(format, "Customer Name", "Cart Id");
        System.out.println("---------------------------------------------------");
        cartService.getAllCarts().forEach(cartDto -> {
            CustomerDto customerDto = customerService.getCustomer(cartDto.getCustomerId());
            System.out.format(format, customerDto.getName(), cartDto.getCartId());
        });
    }
}
