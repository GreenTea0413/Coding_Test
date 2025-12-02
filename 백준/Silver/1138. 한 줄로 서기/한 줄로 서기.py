N = int(input())
arr = list(map(int, input().split()))
result = []

for i in range(N, 0, -1) :
    result.insert(arr[i- 1], i)

print(' '.join(map(str, result)))