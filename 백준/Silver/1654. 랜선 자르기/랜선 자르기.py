import sys
input = sys.stdin.readline

N, M = map(int, input().split())

A = [int(input()) for _ in range(N)]
right = max(A)
left = 1  
answer = 0

while left <= right :
    mid = (left + right) // 2
    s = 0

    for a in A :
        s += a // mid
    
    if s < M :
        right = mid - 1
    else :
        answer = mid        
        left = mid + 1

print(answer)
