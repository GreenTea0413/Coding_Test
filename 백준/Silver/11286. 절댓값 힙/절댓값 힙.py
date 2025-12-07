import sys
import heapq
input = sys.stdin.readline

N = int(input())
heap = []

for _ in range(N):
    x = int(input().strip())

    if x == 0:
        if len(heap) == 0:
            print(0)
        else:
            # heappop으로 최솟값 추출 (절댓값, 실제값) 튜플
            abs_val, real_val = heapq.heappop(heap)
            print(real_val)
    else:
        # (절댓값, 실제값) 형태로 저장
        heapq.heappush(heap, (abs(x), x))
