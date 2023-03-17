import math

ABS = 1e-9

class line:
    def __init__(self, a, b, c):
        self.a = a
        self.b = b
        self.c = c

def pointSlopeToLine(point, slope):
    a = -slope
    b = 1.0
    c = -((a*point[0]) + (b*point[1]))
    return line(a, b, c)

def findIntersection(line1, line2):
    x = (line2.b*line1.c - line1.b*line2.c) / (line2.a*line1.b - line1.a*line2.b)
    y = -(line2.a*x + line2.c)

    return [x, y]

def dist(p1, p2):
    return (p1[0]-p2[0])**2 + (p1[1]-p2[1])**2

ctr = 1

while True:
    n = int(input())
    if n==0:
        break

    minX = math.inf
    maxX = -math.inf
    minY = math.inf
    maxY = -math.inf

    points = []
    for i in range(3):
        points.append([float(i) for i in input().split()])
        minX = min(minX, points[-1][0])
        maxX = max(maxX, points[-1][0])
        minY = min(minY, points[-1][1])
        maxY = max(maxY, points[-1][1])
        
    lines = []
    for i in range(3):
        for j in range (i+1, 3):
            if abs(points[i][1]-points[j][1])<ABS:
                continue
            m = 0
            if abs(points[i][0]-points[j][0])>ABS:
                m = -1.0/((points[i][1]-points[j][1])/(points[i][0]-points[j][0]))
            lines.append(pointSlopeToLine([(points[i][0]+points[j][0])/2, (points[i][1]+points[j][1])/2], m))
    
    center = findIntersection(lines[0], lines[1])
    angle = math.radians(360/n)
    
    curPoint = points[0]
    for i in range(1, n):

        xrot = math.cos(angle)*(curPoint[0] - center[0]) - math.sin(angle)*(curPoint[1]-center[1]) + center[0]
        yrot = math.sin(angle)*(curPoint[0] - center[0]) + math.cos(angle)*(curPoint[1]-center[1]) + center[1]

        for a in points:
            if abs(xrot-a[0])<1 and abs(yrot-a[1])<1e-5:
                xrot = a[0]
                yrot = a[1]

        curPoint = [xrot, yrot]
        
        minX = min(minX, curPoint[0])
        maxX = max(maxX, curPoint[0])
        minY = min(minY, curPoint[1])
        maxY = max(maxY, curPoint[1])

    print("Polygon {}: {:.3f}".format(ctr, (maxX-minX)*(maxY-minY)))
    ctr+=1
        
