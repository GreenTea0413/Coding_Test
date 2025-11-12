from collections import deque

def solution(priorities, location):
    queue = deque([p,i] for i, p in enumerate(priorities))


    order = 0
    while queue :
        cur = queue.popleft()
        
        if any(cur[0] < q[0] for q in queue) :
            queue.append(cur)
            
        else :
            order += 1
            if cur[1] == location :
                return order