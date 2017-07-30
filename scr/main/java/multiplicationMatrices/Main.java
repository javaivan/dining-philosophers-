package multiplicationMatrices;

import javafx.beans.binding.StringBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int heightMatrix = 3;
        int lengthMatrixFirst = 3;
        int lengthMatrixSecond = 3;
        List<List<Long>> firstMatrix = new ArrayList<>();
        List<List<Long>> secondMatrix = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < heightMatrix; i++) {
            List<Long> rowFirst = new ArrayList<>();
            List<Long> rowSecond = new ArrayList<>();
            for (int r = 0; r < lengthMatrixFirst; r++) {
                rowFirst.add((long) (random.nextDouble() * 10000));
            }
            for (int r = 0; r < lengthMatrixSecond; r++) {
                rowSecond.add((long) (random.nextDouble() * 10000));
            }
            firstMatrix.add(rowFirst);
            secondMatrix.add(rowSecond);
        }

        for (int i = 0; i < firstMatrix.size(); i++) {
            for (int r = 0; r < firstMatrix.get(i).size(); r++) {
                System.out.print(addSpaces(firstMatrix.get(i).get(r), 5) + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < secondMatrix.size(); i++) {
            for (int r = 0; r < secondMatrix.get(i).size(); r++) {
                System.out.print(addSpaces(secondMatrix.get(i).get(r), 5) + " ");
            }
            System.out.println();
        }
    }

    public static int getMaxLength(List<List<Long>> matrix) {
        int max = 0;
        for (int i = 0; i < matrix.size(); i++) {
            for (int r = 0; r < matrix.get(i).size(); r++) {
                int current = matrix.get(i).get(r).toString().length();
                if (max < current) {
                    max = current;
                }
            }
        }
        return max;
    }

    public static String addSpaces(Long l, int length) {
        StringBuilder builder = new StringBuilder(l.toString());
        int builderLength = builder.length();
        if (builderLength < length) {
            for (int i = 0; i < (length - builderLength); i++) {
                builder.insert(0," ");
            }
        }
        return builder.toString();
    }
}
