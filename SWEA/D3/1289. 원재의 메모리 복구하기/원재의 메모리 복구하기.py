T = int(input())

for tc in range(1, T+1) :
    answer = 0
    s = list(input().strip())
    l = int(len(s))
    f = ['0'] * l

    for i in range(l) :
        if f[i] != s[i] :
            answer +=1
            for j in range(i, l) :
                f[j] = s[i]
        
    print(f"#{tc} {answer}")