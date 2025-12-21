import heapq
import sys
input = sys.stdin.readline
A = []
N = int(input())

# 데드라인, 컵라면 수
for _ in range(N) :
    A.append(list(map(int, input().split())))
A.sort()

heap = []
# answer에는 각 데드라인마다 최대 컵라면 갯수 넣기
for deadline, noodle in A :
    heapq.heappush(heap, noodle)

    if len(heap) > deadline :
        heapq.heappop(heap)
    
print(sum(heap))
    