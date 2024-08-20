function longestIncreasingSubsequence(nums) {
  n = nums.length;
  dp = Array(nums.length);
  max = 0;

  // Build the DP array
  for (let i = 0; i < n; i++) {
    dp[i] = 1;
    for (let j = 0; j < i; j++) {
      if (nums[i] > nums[j]) {
        dp[i] = dp[i] > dp[j] + 1 ? dp[i] : dp[j] + 1;
      }
    }
    max = max > dp[i] ? max : dp[i];
  }

  // The length of the longest increasing subsequence
  return max;
}

// Example usage:
let nums = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15];
console.log(longestIncreasingSubsequence(nums));
