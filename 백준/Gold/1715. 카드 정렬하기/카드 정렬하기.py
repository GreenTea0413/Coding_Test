import sys
import heapq
input = sys.stdin.readline

N = int(input())
hq = []

for _ in range(N) : 
    num = int(input())
    heapq.heappush(hq, (num))

answer = 0
while len(hq) > 1 : 
    card1, card2 = heapq.heappop(hq), heapq.heappop(hq)

    answer += card1 + card2
    heapq.heappush(hq, card1 + card2)
    
print(answer)
