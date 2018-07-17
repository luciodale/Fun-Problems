import java.util.Arrays;

public class HourGlass {

    //  static fields
    static int arr[][];
    static int highestSum = Integer.MIN_VALUE;
    static int tempSum = 0;

    /**
     * Summing up the hourglass shape
     * @param a
     * @param b
     * @return int
     */
    static public int sum(int a, int b) {
        return  arr[a][b] + arr[a][b - 1] + arr[a][b - 2] +
                arr[a - 1][b - 1] +
                arr[a - 2][b] + arr[a - 2][b - 1] + arr[a - 2][b - 2];
    }

    /**
     * recursively shifting the hourglass across the 2D array
     * @param a
     * @param b
     * @return
     */
    public static int recursion(int a, int b) {
        //  do sum operation
        tempSum = sum(a, b);
        //  to update sum
        if (tempSum > highestSum) highestSum = tempSum;
        //  to detect when the last array index is reached
        if (a == arr.length - 1 && b == arr[arr.length - 1].length - 1) {
            return highestSum;
            //  to shift the hourglass one index down when the right end of array is reached
        } else if (b == arr[arr.length - 1].length - 1) {
            return recursion(++a, b - b + 2);
            //  edge case -> to stop in case of a NON SQUARE 2D array
        } else if (a == arr.length - 1 && b == arr[arr.length - 1].length - 1) {
            return highestSum;
            //   to shift the hourglass one index right
        } else {
            return recursion(a, ++b);
        }
    }

    /**
     * Main to generate 2D array and call recursive method
     * @param args
     */
    public static void main(String[] args) {

        arr = new int[50][50];
        int num = 0;
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                arr[i][j] = num++;
            }
        }
        //  total -> expected highest sum
        int l = arr.length - 1;
        int total = arr[l][l] + arr[l][l - 1] + arr[l][l - 2] +
                            arr[l - 1][l - 1] +
                arr[l - 2][l] + arr[l - 2][l - 1] + arr[l - 2][l - 2];
        System.out.println(total);

        //  printing 2D array in nice format
        for (int[] row : arr)
            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));

       //   calling recursive method
        int a = recursion(2, 2);
        //  printing result
        System.out.println(a);
    }
}
