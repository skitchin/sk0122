package com.kitchin.sk0122;

import org.springframework.stereotype.Service;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Map;

/**
 * Service class for handling tool checkouts.
 */
@Service
public class Checkout {

    /**
     * Processes a checkout for a tool rental.
     *
     * @param toolCode The tool code.
     * @param rentalDays The number of days the tool will be rented.
     * @param discountPercent The discount percentage to apply.
     * @param checkoutDate The start date of the rental.
     * @return A RentalAgreement detailing the terms of the rental.
     */
    public Agreement checkout(String toolCode, int rentalDays, int discountPercent, LocalDate checkoutDate) {
        if (rentalDays < 1) {
            throw new IllegalArgumentException("Rental day count must be 1 or greater.\n");
        }
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Discount percent must be between 0 and 100.\n");
        }

        // Retrieve the tools map from the Data class
        Map<String, Object> tools = ToolsData.getTools();

        // Cast the object to a Tool
        Tools tool = (Tools) tools.get(toolCode);
        if (tool == null) {
            throw new IllegalArgumentException("Invalid tool code: " + toolCode);
        }

        LocalDate dueDate = checkoutDate.plusDays(rentalDays);
        int chargeDays = calculateChargeDays(tool, checkoutDate.plusDays(1), dueDate);
        var preDiscountCharge = chargeDays * tool.getDailyCharge();
        var discountAmount = preDiscountCharge * discountPercent / 100;
        var finalCharge = preDiscountCharge - discountAmount;

        return new Agreement(toolCode, tool.getType(), tool.getBrand(), rentalDays, checkoutDate, dueDate,
                tool.getDailyCharge(), chargeDays, preDiscountCharge, discountPercent, discountAmount, finalCharge);
    }

    private int calculateChargeDays(Tools tool, LocalDate startDate, LocalDate endDate) {
        int chargeDays = 0;
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            if (isChargeableDay(tool, date)) {
                chargeDays++;
            }
        }
        return chargeDays;
    }

    private boolean isChargeableDay(Tools tool, LocalDate date) {
        boolean isHoliday = isHoliday(date);

        // Prioritize holiday checking for tools that don't charge on holidays
        if (isHoliday && !tool.isHolidayCharge()) {
            return false;
        }

        // If not a holiday or the tool charges on holidays, check if it's a weekend
        if ((date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY)) {
            return tool.isWeekendCharge();
        }

        // Default to weekday charging
        return tool.isWeekdayCharge();
    }

    private boolean isHoliday(LocalDate date) {
        if (date.getMonthValue() == 7) {
            if (date.getDayOfMonth() == 4) {
                return true; // Independence Day itself
            }
            if ((date.getDayOfMonth() == 3 && date.getDayOfWeek() == DayOfWeek.FRIDAY) ||
                    (date.getDayOfMonth() == 5 && date.getDayOfWeek() == DayOfWeek.MONDAY)) {
                return true; // Observed Independence Day if July 4th is on a weekend
            }
        }

        // Labor Day - first Monday in September
        if (date.getMonth() == Month.SEPTEMBER && date.getDayOfWeek() == DayOfWeek.MONDAY && date.getDayOfMonth() <= 7) {
            return true;
        }

        return false;
    }
}