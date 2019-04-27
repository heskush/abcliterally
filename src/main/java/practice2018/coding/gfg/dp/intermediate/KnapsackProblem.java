package practice2018.coding.gfg.dp.intermediate;

import java.util.Arrays;
import java.util.Comparator;

// author -- hemantkumar

/*
 *       https://www.geeksforgeeks.org/knapsack-problem/
 *
 * */
public class KnapsackProblem {
    int[] valuesArr;
    int[] weightsArr;
    int maxWeight;

    public KnapsackProblem(int[] valuesArr, int[] weightsArr, int maxWeight) {
        this.valuesArr = valuesArr;
        this.weightsArr = weightsArr;
        this.maxWeight = maxWeight;
    }

    public static KnapsackProblem initialize(int[] valuesArrr, int[] weigthArr, int maxWeight) {
        return new KnapsackProblem(valuesArrr, weigthArr, maxWeight);

    }


    public static int[][] knapsack(int[] valuesArr, int[] weightsArr, int maxCapacity) {
//        Row has item index and column has capacity .
        int nItems = weightsArr.length;
        int[][] dpSolArr = new int[nItems + 1][maxCapacity + 1];
        for (int i = 0; i < maxCapacity + 1; i++) {
            dpSolArr[0][i] = 0;
        }
        for (int i = 0; i < weightsArr.length + 1; i++) {
            dpSolArr[i][0] = 0;
        }

        for (int itemIndex = 1; itemIndex <= nItems; itemIndex++) {
            for (int capacity = 1; capacity <= maxCapacity; capacity++) {
                int weight = weightsArr[itemIndex - 1];
                if (weight > capacity) {
                    dpSolArr[itemIndex][capacity] = dpSolArr[itemIndex - 1][capacity];
                }
                if (weight <= capacity) {
                    dpSolArr[itemIndex][capacity] = Math.max(
                            dpSolArr[itemIndex - 1][capacity],
                            dpSolArr[itemIndex - 1][capacity - weight] + valuesArr[itemIndex - 1]);
                }
            }
        }
        return dpSolArr;
    }

    public int solve() {
        int[][] dpSolArr = knapsack(valuesArr, weightsArr, maxWeight);
        Integer maxVal = Arrays.stream(dpSolArr).map(x -> {
            Arrays.sort(x);
            return x[x.length - 1];
        }).max(Comparator.naturalOrder()).get();
        return maxVal;


    }

    public static void main(String[] args) {
        int maxValuePossible = KnapsackProblem.initialize(new int[]{60, 100, 120}, new int[]{10, 20, 30}, 50).solve();
        System.out.println(maxValuePossible);

    }

}
