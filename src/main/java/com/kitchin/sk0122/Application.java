package com.kitchin.sk0122;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;

/**
 * Main entry point for the Tool Rental Application.
 * This class handles the setup and execution of rental agreement processing.
 */
@SpringBootApplication
public class Application {

    /**
     * Starts the Spring Boot application.
     * @param args command line arguments passed to the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * CommandLineRunner bean that processes multiple tool rentals.
     * It demonstrates the checkout process for various tools and prints out their rental agreements.
     *
     * @param checkout The checkout service used to process rentals.
     * @return a CommandLineRunner bean that executes the rental processing logic.
     */
    @Bean
    public CommandLineRunner demo(Checkout checkout) {
        return args -> {
            // Define an array of tool rental specifications
            Object[][] rentals = {
                    {"JAKR", 5, 101, LocalDate.of(2015, 9, 3)},
                    {"LADW", 3, 10, LocalDate.of(2020, 7, 2)},
                    {"CHNS", 5, 25, LocalDate.of(2015, 7, 2)},
                    {"JAKD", 6, 0, LocalDate.of(2015, 9, 3)},
                    {"JAKR", 9, 0, LocalDate.of(2015, 7, 2)},
                    {"JAKR", 4, 50, LocalDate.of(2020, 7, 2)}
            };

            // Process each rental specification
            for (Object[] rental : rentals) {
                try {
                    String toolCode = (String) rental[0];
                    int days = (Integer) rental[1];
                    int discount = (Integer) rental[2];
                    LocalDate date = (LocalDate) rental[3];

                    Agreement agreement = checkout.checkout(toolCode, days, discount, date);
                    agreement.printAgreement();
                } catch (IllegalArgumentException e) {
                    System.out.println("Error processing rental for tool " + rental[0] + ": " + e.getMessage());
                }
            }
        };
    }
}