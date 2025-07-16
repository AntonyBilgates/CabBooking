package Booking;

import Traveller.TravellerDetails;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class SelectCab {

    final TravellerDetails travellerDetails = new TravellerDetails();
    final Map<Integer, CabInfo> cabOptions = new HashMap<>();

    public SelectCab() {
        cabOptions.put(1, new CabInfo("Indica (Diesel)", 4, true, 2));
        cabOptions.put(2, new CabInfo("Dzire (Diesel)", 4, true, 3));
        cabOptions.put(3, new CabInfo("Toyota Innova (New Diesel)", 6, true, 1));
        cabOptions.put(4, new CabInfo("Innova Crysta (Petrol)", 6, true, 1));
        cabOptions.put(5, new CabInfo("Swift (Petrol)", 4, true, 2));
        cabOptions.put(6, new CabInfo("Xylo (Diesel)", 4, true, 0));
    }

    public void cabTypes(final Scanner scanner, final BookingDetails bookingDetails, final ChooseDestination chooseDestination) {
        while (true) {
            System.out.println("\n--- Available Cab Types ---");
            for (Map.Entry<Integer, CabInfo> entry : cabOptions.entrySet()) {
                System.out.printf("%d. %s\n", entry.getKey(), entry.getValue().getCabName());
            }

            // User selects cab
            System.out.print("\nSelect a cab by number: ");
            int selected = scanner.nextInt();
            scanner.nextLine();

            CabInfo selectedCab = cabOptions.get(selected);

            if (selectedCab == null) {
                System.out.println("Invalid selection. Try again.");
                continue;
            }

            // Show details
            System.out.println("\n--- Cab Details ---");
            System.out.println("🚗 Cab Name     : " + selectedCab.getCabName());
            System.out.println("🧊 AC Available : " + (selectedCab.isAC() ? "Yes" : "No"));
            System.out.println("💺 Seats        : " + selectedCab.getSeats());
            System.out.println("📦 Available    : " + selectedCab.getAvailableCount());

            // Valid Check if full
            if (selectedCab.getAvailableCount() == 0) {
                System.out.println("Sorry, this cab is fully booked.");
                System.out.print("Do you want to try another cab? (yes/no): ");
                String again = scanner.nextLine().trim();
                if (again.equalsIgnoreCase("yes")) {
                    continue; // go back and show cab list again
                } else {
                    System.out.println("Thank you for visiting. Come back later!");
                    break;
                }
            }

            // Booking confirmation
            System.out.print("\nDo you want to book this cab? (yes/no): ");
            String confirm = scanner.nextLine().trim();
            if (confirm.equalsIgnoreCase("yes")) {
                if (selectedCab.book()) {
                    System.out.println("🎉 Booking confirmed!");
                    travellerDetails.getDetails(scanner, bookingDetails, chooseDestination);
                } else {
                    System.out.println("Booking failed. Try again.");
                }
            } else {
                System.out.println("Booking cancelled.");
            }

            //Ask to book another
            System.out.print("\nDo you want to book another cab? (yes/no): ");
            String again = scanner.nextLine().trim();
            if (!again.equalsIgnoreCase("yes")) {
                System.out.println("Thank you! Safe travels.");
                break;
            }
        }
    }
}
