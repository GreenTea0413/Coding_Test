# 백준 1806 - 부분합
import sys
input = sys.stdin.readline

N, S = map(int, input().split())
A = list(map(int, input().split()))

# 5 1 3 5 10 7 4 9 2 8
# 5 1 3 5 10 3 4 9 2 8
INF = float('inf')
answer = INF
start, end = 0, 0
total = 0

while end < N :
    total += A[end]
    # S를 넘기거나 같아지면 answer에 값 비교 후 등록
    # start를 어떻게 할거냐..
    while total >= S :
        answer = min(answer, end - start + 1)
        total -= A[start]
        start += 1
    end += 1
if answer == INF :
    print(0)
else : 
    print(answer)