package other;

public class NumberOf1Bits {

    public static void main(String[] args) {
        System.out.println(hammingWeight(521));
    }

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;  // Результат этой операции будет либо 1, если крайний правый бит n равен 1
            n >>>= 1;        // самый правый бит (наименее значимый) отбрасывается, а слева добавляется 0
        }
        return count;
    }


}
