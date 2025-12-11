import sys
input = sys.stdin.readline

N = int(input())
D = list(map(int, input().split()))
M = list(map(int, input().split()))

answer = D[0] * M[0]
min = M[0]

for i in range(1, N - 1) :
    if M[i] < min :
        answer += D[i] * M[i]
        min = M[i]
    else :
        answer += D[i] * min

print(answer)