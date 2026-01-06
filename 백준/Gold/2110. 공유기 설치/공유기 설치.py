# 백준 2110 - 공유기 설치
# https://www.acmicpc.net/problem/2110
# 이분탐색 - 파라메트릭 서치 응용

import sys
input = sys.stdin.readline

N, C = map(int, input().split())
A = [int(input()) for _ in range(N)]
A.sort()

left = 0
right = A[-1] - A[0]
answer = 0

while left <= right :
    mid = (left + right) // 2

    last = A[0]
    count = 1

    for a in A :
        if a - last >= mid :
            count += 1
            last = a

    if count >= C :
        answer = mid
        left = mid + 1   
    
    else :
        right = mid - 1

print(answer)

