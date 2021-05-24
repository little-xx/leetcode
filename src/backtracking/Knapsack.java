package backtracking;

import java.util.List;

public class Knapsack {

    private int maxW = Integer.MIN_VALUE;

    private int maxValue = Integer.MIN_VALUE;

    private int[] weight = {2, 2, 4, 6, 3};

    private int[] value = {3, 4, 8, 9, 6};

    private List<Integer> items;

    private int n = 5;

    private int w = 9;

    private void f(int i, int cw) {
        if (cw == w || i == n) {
            System.out.println("Weight of loaded items: " + cw);
            if (maxW < cw) {
                maxW = cw;
            }
            return;
        }
        f(i + 1, cw);
        if (cw + weight[i] <= w) {
            items.add(i);
            f(i + 1, cw + weight[i]);
        }
    }

    private void f(int i, int cw, int v) {
        if (cw == w || i == n) {
            System.out.println("Weight of loaded items: " + cw);
            System.out.println("Value of loaded items: " + v);
            if (maxValue < v) {
                maxValue = v;
            }
            return;
        }
        f(i + 1, cw, v);
        if (cw + weight[i] <= w) {
            f(i + 1, cw + weight[i], v + value[i]);
        }
    }

    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        knapsack.f(0 , 0, 0);
        System.out.println("Max weight: " + knapsack.maxValue);
    }
}
