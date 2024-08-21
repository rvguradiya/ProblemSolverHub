public class Approach {

  public static boolean isHaveSum(int[] arr, int k, int sum, int i) {
    if (sum == 0) {
      return true;
    } else if (i == arr.length || k == 0 || sum < 0) {
      return false;
    }

    if (isHaveSum(arr, k - 1, sum - arr[i], i + 1) == true) {
      return true;
    } else {
      return isHaveSum(arr, k, sum, i + 1);
    }
  }

  public static void main(String[] args) {
    int[] arr = { 20, 303, 3, 4, 25 };
    int k = 3;
    int sum = 49;

    System.out.println(isHaveSum(arr, k, sum, 0));
  }
}
