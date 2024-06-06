package hust.soict.globalict.aims.screen.customer.cart;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.screen.customer.controller.CartController;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.store.Store;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestViewCartScreen extends Application {
    private static Cart cart;

    @Override
    public void start(Stage primaryStage) throws Exception {
        String CART_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Cart.fxml";

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));

        CartController cartController = new CartController(new Store(), cart);

        fxmlLoader.setController(cartController);

        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Cart");

        primaryStage.setScene(new Scene(root));

        primaryStage.show();
    }

    public static void main(String[] args) {
        cart = new Cart();

        ObservableList<String> authors1 = FXCollections.observableArrayList("James Gosling", "Bill Joy", "Guy Steele");
        ObservableList<String> authors2 = FXCollections.observableArrayList("Kathy Sierra", "Bert Bates");
        ObservableList<String> authors3 = FXCollections.observableArrayList("Joshua Bloch");

        Book book1 = new Book(1, "Java for Beginners", "Programming", 20.0f, authors1);
        Book book2 = new Book(2, "Head First Java", "Programming", 30.0f, authors2);
        Book book3 = new Book(3, "Effective Java", "Programming", 40.0f, authors3);

        ObservableList<Track> tracks1 = FXCollections.observableArrayList();
        tracks1.add(new Track("Speak to Me", 60));
        tracks1.add(new Track("Breathe", 168));
        tracks1.add(new Track("Money", 690));
        CompactDisc cd1 = new CompactDisc(1, "The Dark Side of the Moon", "Rock", "Pink Floyd", "Hoang Manh", tracks1, 9.5f);

        ObservableList<Track> tracks2 = FXCollections.observableArrayList();
        tracks2.add(new Track("Come Together", 410));
        tracks2.add(new Track("Something", 370));
        tracks2.add(new Track("Here Comes the Sun", 340));
        CompactDisc cd2 = new CompactDisc(2, "Abbey Road", "Rock", "The Beatles", "Hoang Manh", tracks2, 9.5f);

        ObservableList<Track> tracks3 = FXCollections.observableArrayList();
        tracks3.add(new Track("Billie Jean", 497));
        tracks3.add(new Track("Beat It", 452));
        tracks3.add(new Track("Thriller", 525));
        CompactDisc cd3 = new CompactDisc(3, "Thriller", "Pop", "Michael Jackson", "Hoang Manh", tracks3, 9.5f);

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Shawshank Redemption", "Drama", "Frank Darabont", 142, 10.0f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "The Godfather", "Crime", "Francis Ford Coppola", 175, 12.0f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "The Lord of the Rings: The Fellowship of the Ring", "Fantasy", "Peter Jackson", 208, 15.0f);

        cart.addMedia(book1);
        cart.addMedia(book2);
        cart.addMedia(book3);

        cart.addMedia(cd1);
        cart.addMedia(cd2);
        cart.addMedia(cd3);

        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);

        launch(args);
    }
}
