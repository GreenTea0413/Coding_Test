from collections import defaultdict
import heapq
import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    n = int(input())
    max_heap = []
    min_heap = []
    count = defaultdict(int)

    for _ in range(n):
        op, number = input().split()
        num = int(number)

        if op == 'I':
            heapq.heappush(max_heap, -num)
            heapq.heappush(min_heap, num)
            count[num] += 1

        else:
            if num == -1:  # 최솟값 삭제
                while min_heap and count[min_heap[0]] == 0:
                    heapq.heappop(min_heap)
                if min_heap:
                    val = heapq.heappop(min_heap)
                    count[val] -= 1

            elif num == 1:  # 최댓값 삭제
                while max_heap and count[-max_heap[0]] == 0:
                    heapq.heappop(max_heap)
                if max_heap:
                    val = -heapq.heappop(max_heap)
                    count[val] -= 1

    while min_heap and count[min_heap[0]] == 0:
        heapq.heappop(min_heap)
    while max_heap and count[-max_heap[0]] == 0:
        heapq.heappop(max_heap)

    if min_heap and max_heap:
        print(-max_heap[0], min_heap[0])
    else:
        print("EMPTY")