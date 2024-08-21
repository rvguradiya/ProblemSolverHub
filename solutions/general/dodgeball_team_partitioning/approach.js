function isBipartite(students) {
  const n = Object.keys(students).length; // Number of students (vertices)
  const color = Array(n).fill(0); // 0 means uncolored, 1 for team A, -1 for team B

  // Helper function to perform BFS
  const bfs = (student) => {
    const queue = [student];
    color[student] = 1; // Start coloring the first student with team A (1)

    while (queue.length > 0) {
      const currentStudent = queue.shift();

      // Traverse all enemies of the current student
      for (const enemy of students[currentStudent]) {
        if (color[enemy] === 0) {
          // If enemy is not yet colored
          color[enemy] = -color[currentStudent]; // Assign opposite team
          queue.push(enemy);
        } else if (color[enemy] === color[currentStudent]) {
          // If enemy has the same color as the current student, it's not bipartite
          return false;
        }
      }
    }
    return true;
  };

  // Try to color each component of the graph
  for (let student = 0; student < n; student++) {
    if (color[student] === 0) {
      // If student is uncolored
      if (!bfs(student)) {
        return false; // If one component is not bipartite, return false
      }
    }
  }

  // Separate students into two teams based on their color
  const team1 = [];
  const team2 = [];
  for (let i = 0; i < n; i++) {
    if (color[i] === 1) {
      team1.push(i);
    } else if (color[i] === -1) {
      team2.push(i);
    }
  }

  return [team1, team2]; // Return the two teams
}

// Example 1: Should return two teams
const students1 = {
  0: [3],
  1: [2],
  2: [1, 4],
  3: [0, 4, 5],
  4: [2, 3],
  5: [3],
};

// Example 2: Should return false
const students2 = {
  0: [3],
  1: [2],
  2: [1, 3, 4],
  3: [0, 2, 4, 5],
  4: [2, 3],
  5: [3],
};

console.log(isBipartite(students1)); // Output: [[0, 1, 4, 5], [2, 3]]
console.log(isBipartite(students2)); // Output: false
