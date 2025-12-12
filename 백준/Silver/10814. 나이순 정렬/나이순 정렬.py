import sys
input = sys.stdin.readline

N = int(input())
A = [list(input().split()) for _ in range(N)]
A = sorted(A, key=lambda x : int(x[0]))

for a, b in A :
    print(a, b)