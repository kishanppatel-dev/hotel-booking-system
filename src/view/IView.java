package view;

import model.entity.Booking;
import model.entity.Hotel;
import model.entity.User;

import java.util.List;

// ISP: Only essential view methods
// DIP: Controllers depend on this abstraction
public interface IView {
    void showWelcome();
    void showMenu();
    void showMessage(String message);
    void showError(String error);
    void showUser(User user);
    void showHotel(Hotel hotel);
    void showHotels(List<Hotel> hotels);
    void showBooking(Booking booking);
    void showBookings(List<Booking> bookings);
    String getInput(String prompt);
    int getIntInput(String prompt);
}
