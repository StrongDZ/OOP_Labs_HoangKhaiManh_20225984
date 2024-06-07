package hust.soict.globalict.aims.media;

public class Disc extends Media {
    private String director;
    private int length;
    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }
    public void setDirector(String director) {
        this.director=director;
    }

    public void setLength(int length) {
        this.length=length;
    }

    public Disc(int id, String title, String category, String director, int length, float cost){
        super(id,title,category,cost);
        setDirector(director);
        setLength(length);
    }

    public Disc(){super();}
}
