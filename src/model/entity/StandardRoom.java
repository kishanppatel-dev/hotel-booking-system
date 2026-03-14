package model.entity;

// LSP: StandardRoom substitutable wherever Room is expected
public class StandardRoom extends Room {

    public StandardRoom(String roomId, String hotelId, String guestName, int roomNumber, double basePrice) {
        super(roomId, hotelId, guestName, roomNumber, basePrice);
    }

    @Override
    protected double getPriceMultiplier() {
        return 1.0;
    }

    @Override
    public String getRoomType() {
        return "Standard Room";
    }
}
