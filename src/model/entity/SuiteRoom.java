package model.entity;

// LSP: SuiteRoom substitutable wherever Room is expected
public class SuiteRoom extends Room {

    public SuiteRoom(String roomId, String hotelId, String guestName, int roomNumber, double basePrice) {
        super(roomId, hotelId, guestName, roomNumber, basePrice);
    }

    @Override
    protected double getPriceMultiplier() {
        return 5.0;
    }

    @Override
    public String getRoomType() {
        return "Suite Room";
    }
}
