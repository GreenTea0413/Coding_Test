def solution(progresses, speeds):
    answer = []
    temp = []
    l = int(len(progresses))
    i = 0
    while i < l :
        num = int((100 - progresses[i]) / speeds[i])
        if(int((100 - progresses[i]) % speeds[i]) > 0) : num += 1
        temp.append(num)
        i += 1

    # [7,3,9]
    now = temp[0]
    count = 1
    for n in temp[1:] :
        if(n <= now) :
            count += 1
        else :
            answer.append(count)
            now = n
            count = 1
    answer.append(count)
    return answer