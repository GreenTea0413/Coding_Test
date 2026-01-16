G = int(input())

left, right = 1, 2
answer= []
while right < 100000 :
    kg = right ** 2 - left ** 2

    if G == kg :
        answer.append(right)
        right += 1        
    elif G > kg :
        right += 1
    else :
        left += 1
    
    if left == right :
        right += 1

if not answer :
    print(-1)
else :
    for a in answer :
        print(a)
    
