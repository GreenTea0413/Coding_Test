test = int(input())

for t in range(1, 1 + test) :
    s = input().strip()
    
    if s == s[:: -1]:
        print(f"#{t} 1")
    else :
        print(f"#{t} 0")