package Authentication;

import Booking.BookingDetails;
import Booking.ChooseDestination;

import java.util.Map;
import java.util.Scanner;

public final class LogInPage {

    public void logIn(final Scanner scanner, final Map<String, String> UserDetails, final BookingDetails bookingDetails,
                            final ChooseDestination chooseDestination) {


        System.out.println(" ---login page--- ");

        while (true) {
            System.out.print("🧑‍💼 username : ");
            String userName1 = scanner.nextLine();
            System.out.print("🔑 password : ");

            String password1 = scanner.nextLine();

            if (!UserDetails.containsKey(userName1)) {
                System.out.println(" Username not found");
            } else if (!password1.equals(UserDetails.get(userName1))) {
                System.out.println(" Password mismatch!");
            } else {
                System.out.println(" Login successful!");
                chooseDestination.SelectDestination(scanner, bookingDetails, chooseDestination);
                break;
            }
        }
    }


}
