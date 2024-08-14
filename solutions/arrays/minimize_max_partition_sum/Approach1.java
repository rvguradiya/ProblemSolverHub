public class Approach1 {

    public static void main(String[] args) {
        int[] N = {5, 1, 2, 7, 3, 4};
        int k = 3;
        System.out.println(minimizeMaxPartitionSum(N, k));  // Output: 8
    }

    public static int minimizeMaxPartitionSum(int[] N, int k) {
        int left = findMax(N);
        int right = sumArray(N);

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canPartition(N, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static int findMax(int[] N) {
        int max = Integer.MIN_VALUE;
        for (int num : N) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    private static int sumArray(int[] N) {
        int sum = 0;
        for (int num : N) {
            sum += num;
        }
        return sum;
    }

    private static boolean canPartition(int[] N, int k, int maxSum) {
        int currentSum = 0;
        int requiredPartitions = 1;

        for (int num : N) {
            if (currentSum + num > maxSum) {
                requiredPartitions++;
                currentSum = num;
                if (requiredPartitions > k) {
                    return false;
                }
            } else {
                currentSum += num;
            }
        }

        return true;
    }
}
