import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
s = input().strip()
answer = 0
count = 0
i = 0

while i < m - 2 :
    if s[i : i + 3] == 'IOI' :
        count += 1
    
        if count >= n :
            answer += 1
        i += 2
        
    else :
        i += 1
        count = 0


print(answer)