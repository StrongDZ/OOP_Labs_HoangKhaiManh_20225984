package hust.soict.globalict.aims.screen.customer.controller;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
public class test extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Tạo Label với văn bản cần chạy
        Label marqueeLabel = new Label("This is a marquee text example!");

        // Tạo TranslateTransition
        TranslateTransition translateTransition = new TranslateTransition();

        // Cấu hình TranslateTransition
        translateTransition.setNode(marqueeLabel);
        translateTransition.setDuration(Duration.seconds(5)); // Thời gian di chuyển
        translateTransition.setFromX(-500); // Bắt đầu từ bên ngoài màn hình (bên trái)
        translateTransition.setToX(500); // Kết thúc ở bên ngoài màn hình (bên phải)
        translateTransition.setCycleCount(TranslateTransition.INDEFINITE); // Lặp lại vô hạn
        translateTransition.setAutoReverse(false); // Không đảo ngược

        // Bắt đầu hiệu ứng
        translateTransition.play();

        // Tạo StackPane để chứa Label
        StackPane root = new StackPane(marqueeLabel);

        Scene scene = new Scene(root, 800, 100);
        primaryStage.setTitle("JavaFX Marquee Text Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
