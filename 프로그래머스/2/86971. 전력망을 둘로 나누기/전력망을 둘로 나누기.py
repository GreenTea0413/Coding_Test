def dfs(visited, graph, start) :
    visited[start] = True
    count = 1
    for i in graph[start]:
        if visited[i] == False :
            count += dfs(visited, graph, i)
            
    return count

def solution(n, wires):
    answer = n + 1
    graph = {}
    for a, b in wires :
        if a not in graph :
            graph[a] = []
        if b not in graph :
            graph[b] = []
        graph[a].append(b)
        graph[b].append(a)
        
    for a, b in wires :
        visited = [False] * (n + 1)
        
        graph[a].remove(b)
        graph[b].remove(a)
        
        size1 = dfs(visited, graph, a)
        size2 = n - size1
        answer = min(answer, abs(size1-size2))
        
        graph[a].append(b)
        graph[b].append(a)
        
    return answer