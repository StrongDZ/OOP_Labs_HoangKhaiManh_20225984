package hust.soict.globalict.aims.screen.customer.controller;

import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import javafx.fxml.FXML;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.scene.layout.AnchorPane;

import java.util.List;

public class PlayingDVDController {

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private Label lbMax;

    @FXML
    private Label lbMin;

    @FXML
    private Label lbInfo;

    private DigitalVideoDisc dvd;

    public PlayingDVDController(DigitalVideoDisc dvd){
        this.dvd = dvd;
    }

    @FXML
    public void initialize() {
        Color semiTransparentColor = new Color(0, 0, 0, 0.5); // Màu đen với độ trong suốt 50%
        BackgroundFill backgroundFill = new BackgroundFill(semiTransparentColor, CornerRadii.EMPTY, null);
        anchorpane.setBackground(new Background(backgroundFill));
        lbInfo.setText("Director: " + dvd.getDirector() +"    Category: " + dvd.getCategory());
        runText(lbInfo);
        lbMin.setText("00:00");
        int length = dvd.getLength();
        lbMax.setText(length/60 +":"+ length%60);
    }

    public void runText(Label lb){
        TranslateTransition translateTransition = new TranslateTransition();

        translateTransition.setNode(lb);
        translateTransition.setDuration(Duration.seconds(10));
        translateTransition.setFromX(-500);
        translateTransition.setToX(1300);
        translateTransition.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition.setAutoReverse(false);

        translateTransition.play();
    }
}
