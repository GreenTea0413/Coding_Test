# 백준 11501 - 주식
# https://www.acmicpc.net/problem/11501
# 그리디 - 역방향 탐색

T = int(input())
for t in range(T) :
    N = int(input())
    A = list(map(int,input().split()))

    profit = 0
    max_price = 0

    for i in range(N-1, -1, -1) :
        if A[i] > max_price :
            max_price = A[i]
        else :
            profit += max_price - A[i]
    print(profit)