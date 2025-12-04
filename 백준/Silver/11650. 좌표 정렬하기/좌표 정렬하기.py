import sys
input = sys.stdin.readline

N = int(input())

arr = [list(map(int, input().split())) for _ in range(N)]
arr.sort()

for a in arr :
    print(a[0], end=" ")
    print(a[1])