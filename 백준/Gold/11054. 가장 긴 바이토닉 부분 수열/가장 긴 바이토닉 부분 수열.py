N = int(input())
A = list(map(int, input().split()))

increase = [1] * N
for i in range(N) :
    for j in range(i) :
        if A[j] < A[i] :
            increase[i] = max(increase[i], increase[j] + 1)

decrease = [1] * N
for i in range(N-1,-1,-1) :
    for j in range(i+1, N) :
        if A[j] < A[i] :
            decrease[i] = max(decrease[i], decrease[j] + 1)

result = 0
for i in range(N) :
    result = max(result, increase[i] + decrease[i] - 1)

print(result)