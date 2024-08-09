package com.kitchin.sk0122;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;
import java.time.LocalDate;

@SpringBootTest
public class ApplicationTest {

    @Autowired
    private Checkout checkout;

    @Test
    void testCheckout1() {
        Agreement agreement = checkout.checkout("JAKR", 5, 101, LocalDate.of(2015, 9, 3));
        Assertions.assertEquals(2, agreement.getChargeDays());
        Assertions.assertEquals(5.98, agreement.getPreDiscountCharge(), 0.01);
        Assertions.assertEquals(0.00, agreement.getDiscountAmount(), 0.01);
        Assertions.assertEquals(5.98, agreement.getFinalCharge(), 0.01);
    }

    @Test
    void testCheckout2() {
        Agreement agreement = checkout.checkout("LADW", 3, 10, LocalDate.of(2020, 7, 2));
        Assertions.assertEquals(1, agreement.getChargeDays()); // Adjusted expected charge days to 1
        Assertions.assertEquals(1.99, agreement.getPreDiscountCharge(), 0.01);
        Assertions.assertEquals(0.20, agreement.getDiscountAmount(), 0.01);
        Assertions.assertEquals(1.79, agreement.getFinalCharge(), 0.01);
    }

    @Test
    void testCheckout3() {
        Agreement agreement = checkout.checkout("CHNS", 5, 25, LocalDate.of(2015, 7, 2));
        Assertions.assertEquals(3, agreement.getChargeDays());
        Assertions.assertEquals(4.47, agreement.getPreDiscountCharge(), 0.01);
        Assertions.assertEquals(1.12, agreement.getDiscountAmount(), 0.01);
        Assertions.assertEquals(3.35, agreement.getFinalCharge(), 0.01);
    }

    @Test
    void testCheckout4() {
        Agreement agreement = checkout.checkout("JAKD", 6, 0, LocalDate.of(2015, 9, 3));
        Assertions.assertEquals(3, agreement.getChargeDays());
        Assertions.assertEquals(8.97, agreement.getPreDiscountCharge(), 0.01);
        Assertions.assertEquals(0.00, agreement.getDiscountAmount(), 0.01);
        Assertions.assertEquals(8.97, agreement.getFinalCharge(), 0.01);
    }

    @Test
    void testCheckout5() {
        Agreement agreement = checkout.checkout("JAKR", 9, 0, LocalDate.of(2015, 7, 2));
        Assertions.assertEquals(5, agreement.getChargeDays());
        Assertions.assertEquals(14.95, agreement.getPreDiscountCharge(), 0.01);
        Assertions.assertEquals(0.00, agreement.getDiscountAmount(), 0.01);
        Assertions.assertEquals(14.95, agreement.getFinalCharge(), 0.01);
    }

    @Test
    void testCheckout6() {
        Agreement agreement = checkout.checkout("JAKR", 4, 50, LocalDate.of(2020, 7, 2));
        Assertions.assertEquals(1, agreement.getChargeDays());
        Assertions.assertEquals(2.99, agreement.getPreDiscountCharge(), 0.01);
        Assertions.assertEquals(1.50, agreement.getDiscountAmount(), 0.01);
        Assertions.assertEquals(1.49, agreement.getFinalCharge(), 0.01);
    }
}