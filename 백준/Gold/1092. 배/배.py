import sys
input = sys.stdin.readline

N = int(input())
limit = list(map(int, input().split()))

M = int(input())
box = list(map(int, input().split()))

limit.sort(reverse=True)
box.sort(reverse=True)

if box[0] > limit[0] :
    print(-1)
    exit()
else :
    time = 0
    while box :
        for l in limit :
            if box and l < box[-1] :
                continue
            for b in box :
                if l >= b :
                    box.remove(b)
                    break

        time += 1

    print(time)

