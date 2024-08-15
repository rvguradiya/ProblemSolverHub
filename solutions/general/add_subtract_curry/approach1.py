def add_subtract(n):
    acc = n
    op = True
    def inner(m=None):
        nonlocal acc
        nonlocal op
        if m is None:
            return acc
        if op:
            acc += m
        else:
            acc -= m
        op = not op
        return inner
    return inner

# Examples
print(add_subtract(7)())          # Output: 7
print(add_subtract(1)(2)(3)())    # Output: 0
print(add_subtract(-5)(10)(3)(9)()) # Output: 11
