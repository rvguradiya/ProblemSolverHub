from collections import deque

def is_bipartite(students):
    # Number of students is the number of keys in the students dictionary
    n = len(students)
    
    # Colors array to store team assignment (0 for uncolored, 1 for team A, -1 for team B)
    color = [0] * n
    
    # Perform BFS for each uncolored student
    for student in range(n):
        if color[student] == 0:  # If the student is not yet colored
            queue = deque([student])
            color[student] = 1  # Assign the student to team 1
            
            # BFS traversal
            while queue:
                curr_student = queue.popleft()
                
                # Traverse all the enemies of the current student
                for enemy in students[curr_student]:
                    if color[enemy] == 0:  # If the enemy is not colored
                        # Assign the enemy the opposite team
                        color[enemy] = -color[curr_student]
                        queue.append(enemy)
                    elif color[enemy] == color[curr_student]:  # Conflict found
                        return False
    
    # Separate students into two teams based on their color
    team1 = [i for i in range(n) if color[i] == 1]
    team2 = [i for i in range(n) if color[i] == -1]
    
    return (team1, team2)

# Example usage:

# Example 1: Should return two teams
students1 = {
    0: [3],
    1: [2],
    2: [1, 4],
    3: [0, 4, 5],
    4: [2, 3],
    5: [3]
}

# Example 2: Should return False
students2 = {
    0: [3],
    1: [2],
    2: [1, 3, 4],
    3: [0, 2, 4, 5],
    4: [2, 3],
    5: [3]
}

print(is_bipartite(students1))  # Output: ([0, 1, 4, 5], [2, 3])
print(is_bipartite(students2))  # Output: False
