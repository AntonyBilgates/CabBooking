package Payment;

import Booking.ChooseDestination;

import java.util.Scanner;

public final class CreditCardPayment implements Payment {

    public void pay(Scanner scanner, ChooseDestination chooseDestination) {
        System.out.print("Enter Card Number: ");
        String cardNumber = scanner.nextLine();
        System.out.println("total Amount : " + chooseDestination.getPrice());
        System.out.println("Processing card payment for card ending with " +
                cardNumber.substring(cardNumber.length() - 4) + "...");
    }
}
