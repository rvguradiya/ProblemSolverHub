function knightProbability(K, N, row, col) {
  let possibleMoves = [
    [2, -1],
    [2, 1],
    [-2, -1],
    [-2, 1],
    [1, 2],
    [1, -2],
    [-1, 2],
    [-1, -2],
  ];

  let visited = [];
  for (let i = 0; i < N; i++) {
    visited.push(Array(N).fill(0));
  }

  function moveProbability(k, n, i, j) {
    if (visited[i][j] == 1) {
      return 0;
    } else if (k == 0) {
      return 1;
    }

    visited[i][j] = 1;
    let probability = 0;
    let countMove = 0;
    for (let knightMove of possibleMoves) {
      let xMove = knightMove[0] + i;
      let yMove = knightMove[1] + j;
      if (0 <= xMove && xMove < N && 0 <= yMove && yMove < N) {
        countMove++;
        // console.log(k, probability, xMove, yMove, visited);
        probability += moveProbability(k - 1, n, xMove, yMove);
      }
    }
    visited[i][j] = 0;
    return countMove ? probability / countMove : probability;
  }
  return moveProbability(K, N, row, col);
}

console.log(knightProbability(7, 3, 0, 0));
