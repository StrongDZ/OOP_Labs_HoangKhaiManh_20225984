package hust.soict.globalict.aims.screen.customer.controller;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ItemController {

    private Media media;
    private Cart cart;
    @FXML
    private Button btnAddToCart = new Button();

    @FXML
    private Button btnPlay = new Button();

    @FXML
    private Label lblTitle = new Label();

    @FXML
    private Label lblCost = new Label();
    public void setCart(Cart cart){
        this.cart = cart;
    }
    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 90));
        }
    }

    @FXML
    void btnAddToCartClicked(ActionEvent event) {

        cart.addMedia(media);
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
        try {
            final String CD_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/PlayCD.fxml";
            final String BOOK_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/PlayBook.fxml";
            final String DVD_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/PlayDVD.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader();
            Stage stage = new Stage();
            if(media instanceof CompactDisc){
                stage.setTitle("Playing...");
                fxmlLoader.setLocation(getClass().getResource(CD_FILE_PATH));
                fxmlLoader.setController(new PlayingCDController((CompactDisc) media));
            }
            if(media instanceof Book){
                stage.setTitle("Information");
                fxmlLoader.setLocation(getClass().getResource(BOOK_FILE_PATH));
                fxmlLoader.setController(new PlayingBookController((Book) media));
            }
            if(media instanceof DigitalVideoDisc){
                stage.setTitle(media.getTitle());
                fxmlLoader.setLocation(getClass().getResource(DVD_FILE_PATH));
                fxmlLoader.setController(new PlayingDVDController((DigitalVideoDisc) media));
            }
            Parent root = fxmlLoader.load();

            stage.setScene(new Scene(root));

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

