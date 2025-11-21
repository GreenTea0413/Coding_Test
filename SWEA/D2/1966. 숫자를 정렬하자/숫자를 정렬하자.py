test = int(input())

for tc in range(1, test+1) :
    N = int(input())
    arr = list(map(int, input().split()))
    arr.sort()
    print(f"#{tc}", end = " ")
    for a in arr :
        print(a, end = " ")
    print()