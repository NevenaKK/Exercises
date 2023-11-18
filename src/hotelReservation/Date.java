package hotelReservation;

public class Date implements Comparable<Date> {

    private int day;
    private int month;
    private int year;

    public Date(int day, int month,int year) {
        this.day = day;
        this.month = month;
        this.year=year;
    }

    public Date(String date) {

        String[] el = date.split("/");
        this.day = Integer.parseInt(el[0]);
        this.month = Integer.parseInt(el[1]);
        this.year=Integer.parseInt(el[2]);
    }

    @Override
    public String toString() {
        return day + "-" + month;
    }

    @Override
    public int compareTo(Date date) {
        if(this.year==date.year)
            return this.month!=date.month ? Integer.compare(this.month,date.month)
                    : Integer.compare(this.day, date.day);

        return Integer.compare(this.year,date.year);

    }
}

