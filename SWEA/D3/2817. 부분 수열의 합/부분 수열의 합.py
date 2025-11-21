
from itertools import combinations
T = int(input())

for tc in range(1, T + 1) :
    answer = 0
    N, K = map(int, input().split())
    arr = list(map(int, input().split()))
    
    for i in range(N) :
        com = list(combinations(arr, i+1))
        for c in com :
            if sum(c) == K :
                answer +=1

    print(f"#{tc} {answer}")