function minTurnSolution(snakes, ladders) {
  let dp = Array(100).fill(Infinity);
  for (let i = -1; i < 100; i++) {
    for (let j = i + 1; j <= i + 6 && j < 100; j++) {
      if (j + 1 in snakes) dp[j] = Infinity;
      else if (j <= 6) dp[j] = 1;
      else {
        dp[j] = Math.min(dp[j], dp[i] + 1);
      }
      if (j + 1 in ladders)
        dp[ladders[j + 1] - 1] = Math.min(dp[ladders[j + 1] - 1], dp[j]);
    }
  }
  return dp[99];
}

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
};
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
};

console.log(minTurnSolution(snakes, ladders));
