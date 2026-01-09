import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))
A.sort()
count = float('inf')
a, b, c = 0,0,0

for i in range(N - 2) :
    left, right = i + 1, N - 1
    Ai = A[i]
    while left < right :
        cur = Ai + A[left] + A[right]

        if cur == 0 : 
            print(Ai, A[left], A[right])
            exit()
        else :
            if abs(cur) < count :
                count = abs(cur)
                a,b,c = A[i], A[left], A[right]
            if cur < 0 :
                left += 1
            else :
                right -= 1

    if count == 0 :
        break

print(a,b,c)
