package com.kitchin.sk0122;

import java.time.LocalDate;

public class RentalData {

    /**
     * Retrieves an array of rental data. Each element in the array is an object array containing:
     *
     *   Tool code (String)
     *   Rental days (int)
     *   Discount percentage (int)
     *   Checkout date (LocalDate)
     *
     * @return a 2D array of rental data.
     */
    public static Object[][] getRentals() {
        return new Object[][]{
                {"JAKR", 5, 101, LocalDate.of(2015, 9, 3)},
                {"LADW", 3, 10, LocalDate.of(2020, 7, 2)},
                {"CHNS", 5, 25, LocalDate.of(2015, 7, 2)},
                {"JAKD", 6, 0, LocalDate.of(2015, 9, 3)},
                {"JAKR", 9, 0, LocalDate.of(2015, 7, 2)},
                {"JAKR", 4, 50, LocalDate.of(2020, 7, 2)}
        };
    }
}
