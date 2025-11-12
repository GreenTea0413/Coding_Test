def solution(ingredient):
    stack = []
    answer = 0
    # 무조건 빵 야채 고기 빵 순서가 되면 또로롱!
    # 빵 1 야채 2 고기 3
    # 1 찾고 2 찾고 3 찾고 1 찾고 배열에서 제외
    
    for i in ingredient :
        stack.append(i)
        
        if(stack[-4:] == [1,2,3,1]) :
            answer += 1
            for i in range(4) :
                stack.pop()
            
    return answer