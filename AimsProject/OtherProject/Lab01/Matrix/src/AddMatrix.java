import java.util.Scanner;

public class AddMatrix {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter number of rows: ");
    int rows = scanner.nextInt();
    System.out.print("Enter number of columns: ");
    int columns = scanner.nextInt();

    int[][] matrix1 = new int[rows][columns];
    int[][] matrix2 = new int[rows][columns];

    System.out.println("Input the first matrix:");
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        matrix1[i][j] = scanner.nextInt();
      }
    }

    System.out.println("input  the second matrix:");
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        matrix2[i][j] = scanner.nextInt();
      }
    }

    int[][] result = new int[rows][columns];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        result[i][j] = matrix1[i][j] + matrix2[i][j];
      }
    }

    System.out.println("The result of addition of two matrices:");
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        System.out.print(result[i][j] + " ");
      }
      System.out.println();
    }
    scanner.close();
  }
}