package model.entity;

// LSP: DeluxeRoom substitutable wherever Room is expected
public class DeluxeRoom extends Room {

    public DeluxeRoom(String roomId, String hotelId, String guestName, int roomNumber, double basePrice) {
        super(roomId, hotelId, guestName, roomNumber, basePrice);
    }

    @Override
    protected double getPriceMultiplier() {
        return 2.5;
    }

    @Override
    public String getRoomType() {
        return "Deluxe Room";
    }
}
