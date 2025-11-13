from itertools import permutations

def isPrime(n) :
    if(n <= 1) : return 0
    
    for i in range(2, int(n ** 0.5) + 1) :
        if(n % i == 0) : return 0

    return 1

def solution(numbers):
    answer = 0
    arr = sorted(numbers)
    nums = []
    num = set()
    for i in range(1, len(arr) + 1) :
        nums.extend(list(permutations(arr, i)))
    
    for n in nums :
        num.add(int("".join(n)))
    
    for n in num :
        answer += isPrime(n)
    
    
    return answer