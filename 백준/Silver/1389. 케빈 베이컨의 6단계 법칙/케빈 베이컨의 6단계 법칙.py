# 백준 1389 - 케빈 베이컨의 6단계 법칙
# https://www.acmicpc.net/problem/1389
# 난이도: 실버 1
# 알고리즘: BFS (모든 쌍 최단경로)
from collections import deque
from collections import Counter
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
graph = {i : set() for i in range(1, N + 1)}

for i in range(M) :
    a,b = map(int, input().split())
    graph[a].add(b)
    graph[b].add(a)


answer = [0] * (N + 1)
for j in range(1, N+1) :
    for k in range(1, N+1) :
        if j != k :
            q = deque([(j,0)])
            visited = set([j])  
            while q :
                now, d = q.popleft()
                if now == k :
                    answer[j] += d
                    break
                for next in graph[now] :
                    if next not in visited:  
                        visited.add(next)
                        q.append((next,d+1))

a = answer.index(min(answer[1:]))
print(a)
    


