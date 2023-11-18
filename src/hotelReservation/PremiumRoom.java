package hotelReservation;

public class PremiumRoom extends Room {


    public PremiumRoom(int number, int price, int structureRoom) {
        super(number, price, structureRoom);
    }

    @Override
    public boolean putGuest(Period period, Guest guest) {
        boolean busy = false;

        for (Period per : this.getBooked().keySet()) {
            if (per.overlaps(period))
                busy = true;
        }
        setPrice((int)(getPrice()*0.85));

        if (!busy && getPrice() <= guest.getBudget()) {
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
