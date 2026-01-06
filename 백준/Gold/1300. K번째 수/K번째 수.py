# 백준 1300 - K번째 수
# https://www.acmicpc.net/problem/1300
# 이분탐색 - 심화

import sys
input = sys.stdin.readline

N = int(input())
K = int(input())

left = 1
right = K
answer = 0

while left <= right :
    mid = (left + right) // 2

    count = 0
    for i in range(1, N + 1) :
        count += min(mid // i, N)
    
    if count >= K :
        answer = mid
        right = mid - 1
    else : 
        left = mid + 1

print(answer)