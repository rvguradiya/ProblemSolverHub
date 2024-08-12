// node.js to run the program

// Prompt the user for input
process.stdout.write("Enter a number: ");

// Handle the input
process.stdin.once("data", (data) => {
  // Convert the input to a number
  const num = parseInt(data.toString().trim(), 10);

  // Check if the input is a valid number
  if (isNaN(num)) {
    console.log("Please enter a valid number.");
  } else {
    // Call your palindrome function here
    const isPalindrome = checkPalindrome(num);
    console.log(`Is ${num} a palindrome? ${isPalindrome}`);
  }

  // Exit the process
  process.exit();
});

// check palindrome number
function checkPalindrome(num) {
  // Handle negative numbers and zero separately
  if (num < 0) return false;
  if (num === 0) return true;

  let x = 0;

  // reverse number at half of number
  while (num > x) {
    x = x * 10 + (num % 10);
    num = Math.floor(num / 10);
  }

  // compare first half and second half of number
  return num == x || (x > num && x / 10 == num) ? true : false;
}
