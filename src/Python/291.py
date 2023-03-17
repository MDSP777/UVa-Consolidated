adjmat = [[-1 for j in range(6)] for i in range(6)]

adjmat[1][2] = adjmat[2][1] = 0
adjmat[2][3] = adjmat[3][2] = 1
adjmat[3][4] = adjmat[4][3] = 2
adjmat[4][5] = adjmat[5][4] = 3
adjmat[1][5] = adjmat[5][1] = 4
adjmat[1][3] = adjmat[3][1] = 5
adjmat[5][3] = adjmat[3][5] = 6
adjmat[2][5] = adjmat[5][2] = 7

used = [False for i in range(8)]
traversed = []

def bt(cur):
    global adjmat, used, traversed
    if all(used):
        print(''.join([str(i) for i in traversed]))
        return
    for i in range(6):
        if adjmat[cur][i] != -1 and not used[adjmat[cur][i]]:
            used[adjmat[cur][i]] = True
            traversed.append(i)
            bt(i)
            traversed.pop()
            used[adjmat[cur][i]] = False

traversed.append(1)
bt(1)
