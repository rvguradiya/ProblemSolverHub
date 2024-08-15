function add_subtract(n) {
  let acc = n;
  let op = true;

  return function inner(m) {
    if (!m) {
      return acc;
    }
    acc += op ? m : -m;
    op = !op;
    return inner;
  };
}

console.log(add_subtract(7)()); // Output: 7
console.log(add_subtract(1)(2)(3)()); // Output: 0
console.log(add_subtract(-5)(10)(3)(9)()); // Output: 11
