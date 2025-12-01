N, L = map(int, input().split())

for length in range(L, 101):
    numerator = N - length * (length - 1) // 2
    
    # 더 이상 불가능 (numerator가 음수가 되면 이후도 다 음수)
    if numerator < 0:
        break
    
    if numerator % length == 0:
        x = numerator // length
        print(' '.join(map(str, range(x, x + length))))
        exit()

print(-1)