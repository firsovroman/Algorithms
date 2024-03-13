package other;

public class HammingDistance {

    public static void main(String[] args) {
        int x1 = 1, y1 = 4;
        System.out.println("Hamming distance between " + x1 + " and " + y1 + " is: " + hammingDistance(x1, y1));

        int x2 = 3, y2 = 1;
        System.out.println("Hamming distance between " + x2 + " and " + y2 + " is: " + hammingDistance(x2, y2));
    }

    public static int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            distance += xor & 1;
            xor >>= 1;
        }
        return distance;
    }
}
