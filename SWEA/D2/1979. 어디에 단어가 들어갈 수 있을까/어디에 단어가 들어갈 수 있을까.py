n = int(input())

for i in range(n):
    n1, n2 = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(n1)]
    answer = 0

    # 가로 검사
    for a in arr:
        count = 0
        for c in a:
            if c == 1:
                count += 1
            else:  
                if count == n2:
                    answer += 1
                count = 0
        if count == n2:  # 마지막 칸 체크
            answer += 1

    # 세로 검사
    for x in range(n1):
        count = 0
        for y in range(n1):
            if arr[y][x] == 1:
                count += 1
            else:
                if count == n2:
                    answer += 1
                count = 0
        if count == n2:  # 마지막 칸 체크
            answer += 1

    print(f"#{i+1} {answer}")