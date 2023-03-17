import sys, math

for line in sys.stdin:
    l, w, h, theta = [int(i) for i in line.split()]
    v = l*w*h
    tan = math.tan(math.radians(theta))
    x = l*tan
    if x>h:
        theta = 90-theta
        tan = math.tan(math.radians(theta))
        x = h*tan
        A = (x*h/2)*w
        print('{:.3f} mL'.format(A))
    else:    
        A = (x*l/2)*w
        print('{:.3f} mL'.format(v-A))
