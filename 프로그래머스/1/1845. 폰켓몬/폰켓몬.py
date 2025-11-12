def solution(nums):
    answer = 0
    check = set(nums)
    l = len(nums)
    c_l = len(check)
    
    if (int(l / 2) > c_l) :
        return c_l
    else :
        return int(l / 2)
    
    return answer