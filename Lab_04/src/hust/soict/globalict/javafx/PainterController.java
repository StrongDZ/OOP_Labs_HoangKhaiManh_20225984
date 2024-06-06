package hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {


    @FXML
    private RadioButton eraser;

    @FXML
    private RadioButton pen;

    @FXML
    private Pane drawingArea;

    @FXML
    private ToggleGroup i;

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        if(pen.isSelected()){
            Circle newCircle = new Circle(event.getX(),event.getY(),4, Color.BLACK);
            drawingArea.getChildren().add(newCircle);
        }
        else {
            Circle newCircle = new Circle(event.getX(),event.getY(),4, Color.WHITE);
            drawingArea.getChildren().add(newCircle);
        }
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingArea.getChildren().clear();
    }

//    @FXML
//    void draw(ActionEvent event){
//        drawingArea.getChildren().addListener(new ActionListener(){
//    }

}
