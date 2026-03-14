package util;

// Singleton Pattern: Single instance of system configuration
public class SystemConfig {

    private static SystemConfig instance;

    private double basePricePerNight;
    private int maxBookingsPerUser;
    private boolean maintenanceMode;
    private double gstRate;

    private SystemConfig() {
        // Default configuration
        this.basePricePerNight = 1500.0;  // ₹1500 base per night
        this.maxBookingsPerUser = 5;
        this.maintenanceMode = false;
        this.gstRate = 0.18;
    }

    // Thread-safe singleton
    public static synchronized SystemConfig getInstance() {
        if (instance == null) {
            instance = new SystemConfig();
        }
        return instance;
    }

    public double getBasePricePerNight() { return basePricePerNight; }
    public int getMaxBookingsPerUser() { return maxBookingsPerUser; }
    public boolean isMaintenanceMode() { return maintenanceMode; }
    public double getGstRate() { return gstRate; }

    public void setMaintenanceMode(boolean mode) { this.maintenanceMode = mode; }
    public void setBasePricePerNight(double price) { this.basePricePerNight = price; }

    public void printConfig() {
        System.out.println("=== System Configuration ===");
        System.out.printf("Base Price/Night : ₹%.2f%n", basePricePerNight);
        System.out.printf("Max Bookings     : %d%n", maxBookingsPerUser);
        System.out.printf("GST Rate         : %.0f%%%n", gstRate * 100);
        System.out.printf("Maintenance Mode : %s%n", maintenanceMode ? "ON" : "OFF");
    }
}
