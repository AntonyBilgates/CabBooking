package Payment;

import Booking.ChooseDestination;

import java.util.Scanner;

public final class UpiId implements Payment {
    public void pay(final Scanner scanner, final ChooseDestination chooseDestination) {
        System.out.print("Enter UPI ID: ");
        String upiId = scanner.nextLine();
        System.out.println("total Amount : " + chooseDestination.getPrice());
        System.out.println("Processing UPI payment to " + upiId + "...");
    }
}
