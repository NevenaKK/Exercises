package videoGame;

public class PCVideoGame extends VideoGame{
    private int requirement;

    public PCVideoGame(String name,String genre, int price, int requirement) {
        super(name,genre, price);
        this.requirement = requirement;
    }

    public int getRequirement() {
        return requirement;
    }

    @Override
    public String getPlatform() {
        return "pc";
    }

    @Override
    public String toString() {
        return super.toString()+"  REQUIREMENT: "+requirement+"/5";
    }
}
