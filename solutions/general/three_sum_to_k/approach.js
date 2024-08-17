let arr = [20, 303, 3, 4, 25];

function isArrayHaveSumOfK(k, sum, arr) {
  arr = arr;
  n = arr.length;
  function isArrayHaveSum(n, k, sum, i = 0) {
    if (sum == 0) {
      return true;
    } else if (i == n || k == 0 || sum < 0) {
      return false;
    }
    // console.log(k, sum, arr[i]);
    if (isArrayHaveSum(n, k - 1, sum - arr[i], i + 1) == true) {
      return true;
    } else {
      return isArrayHaveSum(n, k, sum, i + 1);
    }
  }
  return isArrayHaveSum(n, k, sum, 0);
}

console.log(isArrayHaveSumOfK(3, 49, arr));
