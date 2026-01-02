# 백준 2217 - 로프
# https://www.acmicpc.net/problem/2217
# 그리디 - 정렬

N = int(input())
W = [int(input()) for _ in range(N)]
W.sort(reverse=True)

answer = 0
for i in range(N) :
    weight = W[i] * (i + 1)
    answer = max(answer, weight)

print(answer)

