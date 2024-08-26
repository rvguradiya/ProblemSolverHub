function generateGrayCode(n, bit = 0, s = "") {
  if (n == 1) {
    console.log(s + bit);
    bit = bit == 1 ? 0 : 1;
    console.log(s + bit);
    return;
  }
  generateGrayCode(n - 1, 0, s + bit);
  bit = bit == 1 ? 0 : 1;
  generateGrayCode(n - 1, 1, s + bit);
}

generateGrayCode(4);
