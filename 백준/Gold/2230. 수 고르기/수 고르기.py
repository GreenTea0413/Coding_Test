import sys
input = sys.stdin.readline

N, M = map(int, input().split())
A = [int(input()) for _ in range(N)]
A.sort()

answer = float('inf')
start, end = 0, 1

while end < N :
    num = A[end] - A[start]

    if num >= M :
        answer = min(num, answer)
        start += 1
    else :
        end += 1

    if start == end :
        end += 1

print(answer)