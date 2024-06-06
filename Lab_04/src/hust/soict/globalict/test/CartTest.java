package hust.soict.globalict.test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;

public class CartTest {
    public static void main(String[] args) {
        ObservableList<Media> mediaList = FXCollections.observableArrayList();

        ObservableList<Track> tracks = FXCollections.observableArrayList(
                new Track("Another Brick in the Wall Pt. 2", 45),
                new Track("Comfortably Numb", 45)
        );
        CompactDisc cd = new CompactDisc(1, "The Wall", "Rock", "Pink Floyd", null, tracks, 19.99f);

        ObservableList<String> authors = FXCollections.observableArrayList("Jane Austen");
        Book book = new Book(2, "Pride and Prejudice", "Classic", 12.99f, authors);

        DigitalVideoDisc dvd = new DigitalVideoDisc(1, "The Shawshank Redemption", "Drama", "Frank Darabont", 144, 14.99f);

        mediaList.add(cd);
        mediaList.add(dvd);
        mediaList.add(book);

        for (Media media : mediaList) {
            System.out.println(media.toString());
        }
    }
}
