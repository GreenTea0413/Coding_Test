import sys
input = sys.stdin.readline

A = list(map(str, input().strip().split('-')))

answer = 0
N = A[0].split('+')
for n in N :
    answer += int(n)

for i in range(1, len(A)) :
    nums = A[i].split('+')
    for num in nums :
        answer -= int(num)

print(answer)
