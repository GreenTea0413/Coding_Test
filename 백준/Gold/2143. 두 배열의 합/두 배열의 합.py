from collections import Counter
T = int(input())

n = int(input())
a = list(map(int, input().split()))

m = int(input())
b = list(map(int, input().split()))


sub_a = []
for i in range(n):
    sum_val = 0
    for j in range(i, n):
        sum_val += a[j]
        sub_a.append(sum_val)

sub_b = []
for i in range(m):
    sum_val = 0
    for j in range(i, m):
        sum_val += b[j]
        sub_b.append(sum_val)

sub_a.sort()
sub_b.sort(reverse=True)
answer = 0
left, right = 0,0

while left < len(sub_a) and right < len(sub_b) :
    cur = sub_a[left] + sub_b[right]

    if cur == T :
        count_a = 1
        count_b = 1

        while left + 1 < len(sub_a) and sub_a[left] == sub_a[left + 1] :
            count_a += 1
            left += 1
        while right + 1 < len(sub_b) and sub_b[right] == sub_b[right + 1] :
            count_b += 1
            right += 1
        
        answer += count_a * count_b
        left += 1
        right += 1
    elif cur < T :
        left += 1
    else :
        right += 1
print(answer)

