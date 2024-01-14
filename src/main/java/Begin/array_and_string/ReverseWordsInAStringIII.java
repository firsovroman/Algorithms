package Begin.array_and_string;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseWordsInAStringIII {

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }


    public static String reverseWords(String s) {
        return Arrays.stream(s.split(" "))
                .map(it -> new StringBuilder(it).reverse())
                .map(StringBuilder::toString)
                .collect(Collectors.joining(" "));
    }

}
