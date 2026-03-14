package model.entity;

import java.util.List;

// SRP: Booking only holds reservation data
public class Booking {
    private String bookingId;
    private String userId;
    private Hotel hotel;
    private List<Room> rooms;
    private String checkInDate;
    private String checkOutDate;
    private int nights;
    private String contactEmail;
    private String contactPhone;
    private String paymentStatus;
    private double totalAmount;

    // Private constructor - use BookingBuilder
    private Booking() {}

    public String getBookingId() { return bookingId; }
    public String getUserId() { return userId; }
    public Hotel getHotel() { return hotel; }
    public List<Room> getRooms() { return rooms; }
    public String getCheckInDate() { return checkInDate; }
    public String getCheckOutDate() { return checkOutDate; }
    public int getNights() { return nights; }
    public String getContactEmail() { return contactEmail; }
    public String getContactPhone() { return contactPhone; }
    public String getPaymentStatus() { return paymentStatus; }
    public double getTotalAmount() { return totalAmount; }

    @Override
    public String toString() {
        return String.format(
            "Booking[%s] | Hotel: %s | Rooms: %d | Nights: %d | Total: ₹%.2f | Status: %s",
            bookingId, hotel.getName(), rooms.size(), nights, totalAmount, paymentStatus
        );
    }

    // Inner static Builder class
    public static class Builder {
        private Booking booking = new Booking();

        public Builder(String bookingId, String userId) {
            booking.bookingId = bookingId;
            booking.userId = userId;
        }

        public Builder hotel(Hotel hotel) {
            booking.hotel = hotel;
            return this;
        }

        public Builder rooms(List<Room> rooms) {
            booking.rooms = rooms;
            booking.totalAmount = rooms.stream()
                    .mapToDouble(Room::getFinalPrice)
                    .sum() * booking.nights;
            return this;
        }

        public Builder checkIn(String checkInDate) {
            booking.checkInDate = checkInDate;
            return this;
        }

        public Builder checkOut(String checkOutDate) {
            booking.checkOutDate = checkOutDate;
            return this;
        }

        public Builder nights(int nights) {
            booking.nights = nights;
            return this;
        }

        public Builder contactEmail(String email) {
            booking.contactEmail = email;
            return this;
        }

        public Builder contactPhone(String phone) {
            booking.contactPhone = phone;
            return this;
        }

        public Builder paymentStatus(String status) {
            booking.paymentStatus = status;
            return this;
        }

        public Booking build() {
            // Recalculate total with nights
            if (booking.rooms != null && booking.nights > 0) {
                booking.totalAmount = booking.rooms.stream()
                        .mapToDouble(Room::getFinalPrice)
                        .sum() * booking.nights;
            }
            return booking;
        }
    }
}
