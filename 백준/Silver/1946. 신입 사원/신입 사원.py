import sys
input = sys.stdin.readline

T = int(input())

for t in range(T) :
    N = int(input())
    A = [list(map(int, input().split())) for _ in range(N)]
    A.sort()

    min_interview = A[0][1]
    answer = 1

    for i in range(1, N) :
        if A[i][1] < min_interview :
            answer += 1
            min_interview = A[i][1]

    print(answer)
