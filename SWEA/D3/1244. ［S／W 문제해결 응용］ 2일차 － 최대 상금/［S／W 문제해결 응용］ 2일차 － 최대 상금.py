T = int(input())

def solve(num, count):
    visited = set()
    answer = 0

    def dfs(n, c):
        nonlocal answer

        if (n, c) in visited:
            return
        visited.add((n, c))

        if c == 0:
            answer = max(answer, int(n))
            return

        n_list = list(n)
        length = len(n_list)

        for i in range(length):
            for j in range(i + 1, length):
                n_list[i], n_list[j] = n_list[j], n_list[i]
                dfs(''.join(n_list), c - 1)
                n_list[i], n_list[j] = n_list[j], n_list[i]

    dfs(num, count)
    return answer


for tc in range(1, T + 1):
    num, count = input().split()
    count = int(count)
    result = solve(num, count)
    print(f"#{tc} {result}")