# 백준 11047 - 동전 0
# https://www.acmicpc.net/problem/11047
# 그리디 - 입문

import sys
input = sys.stdin.readline

N, K = map(int, input().split())
A = [int(input()) for _ in range(N)]

answer = 0

while K > 0 :
    for i in range(N-1, -1, -1) :
        if K // A[i] >= 1:
            answer += K // A[i]
            K = K % A[i]
print(answer)