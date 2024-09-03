public class Approach {
    static boolean[][] flag = null;
    static int[][] maxTour = null;
    static int moves[][] = { { 2, 1 }, { -2, 1 }, { 2, -1 }, { -2, -1 }, { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 } };

    static int knightsTourCount(int i, int j, int N) {
        int max = 1;
        flag[i][j] = true;
        for (int[] points : moves) {
            int x = i + points[0];
            int y = j + points[1];
            if (x >= 0 && x < N && y >= 0 && y < N && !flag[x][y]) {
                int movesCount = 0;
                if (maxTour[x][y] > 0)
                    movesCount = maxTour[x][y] + 1;
                else
                    movesCount = knightsTourCount(x, y, N) + 1;
                max = max > movesCount ? max : movesCount;
            }
        }
        flag[i][j] = false;
        maxTour[i][j] = max;
        return max;
    }

    public static void main(String[] agrs) {
        int N = 8;
        flag = new boolean[N][N];
        maxTour = new int[N][N];
        System.err.println(knightsTourCount(0, 0, N));
    }
}