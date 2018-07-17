package plusminus;

import java.util.Scanner;

public class PlusMinus {

    /**
     * This method takes an array of integers, counts how many positive, negative, and zero numbers
     * are contained in the data structure, and prints the ratio of each category above described with
     * the array length
     * @param arr
     */
    static void plusMinus(int[] arr) {

        double positive = 0;
        double negative = 0;
        double zero = 0;

        for(int i = 0; i < arr.length; i++){

            // if arr[i] is less then zero increase negative. If it is greater
            // than zero increase positive. Else increase zero.
           double a = (arr[i] < 0) ? negative++ : (arr[i] > 0 ? positive++ : zero++);
        }

        // printing only 6 decimal places after the comma
        System.out.println(Math.round(positive/arr.length * 1000000.0) / 1000000.0);
        System.out.println(Math.round(negative/arr.length * 1000000.0) / 1000000.0);
        System.out.println(Math.round(zero/arr.length * 1000000.0) / 1000000.0);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        plusMinus(arr);
        in.close();
    }
}
