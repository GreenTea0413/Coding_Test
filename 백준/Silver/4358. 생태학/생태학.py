#4358
from collections import defaultdict
import sys
input = sys.stdin.read
lines = input().strip().split('\n')

count = defaultdict(int)
total = 0

for line in lines:
    tree = line.strip()
    count[tree] += 1
    total += 1

for tree in sorted(count.keys()):
    percentage = (count[tree] / total) * 100
    print(f"{tree} {percentage:.4f}")