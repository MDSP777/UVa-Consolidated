import sys

sums = [0 for i in range(55)]

sums[0] = 1
for i in range(55):
    sums[i] = sums[i-1]+2**i

for line in sys.stdin:
	n, b = [int(i) for i in line.split()]

	if n <= sums[b]:
	    print("yes")
	else:
	    print("no")