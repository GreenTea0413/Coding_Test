import sys
input = sys.stdin.readline

N, K = map(int, input().split())

MAX = 1000001
count = [0] * (MAX + 1)

for _ in range(N):
    a, b = map(int, input().split())
    count[a] += 1
    count[b] -= 1

for i in range(1, MAX):
    count[i] += count[i - 1]

prefix_sum = [0] * (MAX + 1)
for i in range(1, MAX + 1):
    prefix_sum[i] = prefix_sum[i - 1] + count[i - 1]

left, right = 0, 0

while left < MAX and right < MAX:
    length = prefix_sum[right] - prefix_sum[left]

    if length == K:
        print(left, right)
        exit()
    elif length < K:
        right += 1
    else:
        left += 1

print(0, 0)