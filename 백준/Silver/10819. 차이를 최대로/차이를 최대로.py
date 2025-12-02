import sys
input = sys.stdin.readline

N = int(input())

arr = list(map(int, input().split()))
visited = [False] * N
temp = [0] * N
answer = 0

def backtrack(depth) :
    global answer

    if depth == N :
        total = 0
        for i in range(N - 1) :
            total += abs(temp[i] - temp[i + 1])
        answer = max(answer,total)
        return
    
    for i in range(N) :
        if not visited[i] :
            visited[i] = True
            temp[depth] = arr[i]
            backtrack(depth + 1)
            visited[i] = False

backtrack(0)
print(answer)