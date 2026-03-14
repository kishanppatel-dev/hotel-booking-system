package model.entity;

// OCP: Abstract class open for extension, closed for modification
public abstract class Room {
    protected String roomId;
    protected String hotelId;
    protected String guestName;
    protected int roomNumber;
    protected double basePrice;
    protected double finalPrice;

    public Room(String roomId, String hotelId, String guestName, int roomNumber, double basePrice) {
        this.roomId = roomId;
        this.hotelId = hotelId;
        this.guestName = guestName;
        this.roomNumber = roomNumber;
        this.basePrice = basePrice;
        this.finalPrice = calculateFinalPrice();
    }

    // Template method - subclasses define pricing multiplier
    protected abstract double getPriceMultiplier();
    public abstract String getRoomType();

    public double calculateFinalPrice() {
        return basePrice * getPriceMultiplier();
    }

    public String getRoomId() { return roomId; }
    public String getHotelId() { return hotelId; }
    public String getGuestName() { return guestName; }
    public int getRoomNumber() { return roomNumber; }
    public double getBasePrice() { return basePrice; }
    public double getFinalPrice() { return finalPrice; }

    @Override
    public String toString() {
        return String.format("Room[%s] %s | Room #%d | Guest: %s | Price: ₹%.2f",
                roomId, getRoomType(), roomNumber, guestName, finalPrice);
    }
}
