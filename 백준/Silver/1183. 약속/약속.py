N = int(input())
arr = []

for i in range(N):
    a, b = map(int, input().split())
    arr.append(a - b)

arr.sort()

if N % 2 == 1:
    # 홀수: 중앙값 1개만
    print(1)
else:
    # 짝수: 두 중간값 사이의 모든 정수
    mid1 = arr[N // 2 - 1]
    mid2 = arr[N // 2]
    print(mid2 - mid1 + 1)