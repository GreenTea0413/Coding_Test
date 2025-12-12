import sys
import heapq
input = sys.stdin.readline

N = int(input())
A = [list(map(int, input().split())) for _ in range(N)]
A = sorted(A, key=lambda x : x[0])
heap = []
heapq.heappush(heap, A[0][1])
# 일단 순서대로 넣어야함
# 1,3 2,4 -> 1,3 끝나고 내보낸다음 3,5를 넣으면 되는데
for s, e in A[1:] :
    if heap[0] <= s :
        heapq.heappop(heap)
    heapq.heappush(heap, e)
print(len(heap))
