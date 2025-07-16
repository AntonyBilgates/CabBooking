package Payment;

import Booking.ChooseDestination;

import java.util.Scanner;

public final class Cash implements Payment {

    public void pay(final Scanner scanner, final ChooseDestination chooseDestination) {
        System.out.println("Please pay ₹" + chooseDestination.getPrice() + " in cash to the driver.");
    }
}
