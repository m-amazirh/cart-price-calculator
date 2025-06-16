package com.capco.pricecalculator;
import com.capco.cartmanagement.application.config.CartManagementModuleConfiguration;
import com.capco.cartmanagement.application.dto.CartItemDto;
import com.capco.cartmanagement.application.dto.CartSummaryDto;
import com.capco.cartmanagement.application.service.CartService;
import com.capco.customermanagement.application.config.CustomerManagementModuleConfiguration;
import com.capco.customermanagement.application.dto.CustomerDto;
import com.capco.customermanagement.application.service.CustomerService;
import com.capco.productmanagement.application.config.ProductManagementModuleConfiguration;
import com.capco.productmanagement.application.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import java.util.List;

@SpringBootApplication
@Import({
        CustomerManagementModuleConfiguration.class,
        ProductManagementModuleConfiguration.class,
        CartManagementModuleConfiguration.class
})
@AllArgsConstructor
public class CartPriceCalculatorApp implements CommandLineRunner {
    private final CartService cartService;
    private final ProductService productService;
    private final CustomerService customerService;

    public static void main(String[] args) {
        SpringApplication.run(CartPriceCalculatorApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ExerciceData data = loadExcercieData();
        String consumerCartId = cartService.createCart(data.consumerId);
        String bigBusinessCartId = cartService.createCart(data.bigBusinessId);
        String smallBusinessCartId = cartService.createCart(data.smallBusinessId);

        List<String> cartsIds = List.of(consumerCartId, smallBusinessCartId, bigBusinessCartId);

        for(String cartId : cartsIds){
            cartService.addItem(cartId, data.laptopProductId, 2);
            cartService.addItem(cartId, data.highEndPhoneProductId, 3);
            cartService.addItem(cartId, data.midEndPhoneProductId, 2);
        }

        for(String cartId : cartsIds){
            printCartSummary(cartId);
        }

    }

    public void printCartSummary(String cartId){
        CartSummaryDto summary = cartService.getCart(cartId);
        CustomerDto customer = customerService.getCustomer(summary.getCustomerId());

        String headerFormat = "|%-15s|%-15s|%-15s|%-15s|%n";
        String rowFormat   = "|%-15s|%-15.2f|%-15d|%-15.2f|%n";

        System.out.println(String.format("Cart Id : %s", cartId));
        System.out.println(String.format("Customer's Name : %s", customer.getName()));
        System.out.println(String.format("Cart Items", customer.getName()));
        System.out.format(headerFormat, "Product Name","Unit Price","Quantity","Item's Final Price");
        for(CartItemDto item : summary.getItems()){
            System.out.format(rowFormat, item.getProductName(), item.getUnitPrice(), item.getQuantity(), item.getTotalPrice());
        }
        System.out.println(String.format("Cart's Total Price : %-15.2f", summary.getTotalPrice()));
    }

    public ExerciceData loadExcercieData(){
        ExerciceData data = new ExerciceData();
        data.setConsumerId(customerService.createConsumer("Jean","Dupont"));
        data.setSmallBusinessId(customerService.createBusiness("Dell", "351528229", 1000d));
        data.setBigBusinessId(customerService.createBusiness("Microsoft", "327733184", 100_000_000d));

        data.setLaptopProductId(
                productService.createProduct("Laptop",
                                1200d,
                                900d,
                                1000d)
                .getProductId());

        data.setHighEndPhoneProductId(
                productService.createProduct("High End Phone",
                                1500d,
                                1000d,
                                1150d)
                        .getProductId());

        data.setMidEndPhoneProductId(
                productService.createProduct("Mid End Phone",
                                800d,
                                550d,
                                600d)
                        .getProductId());

        return data;
    }


    @Data
    class ExerciceData{
        private String consumerId;
        private String smallBusinessId;
        private String bigBusinessId;
        private String highEndPhoneProductId;
        private String midEndPhoneProductId;
        private String laptopProductId;
    }

}
