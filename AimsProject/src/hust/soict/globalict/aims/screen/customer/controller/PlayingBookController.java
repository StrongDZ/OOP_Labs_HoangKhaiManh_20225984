package hust.soict.globalict.aims.screen.customer.controller;

import hust.soict.globalict.aims.media.Book;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.List;

public class PlayingBookController {
    private Book book;
    public PlayingBookController(Book book){
        this.book = book;
    }
    @FXML
    private Label lbAuthor;

    @FXML
    private Label lbCost;

    @FXML
    private Label lbBook;

    @FXML
    private Label lbCategory;

    @FXML
    public void initialize() {
        lbBook.setText(book.getTitle());

        List<String> author = book.getAuthors();
        for(int i = 0 ;i < author.size(); i++){
            lbAuthor.setText(lbAuthor.getText() + author.get(i));
            if(i!= author.size()-1)lbAuthor.setText(lbAuthor.getText() + " - ");
        }

        lbCategory.setText("Category: " + book.getCategory());
        lbCost.setText("COST: " + book.getCost() +" $");
    }

}
