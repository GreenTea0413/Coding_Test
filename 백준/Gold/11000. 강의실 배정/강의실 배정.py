# 백준 11000 - 강의실 배정
# https://www.acmicpc.net/problem/11000
# 그리디 - 우선순위 큐

import sys
import heapq
input = sys.stdin.readline

N = int(input())
A = []
for _ in range(N) :
    a, b = map(int, input().split())
    A.append((a,b))
A.sort(key= lambda x : x[0])


hq = []
for start, end in A :
    if hq and hq[0] <= start :
        heapq.heappop(hq)
    heapq.heappush(hq, end)

print(len(hq))