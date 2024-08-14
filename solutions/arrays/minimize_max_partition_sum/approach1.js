function minimizeMaxPartitionSum(N, k) {
  let left = Array.max(N);
  let right = Array.sum(N);

  while (left < right) {
    let mid = left + Math.floor((right - left) / 2);
    if (canPartition(N, k, mid)) {
      right = mid;
    } else {
      left = mid + 1;
    }
  }

  return left;
}

function canPartition(N, k, maxSum) {
  let currentSum = 0;
  let requiredPartitions = 1;

  for (let num of N) {
    if (currentSum + num > maxSum) {
      requiredPartitions++;
      currentSum = num;
      if (requiredPartitions > k) {
        return false;
      }
    } else {
      currentSum += num;
    }
  }

  return true;
}

let N = [5, 1, 2, 7, 3, 4];
let k = 3;
console.log(minimizeMaxPartitionSum(N, k));
