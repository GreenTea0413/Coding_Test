test = int(input())

for t in range(1, test + 1) :
    n1, n2 = map(int, input().split())
    
    arr1 = list(map(int, input().split()))
    arr2 = list(map(int, input().split()))
    # n1이 무조건 작다고 가정하기
    if n1 > n2 :
        temp = n1
        n1 = n2
        n2 = temp
        temp = arr1
        arr1 = arr2
        arr2 = temp
	
    answer = 0
    # 0 1 2 / 1 2 3 / 2 3 4
    for i in range(n2 - n1 + 1) :
        m = 0
        for j in range( i, i + n1) :
            m += arr1[j - i] * arr2[j]
        answer = max(answer, m)
    
    print(f"#{t} {answer}")
                
                
