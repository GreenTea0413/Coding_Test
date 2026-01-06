# 백준 2805 - 나무 자르기
# https://www.acmicpc.net/problem/2805
# 이분탐색 - 파라메트릭 서치

import sys
input = sys.stdin.readline

N, M = map(int, input().split())
A = list(map(int, input().split()))
A.sort()

left = 0
right = A[-1]
answer = 0

while left <= right :
    mid = (left + right) // 2
    num = sum(a - mid for a in A if a > mid)

    if num == M :
        answer = mid
        break
    
    elif num > M :
        answer = mid
        left = mid + 1
    
    else :
        right = mid - 1
print(answer)
