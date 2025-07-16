package Authentication;

import Booking.BookingDetails;
import Booking.ChooseDestination;
import Validation.Validator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class SignInPage {

    final Validator passwordValidCheck = new Validator();
    final LogInPage logIn = new LogInPage();

    public final void signIn(final Scanner scanner, final BookingDetails bookingDetails, final ChooseDestination chooseDestination) {
        final Map<String, String> userDetails = new HashMap<>();

        while (true) {
            System.out.print("🧑‍💼 enter the name : ");
            String userName = scanner.nextLine();
            System.out.print("🔑 enter the password : ");
            String password = scanner.nextLine();
            System.out.print("📩 enter the Email : ");
            String email = scanner.nextLine();

            if (!passwordValidCheck.isValidPassword(password)) {
                System.out.println("Password must contain one Capse , one numeric , one special character ");
            }
            if (!passwordValidCheck.isValidEmail(email)) {
                System.out.println("enter the valid email  ");
            } else {
                userDetails.put(userName, password);
                System.out.println("your Details Saved ");
                break;
            }
        }
        logIn.logIn(scanner, userDetails, bookingDetails, chooseDestination);
    }
}