import sys
input = sys.stdin.readline

N, M = map(int, input().split())
A = list(map(int, input().split()))

left = max(A)
right = sum(A)
answer = 0

while left <= right :  
    mid = (left + right) // 2

    count = 1
    current_sum = 0

    for a in A :
        if current_sum + a > mid :
            count += 1
            current_sum = a
        else :
            current_sum += a
    
    if count <= M :
        answer = mid
        right = mid - 1
    else :
        left = mid + 1
print(answer)

