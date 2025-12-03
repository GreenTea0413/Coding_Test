import sys
input = sys.stdin.readline

N, M = map(int, input().split())
r, c, d = map(int, input().split())  # 시작 위치 + 방향
room = [list(map(int, input().split())) for _ in range(N)]

# 방향: 북(0) 동(1) 남(2) 서(3)
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

cleaned = 0  # 청소한 칸 수

while True:
    # 1. 현재 칸 청소
    if room[r][c] == 0:
        room[r][c] = 2  # 청소 완료 표시
        cleaned += 1
    
    # 2. 주변 4칸 확인
    all_cleaned = True
    for i in range(4):
        nr = r + dx[i]
        nc = c + dy[i]
        if 0 <= nr < N and 0 <= nc < M and room[nr][nc] == 0:
            all_cleaned = False
            break
    
    if all_cleaned:
        # 3-1. 주변 4칸이 모두 청소되었거나 벽
        # 후진
        back_dir = (d + 2) % 4
        nr = r + dx[back_dir]
        nc = c + dy[back_dir]
        
        if 0 <= nr < N and 0 <= nc < M and room[nr][nc] != 1:
            # 후진 가능
            r, c = nr, nc
        else:
            # 후진 불가 (벽) → 종료
            break
    else:
        # 3-2. 청소되지 않은 빈 칸이 있음
        # 반시계 방향으로 90도 회전
        d = (d + 3) % 4
        
        # 앞쪽 칸 확인
        nr = r + dx[d]
        nc = c + dy[d]
        
        if 0 <= nr < N and 0 <= nc < M and room[nr][nc] == 0:
            # 전진
            r, c = nr, nc

print(cleaned)