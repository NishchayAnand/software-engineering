package Model;

public enum SeatType {

    NORMAL(250),
    PREMIUM(400),
    VIP(550);

    private final int price;

    SeatType(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
