import sys
input = sys.stdin.readline

N = int(input())
stack = []

for _ in range(N) :
    s = list(map(str,input().split()))
    if s[0] == 'push':
        stack.append(int(s[1]))
    if s[0] == 'top' :
        if len(stack) > 0 :
            print(stack[-1])
        else : 
            print(-1)
    if s[0] == 'size' :
        print(len(stack))
    if s[0] == 'empty' :
        if len(stack) > 0 :
            print(0)
        if len(stack) == 0 :
            print(1)
    if s[0] == 'pop' :
        if len(stack) > 0 :
            p =  stack.pop()
            print(p)
        else : 
            print(-1)

