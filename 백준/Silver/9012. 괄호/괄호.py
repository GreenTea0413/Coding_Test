import sys
input = sys.stdin.readline

N = int(input())

for _ in range(N) :
    stack = []
    arr = input().strip()
    isValid = True

    for a in arr :
        if a == '(' :
            stack.append(a)
        else :
            if len(stack) > 0 :
                now = stack.pop()
            else :
                isValid = False
                break

    if len(stack) == 0 and isValid :
        print('YES')
    else :
        print('NO')
    