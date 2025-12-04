import sys
input = sys.stdin.readline

N = int(input())
arr1 = list(map(int, input().split()))
arr1.sort()

M = int(input())
arr2 = list(map(int, input().split()))

for a2 in arr2 :
    left = 0
    right = N - 1
    find = 0
    while left <= right :
        mid = (left + right) // 2
        if arr1[mid] > a2 :
            right = mid - 1
        elif arr1[mid] < a2 :
            left = mid + 1
        else :
            find = 1
            break
    
    if find == 1 :
        print(1)
    else :
        print(0)
        