package hotelReservation;

import java.util.HashMap;
import java.util.Map;

public abstract class Room {

    private int number;
    private int price;
    private int structureRoom;
    private Map<Period,Guest> booked;

    public Room(int number, int price, int structureRoom) {
        this.number = number;
        this.price = price;
        this.structureRoom = structureRoom;
        this.booked = new HashMap<>();
    }

    public int getNumber() {
        return number;
    }

    public int getPrice() {
        return price;
    }

    public int getStructureRoom() {
        return structureRoom;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Map<Period, Guest> getBooked() {
        return booked;
    }


    public abstract boolean putGuest (Period period, Guest guest);

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("room number - ").append(number).append(" , number of beds - ").append(structureRoom).append(" , price - ").append(price).append("din\n");

        for (Map.Entry<Period,Guest> entry : booked.entrySet())
            sb.append("     --> ").append("date: ").append(entry.getKey()).append(" , name: ").append(entry.getValue()).append("\n");

        return sb.toString();

    }
}
