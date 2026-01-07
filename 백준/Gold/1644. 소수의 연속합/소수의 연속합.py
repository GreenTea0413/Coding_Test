# 백준 1644 - 소수의 연속합
import sys
input = sys.stdin.readline


N = int(input())

is_prime = [True] * (N + 1)
is_prime[0], is_prime[1] = False, False

for i in range(2, int(N ** 0.5) + 1):
    if is_prime[i] :
        for j in range(i * i , N + 1, i) :
            is_prime[j] = False

A = [i for i in range(2, N + 1) if is_prime[i] ]

if not A :
    print(0)
else :
    start, end = 0, 0
    answer = 0     
    total = A[0]
    # 2 3 5 7 11 13 -> 11 13 17
    while end < len(A) :
        if total == N :
            answer += 1
            total -= A[start]
            start += 1

        elif total < N :
            end += 1
            if end >= len(A) :
                break
            total += A[end]
            
        elif total > N :
            total -= A[start]
            start += 1

        if start > end:
            end = start
            if end >= len(A):
                break
            total = A[end]

    print(answer)