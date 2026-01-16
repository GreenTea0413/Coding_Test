from collections import defaultdict

n, d, k, c = map(int, input().split())
sushi = [int(input()) for _ in range(n)]

count = defaultdict(int)
for i in range(k):
    count[sushi[i]] += 1
    
max_variety = len(count)
if c not in count:
    max_variety += 1

for i in range(n):
    remove = sushi[i]
    count[remove] -= 1
    if count[remove] == 0:
        del count[remove]

    add = sushi[(i + k) % n]
    count[add] += 1

    variety = len(count)
    if c not in count:
        variety += 1

    max_variety = max(max_variety, variety)

print(max_variety)