import sys
from collections import deque
input = sys.stdin.readline

arr = [0] * 9
for i in range(9) :
    arr[i] = int(input())

arr.sort()
visited = [0] * 9
path = []

def dfs(path, v) :
    if len(path) == 7 :
        if sum(path) == 100 :
            path.sort()
            for i in range(7) :
                print(path[i])
            exit()

    for j in range(9) :
        if v[j] != 1 :
            path.append(arr[j])
            v[j] = 1

            dfs(path, v)

            path.remove(arr[j])
            v[j] = 0


dfs(path, visited)