package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddBookToStoreScreen extends AddItemToStoreScreen{
    JLabel lauthor;
    JTextArea tfauthor;
    private String artist;
    private List<String> author = new ArrayList<>();
    Store store;
    public AddBookToStoreScreen(Store store){
        super("BOOK");

        this.store= store;
        this.addComponents();
        super.createButton();
        btnadd.addActionListener(new Listener());
        add(panel);
        setVisible(true);
    }

    @Override
    public void addComponents(){
        super.addComponents();
        lauthor = new JLabel("author:");

        tfauthor = new JTextArea("");
        tfauthor.setPreferredSize(new Dimension(500, 200));

        panel.add(addPanel1(lauthor, tfauthor));

    }

    public class Listener extends AddItemToStoreScreen.Listener{
        @Override
        public void actionPerformed(ActionEvent e){
            super.actionPerformed(e);
            author = Arrays.asList(tfauthor.getText().split("\\S+\n"));
            store.addMedia(new Book(id, title, category, cost, author ));
        }
    }
}
