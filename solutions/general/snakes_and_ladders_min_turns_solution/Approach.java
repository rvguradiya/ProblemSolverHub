import java.util.HashMap;
import java.util.Map;

public class Approach {

    public static int minTurnSolution(Map<Integer, Integer> snakes, Map<Integer, Integer> ladders) {
        int[] dp = new int[100];

        // Initialize dp array with high values (like Infinity)
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        // Traverse through each square of the board
        for (int i = -1; i < 100; i++) {
            for (int j = i + 1; j <= i + 6 && j < 100; j++) {
                if (snakes.containsKey(j + 1)) {
                    dp[j] = Integer.MAX_VALUE; // Skip the snake square
                } else if (j <= 6) {
                    dp[j] = 1; // Early game, squares 1-6 can be reached in 1 turn
                } else {
                    dp[j] = Math.min(dp[j], dp[i] == Integer.MAX_VALUE ? Integer.MAX_VALUE : dp[i] + 1);
                }

                // Handle ladder jumps
                if (ladders.containsKey(j + 1)) {
                    dp[ladders.get(j + 1) - 1] = Math.min(dp[ladders.get(j + 1) - 1], dp[j]);
                }
            }
        }

        return dp[99];
    }

    public static void main(String[] args) {
        // Define the snakes and ladders
        Map<Integer, Integer> snakes = new HashMap<>();
        snakes.put(16, 6);
        snakes.put(48, 26);
        snakes.put(49, 11);
        snakes.put(56, 53);
        snakes.put(62, 19);
        snakes.put(64, 60);
        snakes.put(87, 24);
        snakes.put(93, 73);
        snakes.put(95, 75);
        snakes.put(98, 78);

        Map<Integer, Integer> ladders = new HashMap<>();
        ladders.put(1, 38);
        ladders.put(4, 14);
        ladders.put(9, 31);
        ladders.put(21, 42);
        ladders.put(28, 84);
        ladders.put(36, 44);
        ladders.put(51, 67);
        ladders.put(71, 91);
        ladders.put(80, 100);

        // Call the function and print the result
        System.out.println(minTurnSolution(snakes, ladders)); // Output: 7
    }
}
