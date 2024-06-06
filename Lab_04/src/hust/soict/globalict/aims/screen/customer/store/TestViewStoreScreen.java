package hust.soict.globalict.aims.screen.customer.store;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.screen.customer.controller.ViewStoreController;
import hust.soict.globalict.aims.store.Store;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {

    private static Store store;
    private static Cart cart;

    @Override
    public void start(Stage primaryStage) throws Exception {
        String STORE_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Store.fxml";

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));

        ViewStoreController viewStoreController = new ViewStoreController(store, cart);

        fxmlLoader.setController(viewStoreController);

        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Store");

        primaryStage.setScene(new Scene(root));

        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
        cart = new Cart();

        ObservableList<String> authors1 = FXCollections.observableArrayList("James Gosling", "Bill Joy", "Guy Steele");
        ObservableList<String> authors2 = FXCollections.observableArrayList("Kathy Sierra", "Bert Bates");
        ObservableList<String> authors3 = FXCollections.observableArrayList("Joshua Bloch");

        Book book1 = new Book(1, "Java for Beginners", "Programming", 20.0f, authors1);
        Book book2 = new Book(2, "Head First Java", "Programming", 30.0f, authors2);
        Book book3 = new Book(3, "Effective Java", "Programming", 40.0f, authors3);

        ObservableList<Track> tracks1 = FXCollections.observableArrayList(
                new Track("Speak to Me", 60),
                new Track("Breathe", 168),
                new Track("Money", 690)
        );
        CompactDisc cd1 = new CompactDisc(1, "The Dark Side of the Moon", "Rock", "Pink Floyd", "Hoang Manh", tracks1, 9.5f);

        ObservableList<Track> tracks2 = FXCollections.observableArrayList(
                new Track("Come Together", 410),
                new Track("Something", 370),
                new Track("Here Comes the Sun", 340)
        );
        CompactDisc cd2 = new CompactDisc(2, "Abbey Road", "Rock", "The Beatles", "Hoang Manh", tracks2, 9.5f);

        ObservableList<Track> tracks3 = FXCollections.observableArrayList(
                new Track("Billie Jean", 497),
                new Track("Beat It", 452),
                new Track("Thriller", 525)
        );
        CompactDisc cd3 = new CompactDisc(3, "Thriller", "Pop", "Michael Jackson", "Hoang Manh", tracks3, 9.5f);

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Shawshank Redemption", "Drama", "Frank Darabont", 142, 10.0f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "The Godfather", "Crime", "Francis Ford Coppola", 175, 12.0f);
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

        launch(args);
    }
}
