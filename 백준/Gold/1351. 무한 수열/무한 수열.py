#1351
N, P, Q = map(int, input().split())

# A0 = 1
# Ai = A⌊i/P⌋ + A⌊i/Q⌋ (i ≥ 1)

memo = {}
memo[0] = 1

def check(n) :
    if n in memo :
        return memo[n]

    memo[n] = check(n // P) + check(n // Q)
    return memo[n]

check(N)
print(memo[N])