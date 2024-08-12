import  java.util.Scanner;

public class  Approach1{

    public static void main(String [] args){

        // for taking integer form standard input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number :");

        try {
            int num = sc.nextInt();

            // Call the palindrome function and print the result
            System.out.println(String.format("Is %d a palindrome? %b",num,checkPalindrome(num)));
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        } finally {
            // Close the scanner
            sc.close();
        }
    }

    public static boolean  checkPalindrome(int num) {
        // check if negative number
        if (num<0){
            return false;
        }
        if (num==0){
            return true;
        }

        int x = 0;
        while (num > x)
        {
            x = x * 10 + num % 10;
            num /= 10;
        }
        return (num == x || (x > num && x / 10 == num));
    }
}
