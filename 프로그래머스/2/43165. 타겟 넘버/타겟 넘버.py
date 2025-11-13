def dfs(numbers, index, count, target) :
    if index == len(numbers) :
        if(target == count) :
            return 1
        else :
            return 0
    return dfs(numbers, index + 1, count + numbers[index], target) + dfs(numbers, index + 1, count - numbers[index], target)

def solution(numbers, target):
    answer = 0
    return dfs(numbers, 0, 0, target)