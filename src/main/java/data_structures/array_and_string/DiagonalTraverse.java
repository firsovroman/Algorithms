package data_structures.array_and_string;

import java.util.Arrays;

/**
 * Учитывая m x n матрицу mat, верните массив всех элементов массива в диагональном порядке.
 * <p>
 * Ввод: mat = [[1,2,3],[4,5,6],[7,8,9]]
 * Выход: [1,2,4,7,5,3,6,8,9]
 */
public class DiagonalTraverse {

    public static void main(String[] args) {

        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}; // 1, 2, 4, 7, 5, 3, 6, 8, 9

        System.out.println(Arrays.toString(findDiagonalOrder(array)));

    }

    public static int[] findDiagonalOrder(int[][] mat) {

        int lon = mat.length;
        int width = mat[0].length;
        int[] result = new int[lon * width];

        int row = 0;
        int colum = 0;


        for (int i = 0; i < result.length; i++) {
            result[i] = mat[row][colum];

            if ((row + colum) % 2 == 0) {
                if (colum == width - 1) {
                    row++;
                } else if (row == 0) {
                    colum++;
                } else {
                    row--;
                    colum++;
                }
            } else {
                if (row == lon - 1) {
                    colum++;
                } else if (colum == 0) {
                    row++;
                } else {
                    row++;
                    colum--;
                }
            }
        }


        return result;
    }

}
