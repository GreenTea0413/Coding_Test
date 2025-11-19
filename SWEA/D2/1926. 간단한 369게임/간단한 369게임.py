n = int(input())
arr = []

for i in range(1, n+1) :
    s = str(i)
    clap = s.count('3') + s.count('6') + s.count('9')
    
    if clap == 0 :
        arr.append(s)
    else :
        arr.append('-' * clap)
print(f"{' '.join(arr)}")