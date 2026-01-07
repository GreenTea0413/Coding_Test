# 백준 2470 - 두 용액
import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))
A.sort()

start = 0
end = N - 1
result = float('inf')
answer = []
# -99 -2 -1 4 98
while start < end :
    
    total = A[start] + A[end]
    
    # 절대값 비교해서 0이랑 가까우면
    if abs(result) > abs(total) :
        result = total
        answer = [A[start], A[end]]
    
    if total < 0:
        start += 1
    elif total > 0:
        end -= 1
    else :
        break

print(answer[0], answer[1])