# 백준 13164 - 행복 유치원
# https://www.acmicpc.net/problem/13164
# 그리디 - 차이값 활용

N, K = map(int, input().split())
A = list(map(int, input().split()))
arr = []
for i in range(N - 1) :
    arr.append(A[i + 1] - A[i])

# 조 내부의 최대 최소 차이만큼
arr.sort()
print(sum(arr[:N-K]))
