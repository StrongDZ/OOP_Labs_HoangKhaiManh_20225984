import java.lang.Math;
import javax.swing.JOptionPane;
public class SolveEquation {

    public static void onevar_firstde(){
        double a=Integer.parseInt((String)JOptionPane.showInputDialog(null,"Input coefficient a:","Please enter the covariance",
        JOptionPane.INFORMATION_MESSAGE)),
        b=Integer.parseInt((String)JOptionPane.showInputDialog(null,"Input coefficient b:","Please enter the covariance",
        JOptionPane.INFORMATION_MESSAGE));
        if(a==0)
            if(b==0) JOptionPane.showMessageDialog(null,"This equation has infinite solutions!","Solution of equation",
                        JOptionPane.INFORMATION_MESSAGE);
            else JOptionPane.showMessageDialog(null,"This equation has no solution!","Solution of equation",
            JOptionPane.INFORMATION_MESSAGE);
        else JOptionPane.showMessageDialog(null,"This equation has one solution x = " + Double.toString(-b/a),"Solution of equation",
        JOptionPane.INFORMATION_MESSAGE);
    }

    public static void twovar_firstde() {
        double a11, a12, a21, a22, b1, b2;
    
        a11 = Double.parseDouble((String) JOptionPane.showInputDialog(null, "Input coefficient a11:", "System of first-degree equations with two variables", JOptionPane.INFORMATION_MESSAGE));
        a12 = Double.parseDouble((String) JOptionPane.showInputDialog(null, "Input coefficient a12:", "System of first-degree equations with two variables", JOptionPane.INFORMATION_MESSAGE));
        a21 = Double.parseDouble((String) JOptionPane.showInputDialog(null, "Input coefficient a21:", "System of first-degree equations with two variables", JOptionPane.INFORMATION_MESSAGE));
        a22 = Double.parseDouble((String) JOptionPane.showInputDialog(null, "Input coefficient a22:", "System of first-degree equations with two variables", JOptionPane.INFORMATION_MESSAGE));
        b1 = Double.parseDouble((String) JOptionPane.showInputDialog(null, "Input coefficient b1:", "System of first-degree equations with two variables", JOptionPane.INFORMATION_MESSAGE));
        b2 = Double.parseDouble((String) JOptionPane.showInputDialog(null, "Input coefficient b2:", "System of first-degree equations with two variables", JOptionPane.INFORMATION_MESSAGE));
    
        double det = a11 * a22 - a12 * a21;
    
        if (det == 0) {
            if (a11 * b2 == a21 * b1 && a12 * b2 == a22 * b1) {
                JOptionPane.showMessageDialog(null, "The system of equations has infinite solutions!", "Soltution of system of equations", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "The system of equations has no solutions!", "Soltution of system of equations", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            double x1 = (a22 * b1 - a12 * b2) / det;    
            double x2 = (a11 * b2 - a21 * b1) / det;
            JOptionPane.showMessageDialog(null, "Solution: x1 = " + x1 + ", x2 = " + x2, "Solution of system of equations", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void onevar_seconde() {
        double a, b, c;
    
        do {
            a = Double.parseDouble((String) JOptionPane.showInputDialog(null, "Input coefficient a :", "Second degree equation with one variable", JOptionPane.INFORMATION_MESSAGE));
            if(a==0)JOptionPane.showInputDialog(null, "Coeffiicient a must be different from 0", "Error input", JOptionPane.INFORMATION_MESSAGE);
        } while (a==0); 
    
        b = Double.parseDouble((String) JOptionPane.showInputDialog(null, "Input coefficient b:", "Second degree equation with one variable", JOptionPane.INFORMATION_MESSAGE));
        c = Double.parseDouble((String) JOptionPane.showInputDialog(null, "Input coefficient c:", "Second degree equation with one variable", JOptionPane.INFORMATION_MESSAGE));
        double discriminant = b * b - 4 * a * c;
        if (discriminant > 0) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            JOptionPane.showMessageDialog(null, "Equation has two different solutions:\nx1 = " + x1 + "\nx2 = " + x2, "Solution of equation", JOptionPane.INFORMATION_MESSAGE);
        } else if (discriminant == 0) {
            double x = -b / (2 * a);
            JOptionPane.showMessageDialog(null, "Equation has a double root " + x, "Solution of equation", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Equation has no solution!", "Solution of equation", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public static void main(String args[]){
        String a[]={"1","2"};
        int numvar=   Integer.parseInt((String)JOptionPane.showInputDialog(null,"Input the number of variables:","Number of variables of equation",
        JOptionPane.QUESTION_MESSAGE,null,a,1));
        if(numvar == 1){
            int degree=   Integer.parseInt((String)JOptionPane.showInputDialog(null,"Input the degree of the equation:","Degree of equation",
            JOptionPane.QUESTION_MESSAGE,null,a,1));
            if(degree == 1 ){
                SolveEquation.onevar_firstde(); 
            }
            else SolveEquation.onevar_seconde();
        }
        else SolveEquation.twovar_firstde();
    }
}
