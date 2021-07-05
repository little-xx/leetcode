package backtracking;

public class MinDist {

    private int minDist = Integer.MAX_VALUE;

    public void minDistBT(int i, int j, int dist, int[][] w, int n) {
        if (i == n - 1 && j == n - 1) {
            dist += w[i][j];
            if (minDist > dist) {
                minDist = dist;
            }
        }
        if (i < n - 1) {
            minDistBT(i + 1, j, dist + w[i][j], w, n);
        }
        if (j < n - 1) {
            minDistBT(i, j + 1, dist + w[i][j], w, n);
        }
    }

    public static void main(String[] args) {
        MinDist minDist = new MinDist();
        int[][] w = {{1, 3, 5 ,9}, {2, 1, 3, 4}, {5, 2, 6, 7}, {6, 8, 4, 3}};
        minDist.minDistBT(0, 0, 0, w, 4);
        System.out.println(minDist.minDist);
    }
}
