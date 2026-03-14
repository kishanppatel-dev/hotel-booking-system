package view;

import model.entity.Booking;
import model.entity.Hotel;
import model.entity.User;

import java.util.List;
import java.util.Scanner;

// ConsoleView: Console-based implementation of IView
// Can be replaced with GUIView or WebView without changing controllers (DIP)
public class ConsoleView implements IView {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void showWelcome() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║    🏨 Hotel Booking System v1.0      ║");
        System.out.println("║    Built with MVC + SOLID + Patterns  ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println();
    }

    @Override
    public void showMenu() {
        System.out.println("\n========== MAIN MENU ==========");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Search Hotels");
        System.out.println("4. Book a Room");
        System.out.println("5. My Bookings");
        System.out.println("6. Cancel Booking");
        System.out.println("7. System Settings");
        System.out.println("0. Exit");
        System.out.println("================================");
    }

    @Override
    public void showMessage(String message) {
        System.out.println("[INFO] " + message);
    }

    @Override
    public void showError(String error) {
        System.out.println("[ERROR] " + error);
    }

    @Override
    public void showUser(User user) {
        System.out.println("--- Guest Profile ---");
        System.out.println(user.toString());
    }

    @Override
    public void showHotel(Hotel hotel) {
        System.out.println(hotel.toString());
    }

    @Override
    public void showHotels(List<Hotel> hotels) {
        System.out.println("\n--- Available Hotels ---");
        if (hotels.isEmpty()) {
            System.out.println("No hotels found.");
            return;
        }
        for (int i = 0; i < hotels.size(); i++) {
            System.out.println((i + 1) + ". " + hotels.get(i));
        }
    }

    @Override
    public void showBooking(Booking booking) {
        System.out.println("--- Booking Details ---");
        System.out.println(booking.toString());
    }

    @Override
    public void showBookings(List<Booking> bookings) {
        System.out.println("\n--- Your Bookings ---");
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }
        for (Booking b : bookings) {
            System.out.println(b.toString());
        }
    }

    @Override
    public String getInput(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine().trim();
    }

    @Override
    public int getIntInput(String prompt) {
        System.out.print(prompt + ": ");
        try {
            int val = Integer.parseInt(scanner.nextLine().trim());
            return val;
        } catch (NumberFormatException e) {
            showError("Invalid number input.");
            return -1;
        }
    }
}
