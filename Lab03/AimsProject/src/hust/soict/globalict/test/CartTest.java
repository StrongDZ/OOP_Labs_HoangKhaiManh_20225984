package hust.soict.globalict.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;

public class CartTest {  
    public static void main(String[] args) {
        // Cart cart = new Cart();

        // DigitalVideoDisc dvd1 = new DigitalVideoDisc ("The Lion King",
        //                                 "Animation", "Roger Allers", 87, 19.95f);
        // cart.addMedia(dvd1);

        // DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
        //                                 "Science Fiction", "George Lucas", 87, 24.95f);
        // cart.addMedia(dvd2);

        // DigitalVideoDisc dvd3 = new DigitalVideoDisc ("Aladin",
        //                                 "Animation", 18.99f);
        // cart.addMedia(dvd3);

        // cart.print();

        // cart.SearchByTitle("Star");
        // cart.SearchByTitle("zui");
        // cart.SearchByTitle("A");
        ArrayList<Media> mediaList = new ArrayList<>();

        // Add some media objects (casting is required for specific types)
        CompactDisc cd = new CompactDisc(1, "The Wall", "Rock", "Pink Floyd", null, 
                                 Arrays.asList(new Track("Another Brick in the Wall Pt. 2",45), 
                                               new Track("Comfortably Numb",45)), 
                                 19.99f);
        List<String> authors = Arrays.asList("Jane Austen");
        Book book = new Book(2, "Pride and Prejudice", "Classic", 12.99f, authors);
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Shawshank Redemption", "drama", "Frank Darabont", 144, 14.99f);
        mediaList.add(cd);
        mediaList.add(dvd);
        mediaList.add(book);

        for (Media media : mediaList) {
            System.out.println(media.toString()); 
        }
        
    }
}