import sys
input = sys.stdin.readline

N = int(input())
dist = [int(input()) for _ in range(N)]

start, end = 0, 0
total = sum(dist)
answer = 0
cur_circle = 0

while start < N :
    if cur_circle * 2 < total :
        cur_circle += dist[end]
        end = (end + 1) % N
    else :
        answer = max(answer, min(total - cur_circle, cur_circle))
        cur_circle -= dist[start]
        start += 1

print(answer)