for tc in range(1, 11) :
    N = int(input())
    arr = [list(map(int,input().split())) for _ in range(N)]
    answer = 0
    
    for col in range(N) :
        has_blue = False
        for row in range(N) :
            if arr[row][col] == 1 :
                has_blue = True
            elif arr[row][col] == 2 :
                if has_blue == True :
                    answer += 1
                    has_blue = False
    print(f"#{tc} {answer}")
                    