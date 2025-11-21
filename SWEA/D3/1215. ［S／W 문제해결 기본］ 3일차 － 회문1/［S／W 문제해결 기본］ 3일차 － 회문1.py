for tc in range(1, 11) :
    N = int(input())
    arr = [list(input().strip()) for _ in range(8)]
    answer = 0
    # 0,0 -> 7,7 N  = 4면 0,0 -> 0,3 0,4 -> 0,7
    # 가로
    for x in range(8) :
        for i in range(8 - N + 1) : # 0 1 2 3 4 -> 00 01 02 03
            col = ''
            row = ''
            for y in range(i, N + i) :
                col += arr[y][x]
                row += arr[x][y]
            if row == row[::-1] :
                answer += 1
            if col == col[::-1] :
                answer += 1

    print(f"#{tc} {answer}")