package com.capco.cartmanagement.application;

import com.capco.cartmanagement.application.service.CartService;
import com.capco.customermanagement.application.config.CustomerManagementModuleConfiguration;
import com.capco.customermanagement.application.service.CustomerService;
import com.capco.productmanagement.application.config.ProductManagementModuleConfiguration;
import com.capco.productmanagement.application.dto.ProductDto;
import com.capco.productmanagement.application.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.capco.cartmanagement.application.config.CartManagementModuleConfiguration;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {
    CartManagementModuleConfiguration.class,
    CustomerManagementModuleConfiguration.class,
    ProductManagementModuleConfiguration.class
})
@ActiveProfiles("test")
public class CartIntegrationTest {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    private String consumerId;
    private String bigBusinessId;
    private String smallBusinessId;
    private ProductDto laptop;
    private ProductDto midEndPhone;
    private ProductDto highEndPhone;

    @BeforeEach
    void setUp() {
        // Create test users
        consumerId = customerService.createConsumer("Jean","Dupont");
        bigBusinessId = customerService.createBusiness("Microsoft", "327733184", 100_000_000d);
        smallBusinessId = customerService.createBusiness("Dell", "351528229", 10_000d);

        // Create test products with pricing
        laptop = productService.createProduct("Laptop", 1200d,900d,1000d);
        midEndPhone = productService.createProduct("Mid End Phone",800d,550d, 600d);
        highEndPhone = productService.createProduct("High End Phone", 1500d,1000d,550d);
    }

    @Test
    void testCartTotalPriceForConsumer() {
        // Create cart for consumer
        String cartId = cartService.createCart(consumerId);
        
        // Add products with quantities
        cartService.addItem(cartId, laptop.getProductId(), 2);
        cartService.addItem(cartId, midEndPhone.getProductId(), 1);
        cartService.addItem(cartId, highEndPhone.getProductId(), 3);

        // Expected total: (2*1200) + (1*800) + (3*1500) = 2400 + 800 + 4500 = 7700
        assertEquals(7700d, cartService.getCart(cartId).getTotalPrice());
    }

    @Test
    void testCartTotalPriceForBusiness() {
        // Create cart for Microsoft (big business)
        String cartId = cartService.createCart(bigBusinessId);
        
        // Add products with quantities
        cartService.addItem(cartId, laptop.getProductId(), 5);
        cartService.addItem(cartId, midEndPhone.getProductId(), 2);
        cartService.addItem(cartId, highEndPhone.getProductId(), 4);

        // Expected total: (5*900) + (2*550) + (4*1000) = 1800 + 1100 + 4000 = 8500
        assertEquals(9600d, cartService.getCart(cartId).getTotalPrice());
    }

    @Test
    void testCartPriceAfterQuantityUpdate() {
        // Create cart for Dell (small business)
        String cartId = cartService.createCart(smallBusinessId);
        
        // Add initial products
        cartService.addItem(cartId, laptop.getProductId(), 1);
        cartService.addItem(cartId, midEndPhone.getProductId(), 1);
        
        // Verify initial total: (1*1000) + (1*600) = 1600
        assertEquals(1600d, cartService.getCart(cartId).getTotalPrice());
        
        // Update quantities
        cartService.updateItemQuantity(cartId, laptop.getProductId(), 3);
        cartService.updateItemQuantity(cartId, midEndPhone.getProductId(), 2);
        
        // Verify updated total: (3*1000) + (2*600) = 3000 + 1200 = 4200
        assertEquals(4200d, cartService.getCart(cartId).getTotalPrice());
    }
}
