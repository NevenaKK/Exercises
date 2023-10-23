package hotelReservation;

public class Guest {

    private final String fullName;
    private final int budget;
    private final boolean premium;

    public Guest(String fullName, int budget, boolean premium) {
        this.fullName = fullName;
        this.budget = budget;
        this.premium = premium;
    }

    public String getFullName() {
        return fullName;
    }

    public int getBudget() {
        return budget;
    }


    public boolean isPremium() {
        return premium;
    }

    @Override
    public String toString() {
        return fullName+(isPremium() ? " *" : "")+" , budget : "+budget;
    }
}
