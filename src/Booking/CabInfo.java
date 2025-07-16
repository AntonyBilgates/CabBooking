package Booking;

public final class CabInfo {

    private final String cabName;
    private final int seats;
    private final boolean isAC;
    private int availableCount;

    public CabInfo(String cabName, int seats, boolean isAC, int availableCount) {
        this.cabName = cabName;
        this.seats = seats;
        this.isAC = isAC;
        this.availableCount = availableCount;
    }

    public String getCabName() {
        return cabName;
    }

    public int getSeats() {
        return seats;
    }

    public boolean isAC() {
        return isAC;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public boolean book() {
        if (availableCount > 0) {
            availableCount--;
            return true;
        } else {
            return false;
        }
    }
}
