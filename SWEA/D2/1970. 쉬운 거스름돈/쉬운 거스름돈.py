test = int(input())

for t in range(1, 1 + test) :
    n = int(input())
    nums = [50000, 10000, 5000, 1000, 500, 100, 50, 10]
    
    print(f"#{t}")
    for num in nums :
        print(n // num, end = " ")
        n = n % num
    print()