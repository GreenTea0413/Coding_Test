# 백준 1912 - 연속합
# https://www.acmicpc.net/problem/1912
# 난이도: 실버 2
# 알고리즘: DP (1차원 DP)
import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))
dp = [0] * N
dp[0] = A[0]

for i in range(1, N) :
    dp[i] = max(A[i], A[i] + dp[i-1], A[i] + A[i-1])

print(max(dp))
