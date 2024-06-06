package hust.soict.globalict.aims.screen.customer.controller;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class CartController {
    private Cart cart;
    private Store store;
    private Media currentMedia;
    public CartController(Store store, Cart cart){
        this.cart = cart;
        this.store = store;
    }
    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private Label costLabel;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnPlay;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TextField tfFilter;
    @FXML
    private RadioButton radioBtnFilterId;
    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private Button btnPlaceOrder;
    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(
                new PropertyValueFactory<Media, Integer>("Id")
        );
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("Title")
        );
        colMediaCategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("Category")
        );
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, Float>("Cost")
        );
        if (cart.getItemsOrdered() != null) {
            tblMedia.setItems(cart.getItemsOrdered());
        }
        lbtotalcost();
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observableValue, Media oldvalue, Media newvalue) {
                updateButtonBar(newvalue);
                currentMedia = newvalue;
            }
        });
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldvalue, String newvalue) {
                if(newvalue.isEmpty()){
                    tblMedia.setItems(cart.getItemsOrdered());
                    return;
                }
                if (radioBtnFilterId.isSelected()) {
                    if(!newvalue.matches("\\d*")) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Input Error");
                        alert.setHeaderText(null);
                        alert.setContentText("Please enter a valid integer ID.");
                        alert.showAndWait();
                        tfFilter.setText(oldvalue);
                    }
                    else showFilteredMedia(newvalue);
                }
                else showFilteredMedia(newvalue);

            }
        });
    }
    public void showFilteredMedia(String s){
        ObservableList<Media> newcart;
        if(radioBtnFilterId.isSelected()){
            newcart = cart.SearchByID(Integer.parseInt(s));
        }
        else{
            newcart = cart.SearchByTitle(s);
        }
        tblMedia.setItems(newcart);
    }
    public void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        } else {
            btnRemove.setVisible(true);
            btnPlay.setVisible(true);
            if (media instanceof Book)
                btnPlay.setText("Show info");
            else
                btnPlay.setText("Play");

        }
    }
    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        lbtotalcost();
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        try {
            final String CD_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/PlayCD.fxml";
            final String BOOK_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/PlayBook.fxml";
            final String DVD_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/PlayDVD.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader();
            Stage stage = new Stage();
            if(currentMedia instanceof CompactDisc){
                stage.setTitle("Playing...");
                fxmlLoader.setLocation(getClass().getResource(CD_FILE_PATH));
                fxmlLoader.setController(new PlayingCDController((CompactDisc) currentMedia));
            }
            if(currentMedia instanceof Book){
                stage.setTitle("Information");
                fxmlLoader.setLocation(getClass().getResource(BOOK_FILE_PATH));
                fxmlLoader.setController(new PlayingBookController((Book) currentMedia));
            }
            if(currentMedia instanceof DigitalVideoDisc){
                stage.setTitle(currentMedia.getTitle());
                fxmlLoader.setLocation(getClass().getResource(DVD_FILE_PATH));
                fxmlLoader.setController(new PlayingDVDController((DigitalVideoDisc) currentMedia));
            }
            Parent root = fxmlLoader.load();

            stage.setScene(new Scene(root));

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            final String STORE_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(STORE_FXML_FILE_PATH));
            fxmlLoader.setController(new ViewStoreController(store, cart));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Cart");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void lbtotalcost(){
        costLabel.setText(cart.totalCost()+" $");
    }
    @FXML
    void btnPlaceOrderPressed(){
        if(cart.getItemsOrdered().isEmpty()){
            JOptionPane.showMessageDialog(null, "You have not put anything in your cart");
            return;
        }
        JOptionPane.showMessageDialog(null, "You did successfully order! Total cost is " + costLabel.getText());
        cart.clear();
        lbtotalcost();
    }
}
