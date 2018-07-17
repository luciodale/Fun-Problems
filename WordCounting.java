import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordCounting {

    /**
     * Method that takes a chunk of text and returns the sentence with the highest
     * number of words. Sentences are delimited with periods, question and exclamation marks
     * @param s
     * @return int
     */
    public static int solution(String s) {

        //  regex to split at period, question mark, and exclamation mark
        String delims = "[.?!]+";
        String spaces = "[\\s]*";
        String doubleSpace = s.replaceAll(spaces + delims + spaces, "  ");

        String[] tokens = doubleSpace.split("  ");
        int[] wordCount = new int[tokens.length];

        int solution = 0;

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].split(" ").length > solution) {
                solution = tokens[i].split(" ").length;
            }
            wordCount[i] = tokens[i].split("[\\s\\s]+").length;
        }

        // maximum number of words in sentence
        return solution;
    }

    public static void main(String[] args) {

        String string = "lda mdlk. ldjfn! !!. dlfjnd ..d danfdakj! kadjfnda ! ?lsdjn DJ dsv.";
        System.out.println(solution(string));

    }
}
