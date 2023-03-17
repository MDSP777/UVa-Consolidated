class Point:

    def __init__(self, x, y):
        self.x = x
        self.y = y

    def __str__(self):
        return '{} {}'.format(self.x, self.y)

def toVec(a, b):
    return Point(b.x-a.x, b.y-a.y)

def cross(a, b):
    return a.x*b.y - a.y*b.x

def checkDir(p, q, r):
    c = cross(toVec(p, q), toVec(p, r)) 
    if c<0:
        return -1
    if c==0:
        return 0
    return 1

def hasIntersection(p1, p2, p3, p4):
    x1 = min(p1.x, p2.x)
    x2 = max(p1.x, p2.x)
    y1 = min(p1.y, p2.y)
    y2 = max(p1.y, p2.y)

    if p1.x==p2.x==p3.x==p4.x:
        return (y1 <= p3.y <= y2 or y1 <= p4.y <= y2)
    
    if p1.y==p2.y==p3.y==p4.y:
        return (x1 <= p3.x <= x2 or x1 <= p4.x <= x2)

    return (checkDir(p1, p2, p3) != checkDir(p1, p2, p4) and 
            checkDir(p3, p4, p1) != checkDir(p3, p4, p2))


tc = int(input())

while tc>0:
    cArr = [int(i) for i in input().split()]
    lineStart = Point(cArr[0], cArr[1])
    lineEnd = Point(cArr[2], cArr[3])
    rectTL = Point(min(cArr[4], cArr[6]), max(cArr[5], cArr[7]))
    rectBR = Point(max(cArr[4], cArr[6]), min(cArr[5], cArr[7]))

    if (rectTL.x <= lineStart.x <= rectBR.x and rectBR.y <= lineStart.y <= rectTL.y or 
        rectTL.x <= lineEnd.x <= rectBR.x and rectBR.y <= lineEnd.y <= rectTL.y):
        print('T')
    elif (hasIntersection(lineStart, lineEnd, rectTL, Point(rectBR.x, rectTL.y)) or # top
          hasIntersection(lineStart, lineEnd, rectTL, Point(rectTL.x, rectBR.y)) or # left
          hasIntersection(lineStart, lineEnd, Point(rectTL.x, rectBR.y), rectBR) or # bottom
          hasIntersection(lineStart, lineEnd, Point(rectBR.x, rectTL.y), rectBR)): # right
        print('T')
    else:
        print('F')

    tc-=1


