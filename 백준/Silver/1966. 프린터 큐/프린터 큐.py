from collections import deque
import sys
input = sys.stdin.readline

K = int(input())

for _ in range(K) :
    N, M = map(int, input().split())

    arr = list(map(int, input().split()))
    index_arr = list(enumerate(arr))
    queue = deque(index_arr)

    count = 0
    while queue :
        idx, pri = queue.popleft()
        count += 1
        # 파이썬에서 하나라도 참인지 확인할 때 사용하는 any()
        if any(pri < q[1] for q in queue):
            queue.append((idx, pri))
            count -= 1
        else:
            if idx == M:
                print(count)
                break