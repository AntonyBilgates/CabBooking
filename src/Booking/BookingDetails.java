package Booking;

import Payment.Cash;
import Payment.CreditCardPayment;
import Payment.Payment;
import Payment.UpiId;
import Traveller.TravellerDetails;
import java.util.Scanner;

public final class BookingDetails {

    final Payment upiId = new UpiId();
    final Payment creditCardPayment = new CreditCardPayment();
    final Payment cash = new Cash();

    public void showBookingDet(final Scanner scanner, final TravellerDetails traveller, final ChooseDestination chooseDestination) {
        System.out.println("------Traveller Details-------- ");
        System.out.println("Name     : " + traveller.name);
        System.out.println("Gender   : " + traveller.gender);
        System.out.println("PhoneNo  : " + traveller.phoneNo);
        System.out.println("Email    : " + traveller.email);

        System.out.println("\n--- Booking Summary ---");

        System.out.println("Route            : " + chooseDestination.getDestination());
        System.out.println("Distance         : " + chooseDestination.getDistance() + " km");
        System.out.println("Total Cost       : ₹" + chooseDestination.getPrice());

        confirmBooking(scanner, chooseDestination);
    }

    public void confirmBooking(Scanner scanner, ChooseDestination chooseDestination) {
        System.out.print("\nConfirm Booking (Yes/No): ");
        String confirmBooking = scanner.nextLine();

        if (confirmBooking.equalsIgnoreCase("yes")) {
            System.out.println("\nPayment process initiated...");

            boolean flag = true;
            while (flag) {
                System.out.println("Choose payment method :\n1. UPI\n2. Card\n3. Cash");
                int paymentOption = scanner.nextInt();
                scanner.nextLine();

                switch (paymentOption) {
                    case 1 -> {
                        upiId.pay(scanner, chooseDestination);
                        flag = false;
                    }
                    case 2 -> {
                        creditCardPayment.pay(scanner, chooseDestination);
                        flag = false;
                    }

                    case 3 -> {
                        cash.pay(scanner, chooseDestination);
                        flag = false;
                    }
                    default -> System.out.print("not valid . please try again ");
                };
                }
        }
    }
}