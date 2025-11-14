def solution(tickets):
    from collections import defaultdict
    
    graph = defaultdict(list)
    for a, b in tickets:
        graph[a].append(b)
    
    # 목적지 사전순 정렬
    for key in graph:
        graph[key].sort()
    
    path = ["ICN"]
    used_count = 0
    total = len(tickets)
    
    def dfs(now):
        nonlocal used_count
        if used_count == total:
            return True
        
        for i in range(len(graph[now])):
            nxt = graph[now][i]
            if nxt == None:
                continue
            
            graph[now][i] = None  # 티켓 사용
            used_count += 1
            path.append(nxt)
            
            if dfs(nxt):
                return True
            
            # 백트래킹
            graph[now][i] = nxt
            used_count -= 1
            path.pop()
        
        return False
    
    dfs("ICN")
    return path