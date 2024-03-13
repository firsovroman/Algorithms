package other;

public class ReverseBits {

    public static void main(String[] args) {
        System.out.println(reverseBits(10));
    }

    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) | (n & 1); // (n & 1) представляет собой побитовую операцию И (AND) между числом n и двоичным числом 1
            n >>= 1;
        }
        return result;
    }
}
