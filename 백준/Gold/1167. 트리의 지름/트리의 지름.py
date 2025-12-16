# 백준 1167 - 트리의 지름
# https://www.acmicpc.net/problem/1167
# 난이도: 골드 2
# 알고리즘: 트리 DFS/BFS (2번)

import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
graph = {i: [] for i in range(1, N+1)}

# 그래프 입력
for i in range(N):
    nums = list(map(int, input().split()))
    node = nums[0]
    for j in range(1, len(nums) - 1, 2):
        graph[node].append((nums[j], nums[j+1]))

def bfs(start):
    v = set([start])
    q = deque([(start, 0)])
    farthest_node = start
    max_dist = 0

    while q:
        x, d = q.popleft()

        if d > max_dist:
            max_dist = d
            farthest_node = x

        for next_node, weight in graph[x]:
            if next_node not in v:
                v.add(next_node)
                q.append((next_node, d + weight))

    return farthest_node, max_dist


node_a, _ = bfs(1)
node_b, diameter = bfs(node_a)

print(diameter)