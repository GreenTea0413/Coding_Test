T = int(input())
for tc in range(1, T + 1):
    N, K = map(int, input().split())
    arr = list(map(int, input().split()))
    arr.sort()  # 정렬!
    
    answer = 0
    
    def dfs(idx, current_sum):
        global answer
        
        # 목표 달성!
        if current_sum == K:
            answer += 1
            return
        
        # 가지치기: K 넘거나 범위 벗어남
        if current_sum > K or idx == N:
            return
        
        for i in range(idx, N):
            # 정렬했으므로, 현재 값 추가해도 K 안 넘을 때만 탐색
            if current_sum + arr[i] <= K:
                dfs(i + 1, current_sum + arr[i])
            else:
                break  # 이후는 더 크므로 볼 필요 없음!
    
    dfs(0, 0)
    print(f"#{tc} {answer}")