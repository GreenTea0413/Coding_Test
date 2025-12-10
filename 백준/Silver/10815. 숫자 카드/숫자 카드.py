import sys
input = sys.stdin.readline

N = int(input())
arr1 = list(map(int, input().split()))

M = int(input())
arr2 = list(map(int, input().split()))

arr1.sort()

for num in arr2 :
    left, right = 0, N - 1
    check = False
    while left <= right :
        mid = (left + right) // 2
        if arr1[mid] == num :
            check = True
            break
        elif arr1[mid] > num : 
            right = mid - 1
        else :
            left = mid + 1
    if check :
        print(1, end=" ")
    else :
        print(0, end=" ")