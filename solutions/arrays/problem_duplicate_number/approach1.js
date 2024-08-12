let arr = [1, 2, 3, 3, 4];

// time and space complexity is O(n)
function findDuplicate(arr) {
  let tempArr = Array(arr.length - 1).fill(0);
  let duplicateValue = 0;

  for (const elem of arr) {
    if (tempArr[elem - 1] == 0) tempArr[elem - 1] = elem;
    else {
      duplicateValue = elem;
      break;
    }
  }
  return duplicateValue;
}

console.log(findDuplicate(arr));
