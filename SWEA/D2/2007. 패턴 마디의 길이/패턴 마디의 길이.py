test = int(input())

for t in range(test) :
    s = input().strip()
    answer = 0
    for i in range(1, 11) :
        pattern = s[:i]
        if pattern * (30 // i) == s[ : ( 30// i ) * i ] :
            answer = i
       	    break
    print(f"#{t + 1} {answer}")