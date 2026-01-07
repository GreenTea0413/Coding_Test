# 백준 2003 - 수들의 합 2
import sys
input = sys.stdin.readline

N,M = map(int, input().split())
A = list(map(int, input().split()))

start, end = 0, 0
current = A[0]
answer = 0

while end < N :
    if current == M :
        answer += 1
        current -= A[start]
        start += 1
    elif current < M :
        end += 1
        if end < N :
            current += A[end]
    elif current > M :
        current -= A[start]
        start += 1
print(answer)