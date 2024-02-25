package Data_structures.array_and_string;

public class LongestCommonPrefix {


    public static void main(String[] args) {

        String[] strs = {"flower", "flow", "flight"};

        System.out.println(longestCommonPrefix(strs));
    }


    public static String longestCommonPrefix(String[] strs) {
        String commonPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            commonPrefix = highlightCommonPrefix(commonPrefix, strs[i]);
        }
        return commonPrefix;
    }


    public static String highlightCommonPrefix(String s1, String s2) {
        int minLen = Math.min(s1.length(), s2.length());
        String commonPrefix = "";

        for (int i = 0; i <= minLen; i++) {
            if (s1.substring(0, i).equals(s2.substring(0, i))) {
                commonPrefix = s1.substring(0, i);
            }
        }

        return commonPrefix;
    }

}
