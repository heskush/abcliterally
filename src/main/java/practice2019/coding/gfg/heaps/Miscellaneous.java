package practice2019.coding.gfg.heaps;

import java.util.Arrays;

public class Miscellaneous {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(createTournamentTree(data)));
    }

    //https://www.geeksforgeeks.org/second-minimum-element-using-minimum-comparisons/
    public static void findSecondMinimum(int[] data) {

    }

    public static int[] createTournamentTree(int[] data) {
        int[] tournamentTree = new int[2 * data.length - 1];
        int targetIndex = data.length - 1;
        int sourceIndex = 0;
        while (targetIndex < tournamentTree.length) {
            tournamentTree[targetIndex] = data[sourceIndex];
            targetIndex++;
            sourceIndex++;
        }
        int numberOfLevels = (int) Math.ceil(Math.log(data.length) / Math.log(2));
        int currentLevel = numberOfLevels - 1;
        int levelFirstIndex, levelLastIndex;
        levelLastIndex = data.length - 2;
        while (currentLevel >= 0) {
            levelFirstIndex = levelLastIndex - (int) Math.pow(2, currentLevel) + 1;
            for (int i = levelLastIndex; i <= levelFirstIndex; i--) {
                tournamentTree[i] = Math.min(data[2 * i + 1], data[2 * i + 2]);
            }
            levelLastIndex = levelFirstIndex - 1;
            currentLevel--;
        }
        return tournamentTree;
    }

}
