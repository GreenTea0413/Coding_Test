import sys
input = sys.stdin.readline

N, M, B = map(int, input().split())
count = [0] * 257  # 각 높이가 몇 개 있는지 저장

for _ in range(N):
    for h in map(int, input().split()):
        count[h] += 1

# 실제 탐색할 최소/최대 높이
min_h = next(i for i in range(257) if count[i] != 0)
max_h = next(i for i in range(256, -1, -1) if count[i] != 0)

result_t = float('inf')
result_h = 0

for target in range(min_h, max_h + 1):
    remove = 0
    add = 0

    for h in range(min_h, max_h + 1):
        if count[h] == 0:
            continue

        diff = h - target
        if diff > 0:
            remove += diff * count[h]
        else:
            add -= diff * count[h]

    if remove + B < add:
        continue

    time = remove * 2 + add

    if time < result_t or (time == result_t and target > result_h):
        result_t = time
        result_h = target

print(result_t, result_h)