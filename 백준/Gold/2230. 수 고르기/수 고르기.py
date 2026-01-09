import sys
input = sys.stdin.readline
N, M = map(int, input().split())

A = [int(input()) for _ in range(N)]
A.sort()

answer = float('inf')
start, end = 0, 1

while end < N :
    cur = A[end] - A[start]

    if cur >= M :
        answer = min(answer, cur)
        start += 1
    
    else : 
        end += 1
    
    if start == end :
        end += 1

print(answer)