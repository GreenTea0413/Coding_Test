import sys
input = sys.stdin.readline

N = int(input())
A = [list(map(int, input().split())) for _ in range(N)]
A.sort()

answer = 0

start, end = A[0][0], A[0][1]

for i in range(1, N) :
    if end < A[i][0] :
        answer += end - start
        start = A[i][0]
        end = A[i][1]

    elif end >= A[i][0] :
        end = max(end, A[i][1])

answer += end - start
print(answer)

