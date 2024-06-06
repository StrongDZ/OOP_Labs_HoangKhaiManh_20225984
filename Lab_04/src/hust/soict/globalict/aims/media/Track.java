package hust.soict.globalict.aims.media;

import java.util.Objects;

public class Track implements Playable{
    private String title;
    private final int length;
    private int no;

    public void setNo(int no) {
        this.no = no;
    }

    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    public String toString(){
        return  getNo() + " - " + getTitle() + " - " + getLength();
    }

    public int getNo() {
        return no;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public void setTitle(String title) {
        this.title=title;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Track that)) return false;
        return Objects.equals(getTitle(), that.getTitle()) && getLength() == that.getLength();
    }
}
