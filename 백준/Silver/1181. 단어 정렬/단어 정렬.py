import sys
input = sys.stdin.readline

N = int(input())
arr = set()

for _ in range(N) :
    arr.add(input().strip())

arr = sorted(arr, key=lambda x : (len(x), x))

for a in arr :
    print(a)