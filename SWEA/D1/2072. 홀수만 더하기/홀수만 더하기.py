n = input()


def main(n) -> int:

    for i in range(1, n+1) :
        result = 0
        number = list(map(int,input().split()))
        
        for j in range(len(number)) :
            if(number[j] % 2 == 1) :
                result += number[j] 
            
        print(f'#{i} {result}')
        
    return 0

    
main(int(n))
