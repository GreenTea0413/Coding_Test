def solution(answers):
    answer = []
    count = {1 : 0, 2 : 0, 3 : 0}
    n1 = [1,2,3,4,5]
    n2 = [2,1,2,3,2,4,2,5]
    n3 = [3,3,1,1,2,2,4,4,5,5]
    
    for i in range (len(answers)) :
        if(n1[i % 5] == answers[i]) : count[1] +=1
        if(n2[i % 8] == answers[i]) : count[2] +=1
        if(n3[i % 10] == answers[i]) : count[3] +=1
    
    
    arr = sorted(count.items(), key = lambda x : x[1], reverse=True)
    m = arr[0][1]
    
    for i, j in arr :
        if j == m :
            answer.append(i)

    return answer