package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen{
    JLabel ldirector, llength;
    JTextField tfdirector, tflength;
    private String director;
    private int length;
    Store store;
    Listener btnlis = new Listener();
    public AddDigitalVideoDiscToStoreScreen(Store store){
        super("DVD");

        this.store= store;
        this.addComponents();
        super.createButton();
        btnadd.addActionListener(new Listener());
        add(panel);
        add(Box.createGlue());
        setVisible(true);
    }

    @Override
    public void addComponents(){
        super.addComponents();
        ldirector = new JLabel("Director:");
        llength = new JLabel("Length:");

        tfdirector = new JTextField("");
        tflength = new JTextField("");

        panel.add(addPanel(ldirector,tfdirector));
        panel.add(addPanel(llength,tflength));
    }

    public class Listener extends AddItemToStoreScreen.Listener {
        @Override
        public void actionPerformed(ActionEvent e){
            super.actionPerformed(e);
//            JOptionPane.showMessageDialog(null, "doanxem");
            director = new String(tfdirector.getText());
            length = Integer.parseInt(tflength.getText());
            store.addMedia(new DigitalVideoDisc(id, title, category, director, length, cost ));
        }
    }
}
