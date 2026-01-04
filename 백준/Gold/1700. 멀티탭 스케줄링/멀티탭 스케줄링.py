import sys
input = sys.stdin.readline

N, K = map(int, input().split())
A = list(map(int, input().split()))

use = []
answer = 0

for i in range(K):
    # 이미 꽂혀 있으면 패스
    if A[i] in use:
        continue

    # 빈 자리 있으면 꽂기
    if len(use) < N:
        use.append(A[i])
        continue

    # 뽑아야 하는 상황
    next_use = []

    for u in use:
        if u in A[i+1:]:
            next_use.append(A[i+1:].index(u))
        else:
            next_use.append(float('inf'))  # 다시 안 쓰임

    # 가장 나중에 쓰이거나 안 쓰이는 것 제거
    idx = next_use.index(max(next_use))
    use[idx] = A[i]
    answer += 1

print(answer)