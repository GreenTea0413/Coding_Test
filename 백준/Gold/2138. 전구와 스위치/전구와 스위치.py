def solve(current, target, first_switch):
    n = len(current)
    curr = current[:]
    count = 0

    # 첫 번째 스위치 처리
    if first_switch:
        curr[0] = 1 - curr[0]
        curr[1] = 1 - curr[1]
        count += 1

    # 왼쪽부터 확정
    for i in range(n - 1):
        if curr[i] != target[i]:
            # i+1번 스위치 누르기
            count += 1
            curr[i] = 1 - curr[i]
            curr[i+1] = 1 - curr[i+1]
            if i + 2 < n:
                curr[i+2] = 1 - curr[i+2]

    # 마지막 확인
    if curr[-1] != target[-1]:
        return float('inf')

    return count

n = int(input())
current = list(map(int, list(input())))
target = list(map(int, list(input())))

# 경우 1: 첫 스위치 안 누름
case1 = solve(current, target, False)

# 경우 2: 첫 스위치 누름
case2 = solve(current, target, True)

result = min(case1, case2)
print(result if result != float('inf') else -1)