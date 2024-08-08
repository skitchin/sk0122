package com.kitchin.sk0122;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a rental agreement for a tool.
 */
public class Agreement {
    private String toolCode;
    private String toolType;
    private String toolBrand;
    private int rentalDays;
    private LocalDate checkoutDate;
    private LocalDate dueDate;
    private double dailyRentalCharge;
    private int chargeDays;
    private double preDiscountCharge;
    private int discountPercent;
    private double discountAmount;
    private double finalCharge;

    /**
     * Constructs a new Agreement.
     *
     * @param toolCode The code of the tool being rented.
     * @param toolType The type of the tool.
     * @param toolBrand The brand of the tool.
     * @param rentalDays The number of days the tool is rented.
     * @param checkoutDate The date the rental begins.
     * @param dueDate The date the rental ends.
     * @param dailyRentalCharge The daily charge for the tool.
     * @param chargeDays The number of days charges apply.
     * @param preDiscountCharge The total charge before discounts.
     * @param discountPercent The discount percentage applied.
     * @param discountAmount The amount discounted.
     * @param finalCharge The final charge after discount.
     */
    public Agreement(String toolCode, String toolType, String toolBrand, int rentalDays, LocalDate checkoutDate,
                     LocalDate dueDate, double dailyRentalCharge, int chargeDays, double preDiscountCharge,
                     int discountPercent, double discountAmount, double finalCharge) {
        this.toolCode = toolCode;
        this.toolType = toolType;
        this.toolBrand = toolBrand;
        this.rentalDays = rentalDays;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
        this.dailyRentalCharge = dailyRentalCharge;
        this.chargeDays = chargeDays;
        this.preDiscountCharge = preDiscountCharge;
        this.discountPercent = discountPercent;
        this.discountAmount = discountAmount;
        this.finalCharge = finalCharge;
    }

    public int getChargeDays() {
        return chargeDays;
    }

    public double getPreDiscountCharge() {
        return preDiscountCharge;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public double getFinalCharge() {
        return finalCharge;
    }

    public void printAgreement() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");

        System.out.printf("Tool code: %s%n", toolCode);
        System.out.printf("Tool type: %s%n", toolType);
        System.out.printf("Tool brand: %s%n", toolBrand);
        System.out.printf("Rental days: %d%n", rentalDays);
        System.out.printf("Check out date: %s%n", checkoutDate.format(formatter));
        System.out.printf("Due date: %s%n", dueDate.format(formatter));
        System.out.printf("Daily rental charge: $%.2f%n", dailyRentalCharge);
        System.out.printf("Charge days: %d%n", chargeDays);
        System.out.printf("Pre-discount charge: $%.2f%n", preDiscountCharge);
        System.out.printf("Discount percent: %d%%%n", discountPercent);
        System.out.printf("Discount amount: $%.2f%n", discountAmount);
        System.out.printf("Final charge: $%.2f%n", finalCharge);
        System.out.printf("\n");
    }
}