package hust.soict.globalict.aims.screen.customer.controller;

import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.Track;
import javafx.fxml.FXML;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Transform;

public class PlayingCDController {

    @FXML
    private Label lbNameOfCD;

    @FXML
    private TableColumn<Track, String> colTrack;

    @FXML
    private TableView<Track> tblTrack;

    @FXML
    private TableColumn<Track, Integer> colNO;

    @FXML
    private Circle forward;

    @FXML
    private Label lbLength;

    @FXML
    private Circle back;

    @FXML
    private TableColumn<Track, Integer> colLength;

    @FXML
    private Circle pause;

    @FXML
    private Label lbDirector;

    @FXML
    private Label lbArtist;

    @FXML
    private Label lbImage;

    @FXML
    private Label lbCategory;
    @FXML
    private Label lbMax;
    @FXML
    private Label lbMin;
    private CompactDisc cd;

    public PlayingCDController(CompactDisc cd){
        this.cd = cd;
    }
    @FXML
    public void initialize() {
        colNO.setCellValueFactory(
                new PropertyValueFactory<Track, Integer>("no")
        );
        colTrack.setCellValueFactory(
                new PropertyValueFactory<Track, String>("title")
        );
        colLength.setCellValueFactory(
                new PropertyValueFactory<Track, Integer>("length")
        );
        if (cd.getTracklist() != null) {
            tblTrack.setItems(cd.getTracklist());
        }

        lbNameOfCD.setText(cd.getTitle());
        lbArtist.setText("Artist: " + cd.getArtist());
        lbCategory.setText("Category: " + cd.getCategory());
        lbDirector.setText("Director: " + cd.getDirector());
        lbLength.setText("TOTAL LENGTH: " + cd.getLength());
        lbMin.setText("00:00");
        int length = cd.getLength();
        lbMax.setText(length/60 +":"+ length%60);

        Image image = new Image("hust/soict/globalict/aims/screen/customer/image/ImagePlaylist.jpg"); // Đường dẫn đến hình ảnh
        ImageView imageView = new ImageView(image);
        lbImage.setGraphic(imageView);

        setImageToCircle(forward, "hust/soict/globalict/aims/screen/customer/image/forward.png");
        setImageToCircle(pause, "hust/soict/globalict/aims/screen/customer/image/pause.png");
        setImageToCircle(back, "hust/soict/globalict/aims/screen/customer/image/back.png");

    }
    private void setImageToCircle(Circle circle, String imagePath) {
        Image image = new Image(imagePath);
        double radius = circle.getRadius();

        // Resize the image to fit the circle's size
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(radius * 2);
        imageView.setFitHeight(radius * 2);

        SnapshotParameters params = new SnapshotParameters();
        params.setTransform(Transform.scale(radius * 2 , radius * 2 ));
        WritableImage resizedImage = imageView.snapshot(params, null);

        circle.setFill(new ImagePattern(resizedImage));
    }
}


