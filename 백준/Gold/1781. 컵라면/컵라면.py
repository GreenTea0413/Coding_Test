import heapq
import sys
input = sys.stdin.readline

# 컵라면
N = int(input())
problems = [list(map(int, input().split())) for _ in range(N)]

problems.sort()

hq = []

for dead, cup in problems :
    heapq.heappush(hq,cup)

    if len(hq) > dead :
        heapq.heappop(hq)
    
print(sum(hq))