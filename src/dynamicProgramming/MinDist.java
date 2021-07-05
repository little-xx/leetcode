package dynamicProgramming;

public class MinDist {

    public int minDistBT(int[][] w, int n) {
        int[][] dist = new int[n][n];
        int xSum = 0;
        int ySum = 0;
        for (int i = 0; i < n; i++) {
            xSum += w[i][0];
            dist[i][0] = xSum;
            ySum += w[0][i];
            dist[0][i] = ySum;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dist[i][j] = w[i][j] + Math.min(dist[i - 1][j], dist[i][j - 1]);
            }
        }
        return dist[n - 1][n - 1];
    }

    public static void main(String[] args) {
        MinDist minDist = new MinDist();
        int[][] w = {{1, 3, 5 ,9}, {2, 1, 3, 4}, {5, 2, 6, 7}, {6, 8, 4, 3}};
        System.out.println(minDist.minDistBT(w, 4));
    }
}
