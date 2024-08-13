public class Approach1{

    public static  void towerHanoi(int n,int a, int b, int c){

        if (n==0) return;
        towerHanoi(n-1, a, c, b);
        System.out.println("Move "+a+" to "+b);
        towerHanoi(n-1, c, b, a);
    }
    public static void main(String []args){
        int n = 4;
        towerHanoi(n, 1, 3, 2);
    }
}