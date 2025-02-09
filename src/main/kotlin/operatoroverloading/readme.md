# Operator Overloading

### Binary arithmetic operators:

1. times:       a * b
2. div:         a / b
3. rem:         a % b
4. plus:        a + b
5. minus:       a - b
6. rangeTo:     a..b
7. rangeUntil:  a..<b

### Unary arithmetic operators:

1. unaryPlus:   +a
2. unaryMinus:  -a
3. not:         !a
4. inc:         a++
5. dec:         a--

### Invoke:       
1. invoke:        a()
2. invoke(i):     a(i)
3. invoke(i, j):  a(i, j)
4. invoke(...):   a(...)

### Get:
1. get:            a[i]
2. get(i, j):      a[i, j]
3. get(...):       a[...]

### Set:
1. set(i, x):      a[i] = x
2. set(i, j, x):   a[i, j] = x
3. set(..., x):    a[...] = x

### In
1. contains(a):     a in b
2. !b.contains(a):  a !in b

#### Others
- plusAssign
- minusAssign
- timesAssign
- divAssign
- remAssign
- equals
- compareTo
- etc