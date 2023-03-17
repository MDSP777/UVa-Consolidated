import sys, math

for line in sys.stdin:
    a, b, c = [int(i) for i in line.split()]
    s = (a+b+c)/2
    A = math.sqrt(s*(s-a)*(s-b)*(s-c))

    bigCircleRadius = (a*b*c) / (4*A)
    bigCircleArea = (bigCircleRadius**2) * math.pi
    smallCircleRadius = A/s
    smallCircleArea = (smallCircleRadius**2) * math.pi

    print('{:.4f} {:.4f} {:.4f}'.format(bigCircleArea-A, A-smallCircleArea, smallCircleArea))