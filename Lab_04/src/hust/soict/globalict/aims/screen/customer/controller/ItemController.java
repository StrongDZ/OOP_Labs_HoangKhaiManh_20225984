package hust.soict.globalict.aims.screen.customer.controller;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

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
//    public ItemController(Cart cart){
//        this.cart = cart;
//    }

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

    }

    @FXML
    void btnPlayClicked(ActionEvent event) {

    }

}

