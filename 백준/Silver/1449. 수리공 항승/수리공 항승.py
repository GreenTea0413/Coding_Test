# 백준 1449 - 수리공 항승
# https://www.acmicpc.net/problem/1449
# 그리디 - 기본
import sys
input = sys.stdin.readline

N, L = map(int, input().split())

# 물이 새는 곳
A = list(map(int, input().split()))
A.sort()

i = 1
m = A[0]
tape = 1

while i < N :
    if A[i] - m < L :
        i += 1
    else :
        m = A[i]
        tape += 1
        i += 1
print(tape)