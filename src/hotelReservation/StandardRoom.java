package hotelReservation;

public class StandardRoom extends Room{

    public StandardRoom(int number, int price, int structureRoom) {
        super(number, price, structureRoom);
    }

    @Override
    public boolean putGuest(Period period, Guest guest) {

       boolean busy=false;

       for(Period per : this.getBooked().keySet()) {
           if (per.overlaps(period))
               busy = true;
       }
       if(!busy && this.getPrice()<=guest.getBudget()){
           getBooked().put(period,guest);
           return true;
       }else
           return false;
    }

    @Override
    public String toString() {
        return "Standard : "+super.toString();
    }
}
