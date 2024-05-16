package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.store.Store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainScreen {

    public static void main(String[] args){

        Store store = new Store();
        Book book1 = new Book(1, "Java for Beginners", "Programming", 20.0f, Arrays.asList("James Gosling", "Bill Joy", "Guy Steele"));
        Book book2 = new Book(2, "Head First Java", "Programming", 30.0f, Arrays.asList("Kathy Sierra", "Bert Bates"));
        Book book3 = new Book(3, "Effective Java", "Programming", 40.0f, List.of("Joshua Bloch"));
        CompactDisc cd1 = new CompactDisc(1, "The Dark Side of the Moon", "Rock", "Pink Floyd", "Hoang Manh", new ArrayList<>(), 9.5f);
        cd1.addTrack(new Track("Speak to Me", 60));
        cd1.addTrack(new Track("Breathe", 168));
        cd1.addTrack(new Track("Money", 690));

        CompactDisc cd2 = new CompactDisc(2, "Abbey Road", "Rock", "The Beatles", "Hoang Manh", new ArrayList<>() ,9.5f);
        cd2.addTrack(new Track("Come Together", 410));
        cd2.addTrack(new Track("Something", 370));
        cd2.addTrack(new Track("Here Comes the Sun", 340));

        CompactDisc cd3 = new CompactDisc(3, "Thriller", "Pop",  "Michael Jackson", "Hoang Manh",new ArrayList<>(), 9.5f);
        cd3.addTrack(new Track("Billie Jean", 497));
        cd3.addTrack(new Track("Beat It", 452));
        cd3.addTrack(new Track("Thriller", 525));

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Shawshank Redemption", "Drama", "Frank Darabont", 142,10.0f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "The Godfather", "Crime", "Francis Ford Coppola", 175,12.0f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "The Lord of the Rings: The Fellowship of the Ring", "Fantasy", "Peter Jackson", 208, 15.0f);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);

        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);

        new StoreManagerScreen(store);
    }
}
