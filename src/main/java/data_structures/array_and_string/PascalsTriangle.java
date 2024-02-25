package data_structures.array_and_string;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {
        int numRows1 = 5;
        List<List<Integer>> result1 = generate(numRows1);
        System.out.println("Output for numRows = " + numRows1 + ": " + result1);

        int numRows2 = 1;
        List<List<Integer>> result2 = generate(numRows2);
        System.out.println("Output for numRows = " + numRows2 + ": " + result2);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows <= 0) {
            return triangle;
        }

        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum - 1);

            // первый элемент всегда единица 1
            row.add(1);

            // вычисляем центральные элементы
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // последний элемент всегда единица 1
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }
}
