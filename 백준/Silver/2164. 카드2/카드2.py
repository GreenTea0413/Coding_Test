from collections import deque

N = int(input())
queue = deque([i for i in range(1,N + 1)])
answer = 0

while len(queue) > 1 :
    a = queue.popleft()
    b = queue.popleft()

    queue.append(b)
    answer = b

if len(queue) == 1 :
    print(queue.popleft())
else : print(answer)

