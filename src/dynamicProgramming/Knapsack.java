package dynamicProgramming;

import java.util.List;

public class Knapsack {

    public static void main(String[] args) {
        int[] weight = {2, 2, 4, 6, 3};
        int[] value = {3, 4, 8, 9, 6};
        int n = 5;
        int w = 9;
        System.out.println("Max value: " + knapsack3(weight, value, n, w));
    }

    public static int knapsack(int[] weight, int n, int w) {
        boolean[][] flag = new boolean[n][w + 1];
        flag[0][0] = true;
        if (weight[0] <= w) {
            flag[0][weight[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if (flag[i - 1][j] == true) {
                    flag[i][j] = true;
                    if (j + weight[i] <= w) {
                        flag[i][j+weight[i]] = true;
                    }
                }
            }
        }
        for (int i = w; i > 0; i--) {
            if (flag[n - 1][i] == true) return i;
        }
        return 0;
    }

    public static int knapsack2(int[] weight, int n, int w) {
        boolean[] flag = new boolean[w + 1];
        flag[0] = true;
        if (weight[0] <= w) {
            flag[weight[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = w - weight[i]; j >= 0; j--) {
                if (flag[j] == true) {
                    flag[j + weight[i]] = true;
                }
            }
        }
        for (int i = w; i >= 0; i++) {
            if (flag[i] == true) return i;
        }
        return 0;
    }

    public static int knapsack3(int[] weight, int[] value, int n, int w) {
        int[] bag = new int[w + 1];
        for (int i = 0; i <= w; i++) {
            bag[i] = -1;
        }
        bag[0] = 0;
        if (weight[0] <= w) {
            bag[weight[0]] = value[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = w - weight[i]; j >= 0; j--) {
                if (bag[j] != -1) {
                    if (bag[j] + value[i] > bag[j + weight[i]]) {
                        bag[j + weight[i]] = bag[j] + value[i];
                    }
                }
            }
        }
        int maxValue = 0;
        for (int i = w; i >= 0; i --) {
            if (bag[i] > maxValue) {
                maxValue = bag[i];
            }
        }
        return maxValue;
    }
}
