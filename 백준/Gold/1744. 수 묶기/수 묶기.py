# 백준 1744 - 수 묶기
# https://www.acmicpc.net/problem/1744
# 그리디 - 경우의 수 나누기

N = int(input())

plus = []
minus = []
zero = False
answer = 0

for _ in range(N) :
    num = int(input())
    if num > 1 :
        plus.append(num)
    elif num == 1 :
        answer += 1
    elif num < 0 :
        minus.append(num)
    else :
        zero = True

plus.sort(reverse=True)
minus.sort()

for i in range(0, len(plus), 2) :
    if i + 1 < len(plus) :
        answer += plus[i] * plus[i + 1]
    else :
        answer += plus[i]

for j in range(0, len(minus), 2) :
    if j + 1 < len(minus) :
        answer += minus[j] * minus[j+1]
    else :
        if zero == False : answer += minus[j]


print(answer)