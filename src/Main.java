import controller.BookingController;
import controller.HotelController;
import controller.UserController;
import util.SystemConfig;
import view.ConsoleView;
import view.IView;

public class Main {

    public static void main(String[] args) {
        IView view = new ConsoleView();

        UserController userController = new UserController(view);
        HotelController hotelController = new HotelController(view);
        BookingController bookingController = new BookingController(view, hotelController);

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        try {
            view.showWelcome();

            boolean running = true;
            while (running) {
                if (!userController.isLoggedIn()) {
                    System.out.println("\n1. Register  2. Login  0. Exit");
                    System.out.print("Choice: ");
                    String choice = scanner.nextLine().trim();

                    switch (choice) {
                        case "1": userController.register(); break;
                        case "2": userController.login(); break;
                        case "0": running = false; break;
                        default: view.showError("Invalid option.");
                    }
                } else {
                    view.showMenu();
                    System.out.print("Choice: ");
                    String choice = scanner.nextLine().trim();

                    switch (choice) {
                        case "1": userController.register(); break;
                        case "2": userController.login(); break;
                        case "3": hotelController.searchByCity(); break;
                        case "4": bookingController.createBooking(userController.getLoggedInUser()); break;
                        case "5": bookingController.viewUserBookings(userController.getLoggedInUser()); break;
                        case "6": bookingController.cancelBooking(userController.getLoggedInUser()); break;
                        case "7": SystemConfig.getInstance().printConfig(); break;
                        case "0": running = false; break;
                        default: view.showError("Invalid option.");
                    }
                }
            }

            view.showMessage("Thank you for using Hotel Booking System. Goodbye!");
        } finally {
            scanner.close();
        }
    }
}
