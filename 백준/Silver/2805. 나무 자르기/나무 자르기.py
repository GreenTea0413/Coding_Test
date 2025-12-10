import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int,input().split()))

left = 0
right = max(arr)
answer = 0

while left <= right :
    mid = (left + right) // 2
    total = sum(a - mid for a in arr if a > mid)
    if total == M :
        answer = mid
        break
    elif total > M :
        answer = mid
        left = mid + 1
    else :
        right = mid - 1

print(answer)