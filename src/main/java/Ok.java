import java.util.HashMap;
import java.util.Map;

public class Ok {

    public static Map<Integer, Integer> countElements(int[] array) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int num : array) {
            resultMap.put(num, resultMap.getOrDefault(num, 0) + 1);
        }
        return resultMap;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 4, 5, 1, 5, 4};
        Map<Integer, Integer> result = countElements(array);
        System.out.println(result);
    }


// Groovy решение
//    def countElements(array) {
//        def resultMap = [:].withDefault { 0 }
//        array.each { num ->
//                resultMap[num]++
//        }
//        resultMap
//    }
//
//    def array = [1, 3, 4, 5, 1, 5, 4]
//    def result = countElements(array)
//    println result

}
