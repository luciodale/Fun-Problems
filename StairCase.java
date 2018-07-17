package staircase;

import java.util.Scanner;

public class StairCase {

    /**
     * Given an integer, the method prints a staircase of with base and height n
     * @param n
     */
    static void staircase(int n) {

        // printing a stair case:
        //         #
        //        ##
        //       ### ... until n times

        for (int i = 1; i <= n; i++) {
            for (int a = n; a > 0; a--) {
                if (i >= a) System.out.print("#");
                else System.out.print(" ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        staircase(n);
        in.close();
    }
}
