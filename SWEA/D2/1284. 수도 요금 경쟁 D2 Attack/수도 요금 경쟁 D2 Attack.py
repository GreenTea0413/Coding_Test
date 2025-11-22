T = int(input())

for tc in range(1, T+1):
    P, Q, R, S, W = map(int, input().split())
    n1 = P * W
    n2 = Q
    if W >= R :
        n2 += (W - R) * S
    
    print(f"#{tc} {min(n1,n2)}")