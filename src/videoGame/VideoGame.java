package videoGame;

public abstract class VideoGame {

    private String name;
    private  String genre;
    private  int price;

    public VideoGame(String name,String genre, int price) {
        this.name = name;
        this.genre=genre;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public int getPrice() {
        return price;
    }

    public abstract String getPlatform();

    @Override
    public String toString() {
        return "["+getPlatform()+"]" + " NAME: "+name +"  GENRE: "+genre +"  PRICE: "+price;
    }
}
