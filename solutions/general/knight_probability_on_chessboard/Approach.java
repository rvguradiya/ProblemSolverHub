public class Approach{
    
    static  int  possibleMoves[][] = {
        {2, -1},
        {2, 1},
        {-2, -1},
        {-2, 1},
        {1, 2},
        {1, -2},
        {-1, 2},
        {-1, -2},
    };

    static  int [][]visited;

    // for testing purpose 
    static void print(){
        for (int [] row:visited){
            String s = " ";
            for(int col: row){
                s += col;
            }
            System.err.println(s);
        }
    }

    static double   knightProbability(int K,int N,int row,int col){
        if (visited[row][col] == 1) {
            return 0;
        } else if (K == 0) {
            return 1;
        }
      
        visited[row][col] = 1;
        double probability = 0;
        int countMove = 0;
        for (int [] knightMove : possibleMoves) {
            int xMove = knightMove[0] + row;
            int yMove = knightMove[1] + col;
            if (0 <= xMove && xMove < N && 0 <= yMove && yMove < N) {
              countMove++;
            //   System.err.println(""+K+""+probability+""+xMove+""+yMove);
            //   print();
              probability += knightProbability(K-1, N, xMove, yMove);
            }
          }
          visited[row][col] = 0;
          return countMove>0 ? probability / countMove : probability;
        }
    
    public static void main(String args[]){
        int N = 3;
        int K = 7;

        if (visited == null){
            visited = new int[N][N];
        }

        System.out.println(knightProbability(K, N, 0, 0));
    }
}