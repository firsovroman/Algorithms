package data_structures.array_and_string;

public class ValidPalindrome {


    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama"; // true
        System.out.println(isPalindrome(s));

        String s2 = "race a car"; // false
        System.out.println(isPalindrome(s2));
    }



    public static boolean isPalindrome(String s) {
        String lowAndTrimS = s.toLowerCase().trim();
        char[] arr = lowAndTrimS.toCharArray();

        StringBuilder sb = new StringBuilder();
        for(char ch : arr) {
            if (Character.isAlphabetic(ch) || Character.isDigit(ch)) {
                sb.append(ch);
            }
        }

        if(sb.isEmpty()) {
            return true;
        }

        String result = sb.toString();
        String reverseResult = sb.reverse().toString();

        return result.equals(reverseResult);
    }

}
