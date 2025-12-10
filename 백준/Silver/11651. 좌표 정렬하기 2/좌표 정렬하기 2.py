import sys
input = sys.stdin.readline

N = int(input())
arr = []
for _ in range(N) :
    a, b = map(int,input().split())
    arr.append([b,a])

arr.sort()
for a, b in arr :
    print(b, a)