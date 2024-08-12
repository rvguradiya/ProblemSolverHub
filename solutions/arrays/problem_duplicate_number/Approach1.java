import  java.util.Scanner;
public class Approach1 {
    public static void main(String [] args){
        Scanner sc  = new Scanner(System.in);
        System.err.println("Enter the size of array :");
        int n = sc.nextInt();
        int arr[] = new int[n+1];
        System.err.println("Enter the values for array");
        for (int i =0;i<arr.length ; i++) {
            arr[i]= sc.nextInt();
        }

        System.err.println("Duplicate Value is:"+findDuplicateElement(arr));
    }

    public static int findDuplicateElement(int [] arr){
        int tempArr[] = new int[arr.length-1];
        int duplicateValue = 0;

        for (int elem:arr){
            if (tempArr[elem-1]==0){
                tempArr[elem-1]=elem;
            }
            else{
                duplicateValue =  elem;
                break;
            }
        }
        return duplicateValue;
    }
}