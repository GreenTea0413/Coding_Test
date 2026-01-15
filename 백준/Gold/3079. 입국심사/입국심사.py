import sys
input = sys.stdin.readline

N, M = map(int, input().split())
times = [int(input()) for _ in range(N)]

left = 1
right = M * max(times)
answer = 0

while left <= right :
    mid = (left +right) // 2

    count = 0
    for time in times :
        count += mid // time
    
    if count >= M :
        answer = mid
        right = mid - 1
    else :
        left = mid + 1

print(answer)