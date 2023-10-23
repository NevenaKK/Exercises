package hotelReservation;

public class PremiumRoom extends Room {


    public PremiumRoom(int number, int price, int structureRoom) {
        super(number, price, structureRoom);
    }

    @Override
    public boolean putGuest(Period period, Guest guest) {
        boolean busy = false;

        for (Period app : this.getBooked().keySet()) {
            if (app.overlaps(period))
                busy = true;
        }
        int priceRoom=getPrice();
        if (guest.isPremium())
            priceRoom*= 0.85;

        if (!busy && priceRoom <= guest.getBudget()) {
            getBooked().put(period,guest);
            return true;
        }else
            return false;
    }

    @Override
    public String toString() {
        return "Premium : "+super.toString();
    }
}
