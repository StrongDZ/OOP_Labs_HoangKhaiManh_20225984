package hust.soict.globalict.aims.store;
import java.util.ArrayList;

import hust.soict.globalict.aims.media.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Store {
    public Store(){
        ObservableList<String> authors1 = FXCollections.observableArrayList("James Gosling", "Bill Joy", "Guy Steele");
        ObservableList<String> authors2 = FXCollections.observableArrayList("Kathy Sierra", "Bert Bates");
        ObservableList<String> authors3 = FXCollections.observableArrayList("Joshua Bloch");

        // Tạo sách
        Book book1 = new Book(1, "Java for Beginners", "Programming", 20.0f, authors1);
        Book book2 = new Book(2, "Head First Java", "Programming", 30.0f, authors2);
        Book book3 = new Book(3, "Effective Java", "Programming", 40.0f, authors3);

        // Tạo danh sách bài hát cho CD
        ObservableList<Track> tracks1 = FXCollections.observableArrayList(
                new Track("Speak to Me", 60),
                new Track("Breathe", 168),
                new Track("Money", 690)
        );
        CompactDisc cd1 = new CompactDisc(1, "The Dark Side of the Moon", "Rock", "Pink Floyd", "Hoang Manh", tracks1, 9.5f);

        // Tạo danh sách bài hát cho CD
        ObservableList<Track> tracks2 = FXCollections.observableArrayList(
                new Track("Come Together", 410),
                new Track("Something", 370),
                new Track("Here Comes the Sun", 340)
        );
        CompactDisc cd2 = new CompactDisc(2, "Abbey Road", "Rock", "The Beatles", "Hoang Manh", tracks2, 9.5f);

        // Tạo danh sách bài hát cho CD
        ObservableList<Track> tracks3 = FXCollections.observableArrayList(
                new Track("Billie Jean", 497),
                new Track("Beat It", 452),
                new Track("Thriller", 525)
        );
        CompactDisc cd3 = new CompactDisc(3, "Thriller", "Pop", "Michael Jackson", "Hoang Manh", tracks3, 9.5f);

        // Tạo DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Shawshank Redemption", "Drama", "Frank Darabont", 142, 10.0f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "The Godfather", "Crime", "Francis Ford Coppola", 175, 12.0f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "The Lord of the Rings: The Fellowship of the Ring", "Fantasy", "Peter Jackson", 208, 15.0f);

        // Thêm media vào cửa hàng
        addMedia(cd1);
        addMedia(dvd1);
        addMedia(book1);
        addMedia(cd2);
        addMedia(dvd2);
        addMedia(book2);
        addMedia(cd3);
        addMedia(dvd3);
        addMedia(book3);

        // Tạo và thêm 6 media mới vào cửa hàng
        Book book4 = new Book(4, "Design Patterns", "Programming", 45.0f, FXCollections.observableArrayList("Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides"));
        addMedia(book4);

        DigitalVideoDisc dvd4 = new DigitalVideoDisc(4, "Inception", "Sci-Fi", "Christopher Nolan", 148, 13.0f);
        addMedia(dvd4);

        Book book5 = new Book(5, "Clean Architecture", "Programming", 55.0f, FXCollections.observableArrayList("Robert C. Martin"));
        addMedia(book5);

        CompactDisc cd4 = new CompactDisc(4, "Back in Black", "Rock", "AC/DC", "Hoang Manh", FXCollections.observableArrayList(
                new Track("Hells Bells", 312),
                new Track("Shoot to Thrill", 311),
                new Track("Back in Black", 267),
                new Track("You Shook Me All Night Long", 210)
        ), 9.5f);
        addMedia(cd4);

        DigitalVideoDisc dvd5 = new DigitalVideoDisc(5, "Pulp Fiction", "Crime", "Quentin Tarantino", 154, 11.0f);
        addMedia(dvd5);

        CompactDisc cd5 = new CompactDisc(5, "Thriller", "Pop", "Michael Jackson", "Hoang Manh", FXCollections.observableArrayList(
                new Track("Wanna Be Startin' Somethin'", 386),
                new Track("Baby Be Mine", 240),
                new Track("The Girl Is Mine", 204),
                new Track("Thriller", 358)
        ), 9.5f);
        addMedia(cd5);
    }
    private static ArrayList<Media> itemsInStore = new ArrayList<Media>();
    public void addMedia(Media disc){
        if (itemsInStore.size() <= 1000 ) {
            if(itemsInStore.contains(disc)){
                System.out.println("Media \"" + disc.getTitle() + "\" is already in the store.");
                return ;
            }
            itemsInStore.add(disc);
            System.out.println("Media \"" + disc.getTitle() + "\" added to store.");
        } 
        else {
            System.out.println("Store is full. Could not add \"" + disc.getTitle() + "\".");
        }
    }

    public void removeMedia(Media disc) {
        boolean found = false;
        for (int i = 0; i < itemsInStore.size(); i++) {
            if (itemsInStore.get(i)==disc) {
                found = true;
                itemsInStore.remove(i);
                System.out.println("Media \"" + disc.getTitle() + "\" removed from store.");
                break;
            }
        }
        if (!found) {
          System.out.println("Media \"" + disc.getTitle() + "\" not found in store.");
        }
    }

    public Media SearchByTitle(String title){
        for(int i = 0; i < itemsInStore.size();i++){
            if(itemsInStore.get(i).getTitle()==title){
                System.out.println("The information of media containing the keyword:\n");
                System.out.println(itemsInStore.get(i).toString());
                return itemsInStore.get(i);
            }
        }
        System.out.println("The information of media containing the keyword:\n");
        return null;
    }
    
    public ArrayList<Media> getItemsInStore(){
        return itemsInStore;
    }
}
