package model.entity;

// SRP: Hotel class only handles hotel data
public class Hotel implements Cloneable {
    private String hotelId;
    private String name;
    private String location;
    private String city;
    private int totalRooms;
    private int availableRooms;
    private double starRating;

    public Hotel(String hotelId, String name, String location, String city,
                 int totalRooms, int availableRooms, double starRating) {
        this.hotelId = hotelId;
        this.name = name;
        this.location = location;
        this.city = city;
        this.totalRooms = totalRooms;
        this.availableRooms = availableRooms;
        this.starRating = starRating;
    }

    public String getHotelId() { return hotelId; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public String getCity() { return city; }
    public int getTotalRooms() { return totalRooms; }
    public int getAvailableRooms() { return availableRooms; }
    public double getStarRating() { return starRating; }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }

    public boolean hasAvailability() {
        return availableRooms > 0;
    }

    @Override
    public Hotel clone() {
        try {
            return (Hotel) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone failed", e);
        }
    }

    @Override
    public String toString() {
        return String.format("Hotel[%s] %s | %s, %s | %.1f★ | Rooms available: %d",
                hotelId, name, location, city, starRating, availableRooms);
    }
}
