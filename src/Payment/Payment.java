package Payment;

import Booking.ChooseDestination;

import java.util.Scanner;

public interface Payment {

    void pay(Scanner scanner, ChooseDestination chooseDestination);
}
