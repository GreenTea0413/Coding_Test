from collections import Counter

N = int(input())
A = [input() for _ in range(N)]

c = Counter(A)

answer = sorted(c.items(), key=lambda x: (-x[1], x[0]))
print(answer[0][0])
