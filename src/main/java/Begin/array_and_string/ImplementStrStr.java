package Begin.array_and_string;

public class ImplementStrStr {

    public static void main(String[] args) {

        String haystack = "butsad";
        String needle = "sad";

        String haystack2 = "leetcode";
        String needle2 = "leeto";

        System.out.println(strStr(haystack, needle));
        System.out.println(strStr(haystack2, needle2));

    }

    public static int strStr(String haystack, String needle) {

        int border = needle.length(); // 2
        int res = haystack.length() - border; // 3

        for(int i = 0; i <= res; i++){
            String subHaystack = haystack.substring(i, i+border);
            if(needle.equals(subHaystack)){
                return i;
            }
        }

        return -1;
    }

}
