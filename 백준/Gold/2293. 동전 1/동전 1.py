# 백준 2293 - 동전 1
# https://www.acmicpc.net/problem/2293
# DP - 경우의 수 (Unbounded Knapsack)
import sys
input = sys.stdin.readline

n,k = map(int,input().split())

A = [int(input()) for _ in range(n)]
dp = [0] * (k + 1)

dp[0] = 1

for a in A :
    for i in range(a, k + 1) :
        dp[i] += dp[i-a]

print(dp[k])