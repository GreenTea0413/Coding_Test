def dfs(begin, target, words, count, visited) :
    if(begin == target) : 
        return count
    
    answer = len(words) + 1
    for i in range(len(words)) :
        c = 0
        if visited[i] == False :
            for l in range(len(words[i])) :
                if begin[l] != words[i][l] :
                    c += 1

            if c == 1 :
                visited[i] = True
                result = dfs(words[i], target, words, count + 1, visited)
                visited[i] = False
                if result != 0 : 
                    answer = min(answer, result)
    
    if answer == len(words) + 1 :
        return 0
    return answer

def solution(begin, target, words):
    visited = [False]  * len(words)
    
    return dfs(begin, target, words, 0, visited)