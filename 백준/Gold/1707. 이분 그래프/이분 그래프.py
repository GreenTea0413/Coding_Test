import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

test = int(input())

def dfs(start, c) :
    color[start] = c
    
    for next in graph[start] :
        if color[next] == 0 :
            if not dfs(next, - c) :
                return False
        elif color[next] == c :
            return False
    return True

for t in range(test):
    v, e = map(int, input().split())
    graph = {i : [] for i in range(1, v + 1)}
    for _ in range(e) :
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    # 이웃하는거랑 색이 달라야함
    color = [0] * (v + 1)
    check = True
    for x in range(1, v + 1) :
        if color[x] == 0 :
            if not dfs(x, 1) :
                check = False
                break
    if check :                
        print('YES')
    else :
        print('NO')

