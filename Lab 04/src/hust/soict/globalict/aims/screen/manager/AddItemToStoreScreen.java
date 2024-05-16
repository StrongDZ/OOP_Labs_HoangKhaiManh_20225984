package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddItemToStoreScreen extends JPanel{
    private JLabel lid, ltitle, lcategory, lcost ;
    protected JTextField tfid, tftitle, tfcategory, tfcost;
    protected int id;
    protected String title;
    protected String category;
    protected float cost;
    protected JButton btnadd ;

    protected Store store;
    protected JPanel panel = new JPanel();
    protected JPanel panbut;
    public AddItemToStoreScreen(String s){
        setLayout(new FlowLayout());
        setSize(new Dimension(400,500));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(400,500));

        JLabel title = new JLabel("ADD " +s +" TO STORE");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN,30));
        panel.add(title);
    }
    public void createButton (){
        panbut = new JPanel();
        panbut.setLayout(new BoxLayout(panbut, BoxLayout.X_AXIS));
        panbut.setPreferredSize(new Dimension(400,30));
        btnadd = new JButton("ADD TO STORE");
        panbut.add(Box.createRigidArea(new Dimension(130,30)));
        panbut.add(btnadd);
        panbut.add(Box.createHorizontalGlue());
        panel.add(panbut);
    }

    public void addComponents(){
        lid = new JLabel("ID:");
        ltitle = new JLabel("Title:");
        lcategory = new JLabel("Category:");
        lcost = new JLabel("Cost($):");

        tfid = new JTextField("");
        tftitle = new JTextField("");
        tfcategory = new JTextField("");
        tfcost = new JTextField("");

        panel.add(addPanel(lid,tfid));
        panel.add(addPanel(ltitle,tftitle));
        panel.add(addPanel(lcategory,tfcategory));
        panel.add(addPanel(lcost,tfcost));
    }
    public JPanel addPanel(JLabel label, JTextField tf){
        JPanel pan = new JPanel();
        pan = new JPanel();
        pan.setLayout(new BoxLayout(pan, BoxLayout.X_AXIS));
        pan.setPreferredSize(new Dimension(400,30));

        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setPreferredSize(new Dimension(120, 30));
        tf.setPreferredSize(new Dimension(250, 30));

        pan.add(label);
        pan.add(Box.createRigidArea(new Dimension(10,10)));
        pan.add(tf);
        return pan;
    }

    public JPanel addPanel1(JLabel label, JTextArea tf){
        JPanel pan = new JPanel();
        pan.setLayout(new BoxLayout(pan, BoxLayout.X_AXIS));
        pan.setPreferredSize(new Dimension(400,60));

        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setPreferredSize(new Dimension(120, 60));
        tf = new JTextArea("",3,7);
        JScrollPane scrollPane = new JScrollPane(tf, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        tf.setLineWrap(true);

        pan.add(label);
        pan.add(Box.createRigidArea(new Dimension(10,10)));
        pan.add(scrollPane);
        return pan;
    }

    public class Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            id = Integer.parseInt(tfid.getText());
            title= new String(tftitle.getText());
            category= new String(tfcategory.getText());
            cost= Float.parseFloat(tfcost.getText());
        }
    }
}
