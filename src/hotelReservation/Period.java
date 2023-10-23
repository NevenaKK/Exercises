package hotelReservation;

public class Period implements Comparable<Period> {

    private final Date start;
    private final Date end;

    public Period(Date start, Date end){
       if (start.compareTo(end)>=0)
           throw new IllegalArgumentException("Invalid input");
       this.start=start;
       this.end=end;
    }

    @Override
    public String toString() {
        return start +" to "+end;
    }

   public boolean overlaps (Period period){

        if(this.start.compareTo(period.start)<0)
            return this.end.compareTo(period.start) >0;
        else if(this.start.compareTo(period.start)>0)
            return this.start.compareTo(period.end)<0;
        return true;

    }

    @Override
    public int compareTo(Period period) {
        return start.compareTo(period.start);
    }
}
