n = int(input())

for i in range(1, n + 1) :
    n1, n2 = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(n1)]
    m = 0
    for j in range(n1 - n2 + 1) :
        for k in range(n1 - n2 + 1) :
            now = 0
			# 좌표를 0,0 부터 n1 - n2까지 하겠다는거임 0,0 -> 3,3
            # 0,0 0,1 1,0 1,1
            for o in range(n2) : 
                for p in range(n2) :
                    now += arr[j + o][k + p]
            m = max(now, m)
    print(f"#{i} {m}")