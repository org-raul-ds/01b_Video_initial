package es.uniovi.ds.lab.videostore;

import java.util.*;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public void printReport() {
        double totalPrice = 0;
        int totalPoints = 0;
        System.out.println("Rental report for: " + getName());

        for (Rental rental : rentals) {

            // 1) Calculate the price of each rental
            double rentalPrice = 0;
            switch (rental.getMovie().getCategory()) {
                case Movie.NEW_RELEASE:
                    rentalPrice += rental.getDays() * 3;
                    break;
                case Movie.STANDARD:
                    rentalPrice += 2;
                    if (rental.getDays() > 2)
                        rentalPrice += (rental.getDays() - 2) * 1.5;
                    break;
                case Movie.CHILDREN:
                    rentalPrice += 1.5;
                    if (rental.getDays() > 3)
                        rentalPrice += (rental.getDays() - 3) * 1.5;
                    break;
            }

            // 2) Each rental gives 1 point. Extra point for new releases rented for 2 or more days
            int rentalPoints = 1;
            if ((rental.getMovie().getCategory() == Movie.NEW_RELEASE) && rental.getDays() > 1)
                rentalPoints = 2;

            // 3) Accumulate totals
            totalPrice += rentalPrice;
            totalPoints += rentalPoints;

            // 4) Show the price of this rental
            System.out.println("\t- " + rental.getMovie().getTitle() + "\t" + rentalPrice);

        }

        System.out.println("The total debt is " + totalPrice);
        System.out.println("You have earned " + totalPoints + " points on your card.");
    }
}
