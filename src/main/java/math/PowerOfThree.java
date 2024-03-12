package math;

public class PowerOfThree {


    public static void main(String[] args) {
        System.out.println(isPowerOfThree(2147483647));
    }


    public static boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        }

        int i = 1;
        double num;
        while (true) {
            num = Math.pow(3, i);
            i++;
            if (num == n) {
                return true;
            }
            if (num > n) {
                return false;
            }
        }
    }


    /**
     * Если разница между результатом этого выражения и его округлением до ближайшего целого числа очень мала (меньше 1e-10),
     * то число n является степенью тройки, иначе - нет.
     */
    public static boolean isPowerOfThreeSmart(int n) {
        if (n <= 0) {
            return false;
        }

        double logResult = Math.log10(n) / Math.log10(3);
        return Math.abs(logResult - Math.round(logResult)) < 1e-10;
    }

}
