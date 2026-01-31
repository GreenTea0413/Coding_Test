import sys
input = sys.stdin.readline

p = 'I'
n = int(input())

for i in range(n) :
    p += 'OI'

m = int(input())
s = input()
answer = 0

for i in range(m - (2 * n + 1) + 1) :
    if s[i : i + (2 * n + 1)] == p :
        answer += 1

print(answer)