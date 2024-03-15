import java.util.Scanner;
import java.util.Arrays;
public class SortSumAverage {

    public static void main(String[] args) {
      Scanner scanner= new Scanner(System.in);
      System.out.print("Enter the number of elements: ");
      int n= scanner.nextInt();
      System.out.print("Enter the array: ");
      int[] num=new int[n];
      for(int i=0;i<n;i++)num[i]=scanner.nextInt();
      Arrays.sort(num);
      int totalSum = 0;
      for (int value : num) {
        totalSum += value;
      }
  
      double average = (double) totalSum / num.length;
  
      System.out.print("Sorted array:");
      System.out.println(Arrays.toString(num));
      System.out.println("Sum of elements: " + totalSum);
      System.out.println("Average of elements: " + average);
      scanner.close();
    }
  }