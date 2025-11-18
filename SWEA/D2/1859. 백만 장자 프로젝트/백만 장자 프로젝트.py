n1 = int(input())

for i in range(n1) :
    n2 = int(input())
    line = list(map(int,input().split()))
    
    max = 0
    answer = 0
    for j in range(n2-1, -1, -1) :
        if line[j] > max :
            max = line[j]
        else :
            answer += max - line[j]
            
    print(f"#{i + 1} {answer}")