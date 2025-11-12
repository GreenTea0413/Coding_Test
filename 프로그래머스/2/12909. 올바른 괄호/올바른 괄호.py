def solution(s):
    stack = []
    
    for c in s :
        if(c == ')') :
            if (len(stack) == 0) : return False
            elif (len(stack) != 0) : 
                if(stack.pop() == ')') :
                    return False
            
        else :
            stack.append(c)
        

    return len(stack) == 0 
