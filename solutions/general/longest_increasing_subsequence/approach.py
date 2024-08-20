def length_of_lis(nums):
    if not nums:
        return 0
    
    n = len(nums)
    dp = [1] * n  # Initialize DP array with 1
    
    # Build the DP array
    for i in range(1, n):
        for j in range(i):
            if nums[i] > nums[j]:
                dp[i] = max(dp[i], dp[j] + 1)
    
    # The length of the longest increasing subsequence
    return max(dp)

# Example usage:
nums = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
print(length_of_lis(nums))  # Output: 6
