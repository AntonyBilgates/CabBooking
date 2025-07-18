import Authentication.LogInPage;
import Authentication.SignInPage;
import Booking.BookingDetails;
import Booking.ChooseDestination;
import Traveller.TravellerDetails;

import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CabBooking {

    public static void main(String[] args) {
        final SignInPage signIn = new SignInPage();
        final LogInPage logIn = new LogInPage();
        final BookingDetails bookingDetails = new BookingDetails();
        final TravellerDetails travellerDetails = new TravellerDetails();
        final ChooseDestination chooseDestination = new ChooseDestination();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Fast🚖 Cabs ");

        try {

            while (true) {
                System.out.println("click the login page 1️⃣ or exit #️⃣ ");
                int Entry = scanner.nextInt();
                scanner.nextLine();

                if (Entry == 1) {
                    signIn.signIn(scanner, bookingDetails, chooseDestination);

                    while (true) {
                        System.out.print("\nDo you want to book again? (yes/no): ");
                        String again = scanner.nextLine();

                        if (!again.equalsIgnoreCase("yes")) {
                            System.out.println("Thank you for using Fast Cabs. Have a nice day!");
                            break;
                        }
                        chooseDestination.SelectDestination(scanner, bookingDetails, chooseDestination);
                    }
                    break;

                } else {
                    System.out.println("Thank you visit again ");
                    break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Input is miss match ");
        }
        finally {
            scanner.close();
        }
    }
}