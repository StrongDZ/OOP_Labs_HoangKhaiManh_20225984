import javax.swing.JOptionPane;

public class Customize {
    public static void main(String args[]){
        String options[]={"I DO","I DON'T"};
        int option=JOptionPane.showOptionDialog(null,"Do you want to change the to the first ticket","Confirmation",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        JOptionPane.showMessageDialog(null,"You've chosen: "+(option==JOptionPane.YES_OPTION?"Yes":"No"));
        System.exit(0);
    }
}
