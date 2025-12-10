import sys
from collections import Counter
input = sys.stdin.readline

N = int(input())
arr1 = list(map(int, input().split()))

M = int(input())
arr2 = list(map(int, input().split()))

counter = Counter(arr1)

for num in arr2:
    print(counter[num], end=" ")