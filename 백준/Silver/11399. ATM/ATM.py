import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))

A.sort()
answer = 0

for i in range(1, N + 1) :
    answer += sum(A[:i])

print(answer)
