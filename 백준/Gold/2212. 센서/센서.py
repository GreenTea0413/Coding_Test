import sys
input = sys.stdin.readline

N, K = int(input()), int(input())
A = list(map(int, input().split()))

if K >= N :
    print(0)
else :
    A.sort()

    dist = []
    for i in range(N - 1) :
        dist.append(A[i+1] - A[i])
    
    dist.sort()
    print(sum(dist[:N-K]))