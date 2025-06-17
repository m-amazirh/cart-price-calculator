package com.capco.pricecalculator.application.command;

import com.capco.cartmanagement.application.dto.CartItemDto;
import com.capco.cartmanagement.application.dto.CartSummaryDto;
import com.capco.cartmanagement.application.service.CartService;
import com.capco.customermanagement.application.dto.CustomerDto;
import com.capco.customermanagement.application.service.CustomerService;
import com.capco.shared.application.exception.CartNotFound;
import com.capco.shared.application.exception.CustomerNotFound;
import com.capco.shared.application.exception.ProductNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Command(command = "cart")
@Component
@RequiredArgsConstructor
public class CartCommand {
    private final CartService cartService;
    private final CustomerService customerService;

    @Command(command = "create", description = "Create a cart for a customer")
    public void create(@Option(required = true) String customerId) {
        try {
            CustomerDto customerDto = customerService.getCustomer(customerId);
            String cartId = cartService.createCart(customerDto.getCustomerId());
            System.out.println(String.format("Cart created. Id : %s", cartId));
        } catch (CustomerNotFound ex) {
            System.out.println("Customer not found");
        }
    }

    @Command(command = "add", description = "Add an item to a cart")
    public void add(@Option(required = true, description = "Cart id to update") String cartId,
                    @Option(required = true, description = "Product id to use") String productId,
                    @Option(description = "Quantity to add. default value is 1") Integer quantity) {
        try {
            cartService.addItem(cartId, productId, Optional.ofNullable(quantity).orElse(1));
        } catch (CartNotFound ex) {
            System.out.println("Cart not found");
        } catch (ProductNotFound ex) {
            System.out.println("Product not found");
        }
    }

    @Command(command = "updateQuantity", description = "Update quantity of a product in a cart.")
    public void updateQuantity(@Option(required = true) String cartId,
                               @Option(required = true) String productId,
                               @Option(required = true, description = "New quantity. If zero the product is removed from the cart") Integer quantity) {
        try {
            cartService.updateItemQuantity(cartId, productId, quantity);
        } catch (CartNotFound ex) {
            System.out.println("Cart not found");
        } catch (ProductNotFound ex) {
            System.out.println("Product not found");
        }
    }

    @Command(command = "summary", description = "Display a summary of a cart")
    public void summary(@Option(required = true) String cartId) {
        try {
            CartSummaryDto summary = cartService.getCart(cartId);
            CustomerDto customer = customerService.getCustomer(summary.getCustomerId());

            String headerFormat = "%-20s%-20s%-20s%-20s%n";
            String rowFormat = "%-20s%-20.2f%-20d%-20.2f%n";

            System.out.println(String.format("Cart Id : %s", cartId));
            System.out.println(String.format("Customer's Name : %s", customer.getName()));
            System.out.println("Cart Items");
            System.out.format(headerFormat, "Product Name", "Unit Price", "Quantity", "Item's Final Price");
            System.out.println("---------------------------------------------------------------------------");
            for (CartItemDto item : summary.getItems()) {
                System.out.format(rowFormat, item.getProductName(), item.getUnitPrice(), item.getQuantity(), item.getTotalPrice());
            }
            System.out.println(String.format("Cart's Total Price : %-15.2f", summary.getTotalPrice()));
        } catch (CartNotFound ex) {
            System.out.println("Cart not found");
        }
    }
}
