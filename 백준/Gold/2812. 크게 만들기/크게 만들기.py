# 백준 2812 - 크게 만들기
# https://www.acmicpc.net/problem/2812
# 그리디 - 스택

N, K = map(int, input().split())
num = input()
stack = []
remove = K

for digit in num :
    while stack and remove > 0 and stack[-1] < digit :
        stack.pop()
        remove -=1
    stack.append(digit)

if remove > 0 :
    stack = stack[:-remove]

print(''.join(stack))