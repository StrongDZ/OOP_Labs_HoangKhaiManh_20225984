import javax.swing.JOptionPane;
import java.lang.Math;

public class ComputeTwoNumbers {
    public static void main(String args[]){
        String strNum1,strNum2;
        String strNotification="You've just entered: ";
        strNum1 = JOptionPane.showInputDialog(null,"Please input the first number","Input the first number",
        JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum1 + " and ";
        strNum2 = JOptionPane.showInputDialog(null,"Please input the second number","Input the second number",
        JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum2;
        double num1 = Double.parseDouble(strNum1),num2 = Double.parseDouble(strNum2);
        strNotification += "\nSum: " + Double.toString(num1+num2);
        strNotification += "\nDifference: " + Double.toString(Math.abs(num1-num2));
        strNotification += "\nProduct: " + Double.toString(num1*num2);
        if (num2 != 0) {
            strNotification += "\nQuotient: " + Double.toString(num1 / num2);
        } else {
            strNotification += "\nQuotient: Undefined (division by zero)";
            
        }
        JOptionPane.showMessageDialog(null,strNotification,"Caculations with two numbers", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
}
