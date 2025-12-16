# 백준 2573 - 빙산
# https://www.acmicpc.net/problem/2573
# 난이도: 골드 4
# 알고리즘: BFS/DFS + 시뮬레이션
from collections import deque
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(N)]

# 0이 상하좌우에 있으면 1개마다 1번씩 녹음
# 덩어리가 2개 이상일 시 끝

# 1. 2개인지 아닌지 확인 후
# 2. 0 근처 1씩 줄이기 (temp 써서 복사 시키기)

dx=[0,0,1,-1]
dy=[1,-1,0,0]

def bfs() :
    count = 0
    q= deque([])
    v = [[False] * M for _ in range(N)]
    for i in range(N) :
        for j in range(M) :
            if A[i][j] != 0 and v[i][j] == False :
                count += 1
                q.append((i,j))
                v[i][j] = True
                while q :
                    x, y = q.popleft()

                    for k in range(4) :
                        nx,ny=x+dx[k],y+dy[k]

                        if 0<=nx <N and 0<=ny<M and v[nx][ny]==False and A[nx][ny] != 0:
                            q.append((nx,ny))
                            v[nx][ny] = True 
    
    return count

def ice():
    temp = [[0] * M for _ in range(N)]

    for i in range(N):
        for j in range(M):
            if A[i][j] > 0:  # 빙산이 있는 경우만
                sea_count = 0
                for k in range(4):
                    nx, ny = i + dx[k], j + dy[k]
                    if 0 <= nx < N and 0 <= ny < M and A[nx][ny] == 0:
                        sea_count += 1
                # 0 이하로 내려가지 않도록
                temp[i][j] = max(0, A[i][j] - sea_count)

    # temp를 A로 복사
    for i in range(N):
        for j in range(M):
            A[i][j] = temp[i][j]

answer = 0
# 빙산이 2개 이상 되면 종료

while True:
    c = bfs()  # 덩어리 개수 세기

    if c == 0:  # 빙산이 다 녹음
        print(0)
        break
    elif c >= 2:  # 2개 이상으로 분리됨
        print(answer)
        break
    else:  # c == 1, 아직 1개 덩어리
        ice()  # 빙산 녹이기
        answer += 1

