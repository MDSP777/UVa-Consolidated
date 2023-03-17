#include <iostream>
#include <map>
#include <cmath>

using namespace std;

int main(){
    int tops[55];
    int ans[55];
    tops[1] = ans[1] = 1;
    int nextToPut = 2;

    map<int, int> pegMap;
    pegMap[1] = 1;

    for(int i=2; i<=50; i++){
        tops[i] = nextToPut;
        pegMap[nextToPut++] = i;
        while(true){
            int ts = floor(sqrt(nextToPut*2));
            int target = ts*ts;
            if(pegMap.count(target-nextToPut)==0 || target-nextToPut!=tops[pegMap[target-nextToPut]]) 
                break;

            int peg = pegMap[target-nextToPut];
            tops[peg] = nextToPut;
            pegMap[nextToPut++] = peg;
        }
        ans[i] = nextToPut-1;
    }

    int tc, x;
    scanf("%d", &tc);
    while(tc--){
        scanf("%d", &x);
        printf("%d\n", ans[x]);
    }
}