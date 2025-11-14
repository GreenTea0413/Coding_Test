from collections import deque

def solution(rectangle, characterX, characterY, itemX, itemY):
    # 좌표 2배 확장
    board = [[0] * 102 for _ in range(102)]
    
    # 1. 사각형 경계 그리기
    for x1, y1, x2, y2 in rectangle:
        x1 *= 2; y1 *= 2; x2 *= 2; y2 *= 2
        
        for x in range(x1, x2 + 1):
            for y in range(y1, y2 + 1):
                board[x][y] = 1
    
    # 2. 내부 지우기
    for x1, y1, x2, y2 in rectangle:
        x1 *= 2; y1 *= 2; x2 *= 2; y2 *= 2
        
        for x in range(x1 + 1, x2):
            for y in range(y1 + 1, y2):
                board[x][y] = 2
    
    # BFS 준비
    q = deque()
    q.append((characterX * 2, characterY * 2, 0))
    visited = [[False] * 102 for _ in range(102)]
    
    # 4방향
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    
    while q:
        x, y, dist = q.popleft()
        
        if x == itemX * 2 and y == itemY * 2:
            return dist // 2
        
        if visited[x][y]:
            continue
        visited[x][y] = True
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0 <= nx < 102 and 0 <= ny < 102:
                if board[nx][ny] == 1 and not visited[nx][ny]:
                    q.append((nx, ny, dist + 1))