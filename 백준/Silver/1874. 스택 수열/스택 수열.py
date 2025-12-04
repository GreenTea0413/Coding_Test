import sys

input = sys.stdin.readline

N = int(input())
arr = [] 
for _ in range(N) :
    arr.append(int(input()))

# 4 3 6 8 7 5 2 1
stack = [1]
answer = ['+']

# 4부터 시작해서 stack에 값 없으면 넣기
# 1, 2, 3, 4 -> 4 나가고
# 3 나가고
# 6 나왔네 1,2 max= 4  5부터 들어가게 1,2,5,6 6 나가고
# 8 max = 6 1,2,5,7,8 8나가고
# 7 1,2,5,7 7 나가고

m = 1
for a in arr :
    if len(stack) == 0 :
        for i in range(m + 1, a + 1) :
            stack.append(i)
            answer.append('+')
        m = max(a, m)
    if stack[-1] != a : 
        for i in range(m + 1, a + 1) :
            stack.append(i)
            answer.append('+')
        m = max(a, m)
    if len(stack) > 0 and stack[-1] == a :
        stack.pop()
        answer.append('-')

if len(stack) > 0 :
    print('NO')
else :
    for a in answer :
        print(a)

    
        
        
        
