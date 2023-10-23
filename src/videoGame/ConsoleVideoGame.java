package videoGame;

public class ConsoleVideoGame extends VideoGame{

    private String platform;

    public ConsoleVideoGame(String name, String genre, int price, String platform) {
        super(name, genre, price);
        this.platform = platform;
    }

    @Override
    public String getPlatform() {
        return platform;
    }



    @Override
    public String toString() {
        return super.toString();
    }
}
