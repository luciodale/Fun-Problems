import java.util.*;

/*

GIVEN A SET OF ALLOWED COINS AND A MONETARY VALUE, THIS ALGORITHM FINDS THE SMALLEST AMOUNT
OF COINS THAT MAKES UP THAT VALUE.

IN CASE THE VALUE CANNOT BE MATCHED BY ANY COIN COMBINATION, THE ALGORITHM RETURNS [0]

*/

public class CoinCounting {

    public static void main(String[] args) {
        // to populate ArrayList with coin figures
        List<Integer> myList = new ArrayList<Integer>();
        myList.add(15);
        myList.add(5);
        myList.add(1);
        myList.add(10);

        // to call the method that sorts the array and triggers the recursion
        System.out.println(count_coins(myList, 74));
    }

    /**
     * Method that sorts the ArrayList and populates the fields to be used in the recursion
     * @param coinDenominations
     * @param monetaryValue
     * @return
     */
    static List<Integer> count_coins(List<Integer> coinDenominations, int monetaryValue) {

        // to sort and reverse from biggest to smallest
        Collections.sort(coinDenominations);
        Collections.reverse(coinDenominations);

        // to populate the static fields
        cd = new ArrayList<>(coinDenominations);
        arr = new ArrayList<Integer>();
        mv = monetaryValue;

        // returning recursion
        return recursion(0, 0, 0);
    }

    // to store coin values
    static List<Integer> cd;
    // to store coin sums
    static List<Integer> arr;
    // to iterate and remove from the arr object
    static Iterator<Integer> iterator;

    // to store monetary value to reach
    static int mv;
    // to track the sum in edge cases
    static int bigNumSum = 0;

    /**
     * Recursion method that finds the shortest combination of coins to reach
     * a given value, if there is any.
     * @param sum
     * @param i
     * @param p
     * @return
     */
    public static List<Integer> recursion(int sum, int i, int p) {

        // successful case! Sequence of coins is found
        if (sum == mv) return arr;

        // to reshape the candidate coins when they overflow
        if (sum > mv) {

            // unsuccessful case! Coins do not sum up to given value
            if (p == cd.size() - 1) {
                arr.clear();
                arr.add(0);
                return arr;
            }
            // to reset the candidates to the next biggest value after hitting
            // the lowest possible sum with previous candidates
            else if (i == cd.size() - 1) {

                int temp = arr.remove(0);

                bigNumSum -= temp;
                sum = bigNumSum;
                iterator = arr.iterator();

                // to delete all candidates different from biggest value
                while (iterator.hasNext()) {
                    Integer a = iterator.next();
                    if (a != temp) iterator.remove();
                }

                // to check whether a number was completely consumed or not
                if (arr.size() == 0) {
                    p++;
                    return recursion(sum, p, p);
                } else {
                    return recursion(sum, p + 1, p);
                }
            }
            // base case overflow: to delete latest added number and adding the next smaller one
            else {
                if (i == p) bigNumSum -= cd.get(i);
                sum -= arr.remove(arr.size() - 1);
                return recursion(sum, ++i, p);
            }
        }
        // base case addition: to add a number and push it into the candidates array
        else {
            if (p == i) bigNumSum += cd.get(i);
            sum += cd.get(i);
            arr.add(cd.get(i));
            return recursion(sum, i, p);
        }
    }
}


