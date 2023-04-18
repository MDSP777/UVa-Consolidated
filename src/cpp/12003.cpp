#include<bits/stdc++.h>

using namespace std;

long long curVal[300500];

int main(){
    int n, m, l, r, p;
    long long u, v;
    scanf("%d %d %lld", &n, &m, &u);

    for(int i=0; i<300500; i++)
        curVal[i] = LLONG_MAX;
    
    int rt = ceil(sqrt(n));
    int curBlock = -1;
    for(int i=0; i<n; i++)
        scanf("%lld", &curVal[i]);
    
    vector<long long> a(curVal, curVal+300500);

    for(int i=0; i<rt; i++){
        int x = i*rt;
        int y = (i+1)*rt;
        sort(a.begin()+x, a.begin()+y);
    }

    while(m--){
        scanf("%d %d %lld %d", &l, &r, &v, &p);
        l--;
        r--;
        p--;
        int k = 0;
        if(r-l+1<rt){
            for(int i=l; i<=r; i++)
                if(curVal[i]<v) k++;
        } else {
            int lBlockIdx = l%rt==0 ? l/rt : l/rt+1;
            int rBlockIdx = (r+1)%rt==0 ? (r+1)/rt : r/rt;
            int end = lBlockIdx*rt;
            for(int i=l; i<n && i<end; i++)
                if(curVal[i]<v) k++;
            
            for(int i=rt*rBlockIdx; i<n && i<=r; i++)
                if(curVal[i]<v) k++;
            
            for(int i=lBlockIdx; i<rt && i<rBlockIdx; i++){
                int x = i*rt;
                int y = (i+1)*rt;
                vector<long long>::iterator it = lower_bound(a.begin()+x, a.begin()+y, v);
                k+=it-a.begin()-x;
			}
        }
        long long oldVal = curVal[p];
        curVal[p] =  u*k/(r-l+1);
        int blockIdx = p/rt;
        int x = blockIdx*rt;
        int y = (blockIdx+1)*rt;
        vector<long long>::iterator it = lower_bound(a.begin()+x, a.begin()+y, oldVal);
        a[it-a.begin()] = curVal[p];
        sort(a.begin()+x, a.begin()+y);    
    }

    for(int i=0; i<n; i++) printf("%d\n", curVal[i]);
}