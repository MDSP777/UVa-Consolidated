#include<bits/stdc++.h>
using namespace std;

int ft[2000100];
bool exists[2000100];
int MAX = 2000000;

int lsOne(int s){
    return s & (-s);
}

int rsq(int x){
    int sum = 0;
    while(x){
        sum+=ft[x];
        x-=lsOne(x);
    }
    return sum;
}

void update(int i, int v){
    while(i<=MAX){
        ft[i]+=v;
        i+=lsOne(i);
    }
}

// simulate order statistics using fenwick tree
int findByOrder(int i){
    int l = 0, r = MAX+10;
    while(r-l>1){
        int m = (l+r)/2;
        int res = rsq(m);
        if(res>i || (res==i && !exists[m])) r = m;
        else if(res==i && exists[m]) return m;
        else l = m;
    }
    return l;
}

int main(){
    for(int i=1; i<=MAX; i+=2) {
        update(i, 1);
        exists[i] = true;
    }
    int cur = 2;
    while(true){
        int curVal = findByOrder(cur);
        int size =  rsq(MAX);
        if(curVal>size) break;
        for(int i=curVal; i<size; i+=curVal){
            int val = findByOrder(i);
            exists[val] = false;
            update(val, -1);
            i--;
        } 
        cur++;
    }

    int n;
    while(scanf("%d", &n)!=EOF){
        bool found = false;
        if(n%2==0) // crucial optimization, do not iterate if odd, sum is guaranteed to be impossible
            for(int i=n/2; !found && i>=1; i--){
                if(exists[i] && exists[n-i]){
                    printf("%d is the sum of %d and %d.\n", n, i, n-i);
                    found = true;
                    break;
                }
            }
        if(!found) printf("%d is not the sum of two luckies!\n", n);
    }
}
