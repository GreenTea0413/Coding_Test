import sys
input = sys.stdin.readline

N = int(input())

A = [list(map(int, input().split())) for _ in range(N)]
A = sorted(A, key=lambda x : (x[1], x[0]))

end = A[0][1]
count = 1

for s, e in A[1:] :
    if end <= s :
        end = e
        count += 1
        
print(count)