import java.util.Scanner;
public class StarTriangle {
    public static void main(String args[]){
        Scanner input= new Scanner(System.in);
        System.out.print("Enter height of the triangle: ");
        int n=input.nextInt();
        String star=new String();
        star="*";
        while((n--)!=0){
            String empty=new String();
            for(int i=1;i<=n;i++)empty+=" "; 
            System.out.println(empty+star+empty);
            star+="**";
        }
        input.close();
        
    }
}
