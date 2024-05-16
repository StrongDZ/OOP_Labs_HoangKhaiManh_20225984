package hust.soict.globalict.swing;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class NumberGrid extends JFrame{
    private JButton[] btnNumbers = new JButton[10];
    private JButton btndelete,btnreset;
    private JTextField tfDisplay;

    public NumberGrid(){
        
        tfDisplay = new JTextField();
        tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        tfDisplay.setPreferredSize(new Dimension(200,40));

        JPanel panelButtons = new JPanel(new GridLayout(4,3));
        addButtons(panelButtons);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(tfDisplay, BorderLayout.NORTH);
        cp.add(panelButtons, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("NumberGrid");
        setSize(200, 200);
        setVisible(true);
    }

    void addButtons(JPanel panelButtons){
        ButtonListener btnListener = new ButtonListener();
        for(int i=1;i<=9;i++){
            btnNumbers[i] = new JButton(""+i);
            panelButtons.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(btnListener);
        }

        btndelete = new JButton("DEL");
        panelButtons.add(btndelete);
        btndelete.addActionListener(btnListener);
        btnNumbers[0] = new JButton("0");
        panelButtons.add(btnNumbers[0]);
        btnNumbers[0].addActionListener(btnListener);
        btnreset =  new JButton("C");
        panelButtons.add(btnreset);
        btnreset.addActionListener(btnListener);
    }

    public class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand();
            if(command.charAt(0) >= '0' && command.charAt(0)<='9'){
                tfDisplay.setText(tfDisplay.getText()+command);
            }
            if(command.equals("DEL")){
                StringBuilder builder = new StringBuilder(tfDisplay.getText());
                builder.deleteCharAt((int)builder.length()-1);
                tfDisplay.setText(builder.toString());
            }
            if(command.equals("C")){
                tfDisplay.setText("");
            }
        }
    }
    public static void main(String[] args){
        new NumberGrid();
    }
}
