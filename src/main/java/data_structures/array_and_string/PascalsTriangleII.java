package data_structures.array_and_string;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }


    public static List<Integer> getRow(int rowIndex) {

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);




        for (int numRow = 1; numRow <= rowIndex; numRow++) {
            List<Integer> preRow = triangle.get(numRow - 1);
            List<Integer> row = new ArrayList<>();

            row.add(1);

            for (int j = 1; j < numRow; j++) {
                row.add(preRow.get(j - 1) + preRow.get(j));
            }

            row.add(1);
            triangle.add(row);
        }

        return triangle.get(rowIndex);
    }
}
