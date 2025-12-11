import sys
input = sys.stdin.readline

s = input().split('-')

answer = 0
first = s[0].split('+')
for f in first :
    answer += int(f)

for i in range(1, len(s)) :
    part = s[i].split('+')
    for p in part :
        answer -= int(p)

print(answer)
