
import javax.swing.JOptionPane;
public class DaysInMonth {

    public static boolean LeapYear(int po){
        if(po%400==0)return true;
        else if(po%100==0)return false;
        else if(po%4==0)return true;
        return false;
    }

    public static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
          if (!Character.isDigit(str.charAt(i))) {
            return false;
          }
        }
        return true;
    }
    public static void main(String args[]){
        String Month[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String[] monthAbbreviations = new String[12];
        String[] month3letter = new String[12];
        String[] monthnum = new String[12];
        for (int i = 0; i < 12; i++) {
            monthAbbreviations[i] = Month[i].substring(0, 3);
            month3letter[i] = Month[i].substring(0, 3);
            monthnum[i]=String.valueOf(i+1);
        }
        String days[][]={
            {"31", "28", "31", "30", "31", "30", "31", "31", "30", "31" ,"30", "31"},
            {"31", "29", "31", "30", "31", "30", "31", "31", "30", "31" ,"30", "31"}
        };
        while(true){
            String ha=JOptionPane.showInputDialog(null, "Please input month: ","Enter the month:",JOptionPane.INFORMATION_MESSAGE);
            int inde=0;
            for(int i=0;i<12;i++)
                if(Month[i].equals(ha)||monthAbbreviations[i].equals(ha)||month3letter[i].equals(ha)|| monthnum[i].equals(ha))inde=i+1;
            
            if(inde==0){
                JOptionPane.showMessageDialog(null,"Please enter month in a valid form","Invalid month input",
                JOptionPane.INFORMATION_MESSAGE);
                continue;
            }
            
            while(true){
                String Year=JOptionPane.showInputDialog(null, "Please input year: ","Enter the year:",
                javax.swing.JOptionPane.INFORMATION_MESSAGE); 
                if(!isNumeric(Year)){
                    JOptionPane.showMessageDialog(null,"Please enter a non-negative integer !","Invalid year input",
                    JOptionPane.INFORMATION_MESSAGE);
                    continue;
                }   

                if(LeapYear(Integer.parseInt(Year))){
                    JOptionPane.showMessageDialog(null,"2004 is leap year!\nNumber of days in "+ Month[inde-1]+" : "+days[1][inde-1],"Calendar in "+Year,
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
                }     
                else JOptionPane.showMessageDialog(null,"Number of days in "+ Month[inde-1]+" : "+days[0][inde-1],"Calendar in "+Year,
                javax.swing.JOptionPane.INFORMATION_MESSAGE);     
                return;    
            }               
        }
    }
}
