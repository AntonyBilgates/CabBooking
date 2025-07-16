package Booking;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class ChooseDestination {

    SelectCab cabTypes = new SelectCab();
    private String destination;
    private int price;
    private int distance;

    public void SelectDestination(final Scanner scanner, final BookingDetails bookingDetails, final ChooseDestination chooseDestination) {

        final Map<String, Integer> routeMap = new HashMap<>();
        routeMap.put("Chennai-Tirunelveli", 623);
        routeMap.put("Chennai-Madurai", 460);
        routeMap.put("Chennai-Coimbatore", 510);
        routeMap.put("Madurai-Coimbatore", 210);
        routeMap.put("Tirunelveli-Chennai", 623);

        System.out.println("we are ready with ride with you 🚖 , select the Destination ✈️ ");

        while (true) {
            System.out.print("\nFrom : ");
            String from = scanner.nextLine().trim();
            System.out.print("To   : ");
            String to = scanner.nextLine().trim();

            this.destination = capitalize(from) + "-" + capitalize(to);

            if (routeMap.containsKey(destination)) {
                distance = routeMap.get(destination);
                PriceDetails();
                cabTypes.cabTypes(scanner, bookingDetails, chooseDestination);
                break; // Exit loop if valid
            } else {
                System.out.println("\nCurrently not available for this route.");
                System.out.println("Available Routes:");
                for (String route : routeMap.keySet()) {
                    System.out.println("   • " + route + " (" + routeMap.get(route) + " KM)");
                }
                System.out.println("\n🔁 Please try again.");
            }
        }
    }

    private static String capitalize(String str) {
        if (str == null || str.isEmpty()) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    public void PriceDetails() {
        final Map<String, Integer> priceMap = new HashMap<>();

        priceMap.put("Chennai-Tirunelveli", 10000);
        priceMap.put("Chennai-Madurai", 6000);
        priceMap.put("Chennai-Coimbatore", 7100);
        priceMap.put("Madurai-Coimbatore", 5000);
        priceMap.put("Tirunelveli-Chennai", 10000);

        price = priceMap.get(destination);
    }

    public String getDestination() {
        return destination;
    }

    public int getPrice() {
        return price;
    }

    public int getDistance() {
        return distance;
    }
}

