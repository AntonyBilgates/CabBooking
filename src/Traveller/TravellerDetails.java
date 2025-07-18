package Traveller;

import Booking.BookingDetails;
import Booking.ChooseDestination;
import Validation.Validator;

import java.util.Scanner;

public final class TravellerDetails {

    final Validator validator = new Validator();
    public String name;
    public String gender;
    public String phoneNo;
    public String email;

    public void getDetails(final Scanner scanner, final BookingDetails bookingDetails, final ChooseDestination chooseDestination) {
        System.out.println("\n--- Enter Traveller Details ---");

        // Name: not empty
        while (true) {
            System.out.print("👤 Name: ");
            name = scanner.nextLine();
            if (!name.trim().isEmpty()) break;
            System.out.println("Name cannot be empty.");
        }

        // Gender: only Male or Female
        while (true) {
            System.out.print("🚻 Gender (Male/Female): ");
            gender = scanner.nextLine();
            if (gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female")) break;
            System.out.println("Please enter Male or Female.");
        }

        // Phone: must be 10 digits
        while (true) {
            System.out.print("📞 Phone No: ");
            phoneNo = scanner.nextLine();
            if (phoneNo.matches("\\d{10}")) break;
            System.out.println("Invalid phone number. Must be 10 digits.");
        }

        // Gmail validation
        while (true) {
            System.out.print("📧 Email: ");
            email = scanner.nextLine();
            Validator validator = new Validator();
            if (validator.isValidEmail(email)) break;
            System.out.println("Invalid email. Must be a Gmail address.");
        }

        bookingDetails.showBookingDet(scanner, this, chooseDestination);
    }


}
