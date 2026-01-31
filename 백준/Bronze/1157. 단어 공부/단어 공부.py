from collections import Counter

s = input().upper()
count = Counter(s)
max_value = max(count.values())
arr = [k for k, v in count.items() if v == max_value]

if len(arr) > 1 :
    print('?')
else :
    print(arr[0])