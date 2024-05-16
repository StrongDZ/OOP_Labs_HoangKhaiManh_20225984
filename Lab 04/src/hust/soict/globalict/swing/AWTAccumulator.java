package hust.soict.globalict.swing;
import java.awt.*;
import java.awt.event.*;
public class AWTAccumulator extends Frame {
    private TextField tfInput;
    private TextField tfoutput;
    int sum;
    
    public AWTAccumulator() {
        setLayout(new GridLayout(2, 2));
        add(new Label("Enter an Integer: "));
        tfInput = new TextField(10);
        add(tfInput);
        tfInput.addActionListener(new TFInputListener());
        add(new Label("The Accumulated Sum is: "));
        tfoutput = new TextField(10);
        tfoutput.setEditable(false);
        add(tfoutput);
        setTitle("AWT Accumulator");
        setSize(350, 120);
        setVisible(true);
    }
    public static void main(String[] args) {
        new AWTAccumulator();
    }
    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn;
            tfoutput.setText(sum + "");
            tfInput.setText("");
        }
    }
}