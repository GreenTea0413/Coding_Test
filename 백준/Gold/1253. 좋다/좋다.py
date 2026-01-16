import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))
A.sort()

answer = 0 
for i in range(N) :
    left, right = 0, N - 1
    target = A[i]

    while left < right :
        if left == i :
            left += 1
            continue
        if right == i :
            right -= 1
            continue
        
        good = A[left] + A[right]

        if good == target :
            answer += 1
            break
        elif good < target :
            left += 1
        else :
            right -= 1

print(answer)

