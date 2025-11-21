T = int(input())

for t in range(1, T + 1):
    arr = list(map(int, input().split()))

    # 최대값과 최소값 제거
    arr.remove(max(arr))
    arr.remove(min(arr))

    # 평균 (반올림)
    result = round(sum(arr) / len(arr))

    print(f"#{t} {result}")