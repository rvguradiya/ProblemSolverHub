
import java.util.Arrays;
import java.util.Scanner;

/**
 * this approach use sting method to split string, base on nonNumber string as
 * delimiter
 */
class FindSumFromString {
    public static void main(String[] args) {
        // read string from stdout
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.err.println(sum(str));
    }

    static int sum(String str) {
        String strArr[] = str.split("[^0-9]+");
        int sum = 0;
        // System.out.println(Arrays.toString(strArr) + str);
        for (String numString : strArr) {
            sum += Integer.parseInt(numString);
        }
        return sum;
    }
}