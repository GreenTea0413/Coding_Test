test = int(input())

for tc in range(1, test + 1 ) :
    N = int(input())
    arr = [list(map(int, input())) for _ in range(N)]
    
    answer = 0
    mid = int(N // 2)
    dy = [1,-1]
    # N // 2 -> 5 // 2 = 2,0
    # 윗부분 + 중간부분 + 아랫부분
    # 윗부분
    for i in range(mid) :
        answer += arr[i][mid]
        for j in range(1, i + 1) :
            for y in dy :
                ny = y * j + mid
                answer += arr[i][ny]
    # 중간
    for i in range(N) :
        answer += arr[mid][i]
    # 아랫 부분 4, 3
    for i in range(N - 1, mid, -1) :
        answer += arr[i][mid]
        for j in range(1, N - i) :
            for y in dy :
                ny = y * j + mid
                answer += arr[i][ny]
    print(f"#{tc} {answer}")   