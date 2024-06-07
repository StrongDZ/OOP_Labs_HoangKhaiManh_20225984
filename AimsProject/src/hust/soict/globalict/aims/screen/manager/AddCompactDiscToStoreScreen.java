package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.store.Store;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCompactDiscToStoreScreen extends  AddItemToStoreScreen{
    JLabel lartist, ldirector, llength, ltrack;
    JTextField tfartist, tfdirector, tflength, tftrack;
    private String artist;
    private ObservableList<Track> tracklist = FXCollections.observableArrayList();
    private String director;
    Store store;
    JPanel trackscreen, pandone;
    JTextArea Listoftrack ;
    JButton btntrack;
    public AddCompactDiscToStoreScreen(Store store){
        super("CD");

        this.store= store;
        this.addComponents();
        super.createButton();
        btnadd.addActionListener(new Listener());
        add(panel);
        setVisible(true);
    }

    @Override
    public void addComponents(){
//        JOptionPane.showMessageDialog(null, "buoc 1");
        super.addComponents();
//        JOptionPane.showMessageDialog(null, "buoc 2");
        lartist = new JLabel("Artist:");
        ldirector = new JLabel("Director:");

        tfartist = new JTextField("");
        tfdirector = new JTextField("");

        panel.add(addPanel(lartist,tfartist));
        panel.add(addPanel(ldirector, tfdirector));
    }

    public void turnonoff(boolean status){
        tfartist.setEditable(status);
        tfdirector.setEditable(status);
        tfcost.setEditable(status);
        tfcategory.setEditable(status);
        tftitle.setEditable(status);
        tfid.setEditable(status);
    }
    public JPanel TrackScreen(){
        JPanel addTrack = new JPanel();
        addTrack.setLayout(new BoxLayout(addTrack, BoxLayout.X_AXIS));
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        addTrack.setPreferredSize(new Dimension(500,90));
//        addTrack.setBorder(border);

        JPanel rightside = new JPanel();
        rightside.setLayout(new BoxLayout(rightside, BoxLayout.Y_AXIS));
        rightside.setPreferredSize(new Dimension(200,90));
        rightside.setBorder(border);

        ltrack = new JLabel("Track name:");
        tftrack = new JTextField("");

        llength = new JLabel("Length of track:");
        tflength = new JTextField("");

        btntrack = new JButton("Add track");
        btntrack.addActionListener(new TrackListener());

        Listoftrack = new JTextArea(("Tracklist:"));
        Listoftrack.setBorder(border);
        Listoftrack.setEditable(false);

//        JOptionPane.showMessageDialog(null,"hhahahaha");
        rightside.add(addPanel(ltrack,tftrack));

        rightside.add(addPanel(llength,tflength));
        rightside.add(btntrack);

        addTrack.add(rightside);
        addTrack.add(Box.createRigidArea(new Dimension(10,10)));
        addTrack.add(Listoftrack);

        return addTrack;
    }
    public void CreateTrackList(){
        turnonoff(false);
        remove(panel);
        panel.remove(panbut);
        panel.add(trackscreen=TrackScreen());

        pandone = new JPanel();
        pandone.setLayout(new BoxLayout(pandone, BoxLayout.X_AXIS));
        pandone.setPreferredSize(new Dimension(400,30));
        JButton btndone = new JButton("ADD CD");
        btndone.addActionListener(new DoneListener());

        pandone.add(Box.createRigidArea(new Dimension(130,30)));
        pandone.add(btndone);
        pandone.add(Box.createHorizontalGlue());
        panel.add(pandone);


        add(panel);
        revalidate();
        repaint();
        setVisible(true);
    }

    public class Listener extends AddItemToStoreScreen.Listener {
        @Override
        public void actionPerformed(ActionEvent e){
            super.actionPerformed(e);
            CreateTrackList();
        }
    }

    public  class TrackListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String name = new String(tftrack.getText());
            int leng = Integer.parseInt(tflength.getText());
            tracklist.add(new Track(name,leng));
            Listoftrack.setText(Listoftrack.getText()+"\n"+tracklist.size()+". "+
                    name+" - Length: "+leng);
        }
    }

    public void restart(){
        remove(panel);
        panel.remove(trackscreen);
        panel.remove(pandone);
        panel.add(panbut);
        add(panel);
        revalidate();
        repaint();
        setVisible(true);
        turnonoff(true);
    }
    public class DoneListener extends AddItemToStoreScreen.Listener{
        @Override
        public void actionPerformed(ActionEvent e){
            super.actionPerformed(e);
            director = new String(tfdirector.getText());
            artist = new String(tfartist.getText());
//            tracklist = (ArrayList<Track>) tftracklist.getText().split("\\S+\n");

            store.addMedia(new CompactDisc(id, title, category, artist, director, tracklist, cost));
            restart();
        }
    }

}
