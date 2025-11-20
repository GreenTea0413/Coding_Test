# 0, 4, 6, 8, 9
# 1 -> 0
# 2 -> 8
# 3 -> 48
t = int(input())
arr1 = [0,4,6,9]

for test in range(t) :
    n = int(input())
    if n == 1 :
        print(0)
    elif n == 2 :
        print(8)
    else :
        n8 = n // 2
        n1 = n % 2
        
        arr = ''
        if n1 != 0 :
            arr ='4'
        for i in range(n8) :
                arr += '8'
        print(int(arr))