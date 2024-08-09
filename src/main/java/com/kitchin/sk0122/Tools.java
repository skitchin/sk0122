package com.kitchin.sk0122;

/**
 * Represents a tool available for rent.
 */
public class Tools {
    private String code;
    private String type;
    private String brand;
    private double dailyCharge;
    private boolean weekdayCharge;
    private boolean weekendCharge;
    private boolean holidayCharge;

    /**
     * Constructs a new Tool instance.
     *
     * @param code The unique code identifying the tool.
     * @param type The type or category of the tool.
     * @param brand The brand of the tool.
     * @param dailyCharge The charge rate per day.
     * @param weekdayCharge Flag indicating if charges apply on weekdays.
     * @param weekendCharge Flag indicating if charges apply on weekends.
     * @param holidayCharge Flag indicating if charges apply on holidays.
     */
    public Tools(String code, String type, String brand, double dailyCharge, boolean weekdayCharge, boolean weekendCharge, boolean holidayCharge) {
        this.code = code;
        this.type = type;
        this.brand = brand;
        this.dailyCharge = dailyCharge;
        this.weekdayCharge = weekdayCharge;
        this.weekendCharge = weekendCharge;
        this.holidayCharge = holidayCharge;
    }

    public String getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public double getDailyCharge() {
        return dailyCharge;
    }

    public boolean isWeekdayCharge() {
        return weekdayCharge;
    }

    public boolean isWeekendCharge() {
        return weekendCharge;
    }

    public boolean isHolidayCharge() {
        return holidayCharge;
    }
}