import java.util.*;

public class Approach {

    // Function to determine if the graph is bipartite
    public static boolean isBipartite(Map<Integer, List<Integer>> students) {
        int n = students.size(); // Number of students (vertices)
        int[] color = new int[n]; // 0 means uncolored, 1 for team A, -1 for team B

        // Iterate over each student
        for (int student = 0; student < n; student++) {
            if (color[student] == 0) { // If the student is uncolored, start BFS
                if (!bfs(student, students, color)) {
                    return false; // If BFS fails, the graph is not bipartite
                }
            }
        }

        // Print the two teams if bipartite
        List<Integer> team1 = new ArrayList<>();
        List<Integer> team2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (color[i] == 1) {
                team1.add(i);
            } else if (color[i] == -1) {
                team2.add(i);
            }
        }
        System.out.println("Team 1: " + team1);
        System.out.println("Team 2: " + team2);
        return true;
    }

    // BFS to color the graph
    private static boolean bfs(int start, Map<Integer, List<Integer>> students, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 1; // Start by assigning the student to team A (1)

        while (!queue.isEmpty()) {
            int currentStudent = queue.poll();

            // Traverse all the enemies of the current student
            for (int enemy : students.get(currentStudent)) {
                if (color[enemy] == 0) { // If the enemy is uncolored
                    color[enemy] = -color[currentStudent]; // Assign opposite team
                    queue.add(enemy);
                } else if (color[enemy] == color[currentStudent]) {
                    // If an enemy has the same color, the graph is not bipartite
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Example 1: Bipartite graph, should return two teams
        Map<Integer, List<Integer>> students1 = new HashMap<>();
        students1.put(0, Arrays.asList(3));
        students1.put(1, Arrays.asList(2));
        students1.put(2, Arrays.asList(1, 4));
        students1.put(3, Arrays.asList(0, 4, 5));
        students1.put(4, Arrays.asList(2, 3));
        students1.put(5, Arrays.asList(3));

        // Example 2: Not bipartite, should return false
        Map<Integer, List<Integer>> students2 = new HashMap<>();
        students2.put(0, Arrays.asList(3));
        students2.put(1, Arrays.asList(2));
        students2.put(2, Arrays.asList(1, 3, 4));
        students2.put(3, Arrays.asList(0, 2, 4, 5));
        students2.put(4, Arrays.asList(2, 3));
        students2.put(5, Arrays.asList(3));

        // Test Case 1: Bipartite, should print two teams
        System.out.println("Test Case 1 Result:");
        if (!isBipartite(students1)) {
            System.out.println("Impossible to divide into two teams.");
        }

        // Test Case 2: Not bipartite, should return false
        System.out.println("\nTest Case 2 Result:");
        if (!isBipartite(students2)) {
            System.out.println("Impossible to divide into two teams.");
        }
    }
}
