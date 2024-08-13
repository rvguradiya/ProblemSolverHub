function towerHanoi(n, a, b, c) {
  if (n == 0) return;
  towerHanoi(n - 1, a, c, b);
  console.log(`Move ${a} to ${b}`);
  towerHanoi(n - 1, c, b, a);
}

let n = 3;
towerHanoi(n, 1, 3, 2);
