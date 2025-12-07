import sys
import heapq
input = sys.stdin.readline

N = int(input())
heap = []
for i in range(N) :
    x = int(input())

    if x == 0 :
        if len(heap) == 0:
            print(0)
        else :
            num = heapq.heappop(heap)
            print(num)
    else :
        heapq.heappush(heap, x)