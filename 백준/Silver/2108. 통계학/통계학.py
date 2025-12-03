from collections import Counter
import sys
input = sys.stdin.readline

N = int(input())

arr = []
for _ in range(N):
    arr.append(int(input()))

print(round(sum(arr)/N))
arr.sort()
print(arr[N//2])
c = Counter(arr)
most = c.most_common()
if len(most) > 1 and most[0][1] == most[1][1] :
    print(most[1][0])
else :
    print(most[0][0])
print(arr[N-1] - arr[0])
