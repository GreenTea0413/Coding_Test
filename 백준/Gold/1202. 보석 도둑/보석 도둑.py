# 백준 1202 - 보석 도둑
# https://www.acmicpc.net/problem/1202
# 그리디 - 우선순위 큐 심화
import heapq
import sys
input = sys.stdin.readline
N, K = map(int, input().split())

# 보석함
A = []
for _ in range(N) :
    w, v = map(int,input().split())
    A.append((w,v))
# 가방
B = []
for _ in range(K) :
    B.append(int(input()))

A.sort()
B.sort()

hq = []
index = 0
result = 0
for b in B :
    while index < N and A[index][0] <= b :
        w, v = A[index]
        heapq.heappush(hq, -v)
        index += 1
    if hq :
        result += -heapq.heappop(hq) 
print(result)      
