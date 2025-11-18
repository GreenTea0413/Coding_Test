from collections import Counter

n = int(input())

for i in range(n) :
    n2 = int(input())
    arr = list(map(int,input().split()))
    c = Counter(arr)
    print(f"#{n2} {c.most_common(1)[0][0]}")
               