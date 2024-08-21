def min_turn_solution(snakes, ladders):
    dp = [float('inf')] * 100
    
    for i in range(-1, 100):
        for j in range(i + 1, min(i + 7, 100)):
            if (j + 1) in snakes:
                dp[j] = float('inf')  # Skip the snake square
            elif j <= 6:
                dp[j] = 1  # Early game, first few squares can be reached in 1 turn
            else:
                dp[j] = min(dp[j], dp[i] + 1)  # Normal dice roll progression
            
            # Handle ladder jumps
            if (j + 1) in ladders:
                dp[ladders[j + 1] - 1] = min(dp[ladders[j + 1] - 1], dp[j])
    
    return dp[99]

# Snakes and Ladders configuration
snakes = {
    16: 6,
    48: 26,
    49: 11,
    56: 53,
    62: 19,
    64: 60,
    87: 24,
    93: 73,
    95: 75,
    98: 78,
}

ladders = {
    1: 38,
    4: 14,
    9: 31,
    21: 42,
    28: 84,
    36: 44,
    51: 67,
    71: 91,
    80: 100,
}

# Output the result
print(min_turn_solution(snakes, ladders))  # Expected Output: 7
