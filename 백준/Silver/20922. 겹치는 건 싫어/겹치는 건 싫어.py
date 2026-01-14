import sys
input = sys.stdin.readline

N, K = map(int, input().split())
A = list(map(int,input().split()))

start, end = 0,0
count = [0] * 100001
answer = 0

while end < N :
    count[A[end]] += 1

    while count[A[end]] > K :
        count[A[start]] -= 1
        start += 1
    
    answer = max(answer, end - start + 1)
    end += 1
print(answer)