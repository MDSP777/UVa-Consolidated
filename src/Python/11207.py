import math

def ans(w, h):
    best = -math.inf
    small = min(w, h)
    big = max(w, h)
    best = max(best, small/2)
    if big >= small*4:
        best = max(best, small)
    else:
        best = max(best, big/4)
    return best

while(True):
    n = int(input())
    if n==0:
        break
    best = -math.inf
    bestIndex = 0
    for i in range(n):
        w, h = [int(j) for j in input().split()]
        cur = ans(w, h)
        if cur>best:
            best = cur
            bestIndex = i+1

    print(bestIndex)
