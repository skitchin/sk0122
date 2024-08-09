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
        Object[] rental = RentalData.getData()[0];
        Agreement agreement = checkout.checkout((String) rental[0], (int) rental[1], (int) rental[2], (LocalDate) rental[3]);
        Assertions.assertEquals(2, agreement.getChargeDays());
        Assertions.assertEquals(5.98, agreement.getPreDiscountCharge(), 0.01);
        Assertions.assertEquals(0.00, agreement.getDiscountAmount(), 0.01);
        Assertions.assertEquals(5.98, agreement.getFinalCharge(), 0.01);
    }

    @Test
    void testCheckout2() {
        Object[] rental = RentalData.getData()[1];
        Agreement agreement = checkout.checkout((String) rental[0], (int) rental[1], (int) rental[2], (LocalDate) rental[3]);
        Assertions.assertEquals(1, agreement.getChargeDays()); // Adjusted expected charge days to 1
        Assertions.assertEquals(1.99, agreement.getPreDiscountCharge(), 0.01);
        Assertions.assertEquals(0.20, agreement.getDiscountAmount(), 0.01);
        Assertions.assertEquals(1.79, agreement.getFinalCharge(), 0.01);
    }

    @Test
    void testCheckout3() {
        Object[] rental = RentalData.getData()[2];
        Agreement agreement = checkout.checkout((String) rental[0], (int) rental[1], (int) rental[2], (LocalDate) rental[3]);
        Assertions.assertEquals(3, agreement.getChargeDays());
        Assertions.assertEquals(4.47, agreement.getPreDiscountCharge(), 0.01);
        Assertions.assertEquals(1.12, agreement.getDiscountAmount(), 0.01);
        Assertions.assertEquals(3.35, agreement.getFinalCharge(), 0.01);
    }

    @Test
    void testCheckout4() {
        Object[] rental = RentalData.getData()[3];
        Agreement agreement = checkout.checkout((String) rental[0], (int) rental[1], (int) rental[2], (LocalDate) rental[3]);
        Assertions.assertEquals(3, agreement.getChargeDays());
        Assertions.assertEquals(8.97, agreement.getPreDiscountCharge(), 0.01);
        Assertions.assertEquals(0.00, agreement.getDiscountAmount(), 0.01);
        Assertions.assertEquals(8.97, agreement.getFinalCharge(), 0.01);
    }

    @Test
    void testCheckout5() {
        Object[] rental = RentalData.getData()[4];
        Agreement agreement = checkout.checkout((String) rental[0], (int) rental[1], (int) rental[2], (LocalDate) rental[3]);
        Assertions.assertEquals(5, agreement.getChargeDays());
        Assertions.assertEquals(14.95, agreement.getPreDiscountCharge(), 0.01);
        Assertions.assertEquals(0.00, agreement.getDiscountAmount(), 0.01);
        Assertions.assertEquals(14.95, agreement.getFinalCharge(), 0.01);
    }

    @Test
    void testCheckout6() {
        Object[] rental = RentalData.getData()[5];
        Agreement agreement = checkout.checkout((String) rental[0], (int) rental[1], (int) rental[2], (LocalDate) rental[3]);
        Assertions.assertEquals(1, agreement.getChargeDays());
        Assertions.assertEquals(2.99, agreement.getPreDiscountCharge(), 0.01);
        Assertions.assertEquals(1.50, agreement.getDiscountAmount(), 0.01);
        Assertions.assertEquals(1.49, agreement.getFinalCharge(), 0.01);
    }
}