n = int(input())

for i in range(n):
    n2 = int(input())
    arr = [[0] * n2 for _ in range(n2)]
    
    d = [[0,1], [1,0], [0,-1], [-1,0]]
    print(f"#{i + 1}")
    
    x, y, z = 0, 0, 0
    
    for j in range(1, n2 * n2 + 1):
        arr[x][y] = j
        
        nx = x + d[z][0]
        ny = y + d[z][1]
        
        # 방향 전환 조건
        if nx < 0 or nx >= n2 or ny < 0 or ny >= n2 or arr[nx][ny] != 0:
            z = (z + 1) % 4
            nx = x + d[z][0]
            ny = y + d[z][1]
        
        x, y = nx, ny

    # 출력
    for k in range(n2):
        for l in range(n2):
            print(arr[k][l], end=' ')
        print()