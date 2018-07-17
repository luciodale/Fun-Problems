package arraydiagonals;
import java.util.Scanner;

public class ArrayDiagonals {

    /**
     * The method computes the sum of two diagonals of a given matrix and
     * returns the the absolute value of their difference
     * @param a
     * @return absolute difference
     */
    static int diagonalDifference(int[][] a) {

        // finding length of matrix
        int n = a.length;

        // creating variables to store diagonal sums
        int firstSum = 0;
        int secondSum = 0;

        // looping one time and updating diagonal sums at each iteration
        for (int i = 0; i < a.length; i++) {
            firstSum += a[i][n - 1 - i];
            secondSum += a[i][i];
        }

        //returning the absolute value
        return Math.abs(firstSum - secondSum);
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] a = new int[n][n];

        for (int a_i = 0; a_i < n; a_i++) {
            for (int a_j = 0; a_j < n; a_j++) {
                a[a_i][a_j] = in.nextInt();
            }
        }
        int result = diagonalDifference(a);
        System.out.println(result);
        in.close();
    }
}
