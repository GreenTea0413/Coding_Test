import sys
from collections import deque
input = sys.stdin.readline

queue = deque()
N = int(input())

for _ in range(N) :
    words = input().split()
    if len(words) > 1 :
        if words[0] == 'push_back' :
            queue.append(words[1])
        if words[0] == 'push_front' :
            queue.appendleft(words[1])
    
    else :
        if words[0] == 'pop_front' :
            if len(queue) == 0:
                print(-1)
            else : 
                print(queue.popleft())
        if words[0] == 'pop_back' :
            if len(queue) == 0:
                print(-1)
            else : 
                print(queue.pop())

        if words[0] == 'front' :
            if len(queue) == 0 :
                print(-1)
            else :
                print(queue[0])
        if words[0] == 'back' :
            if len(queue) == 0:
                print(-1)
            else : 
                print(queue[-1])

        if words[0] == 'size' :
            print(len(queue))
            
        if words[0] == 'empty' :
            if len(queue) == 0 :
                print(1)
            else :
                print(0)
        


