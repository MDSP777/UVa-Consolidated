#include<bits/stdc++.h>

using namespace std;

int city[500100];

int main(){
    while(true){
        int n, b;
        scanf("%d %d", &n, &b);
        if(n==-1) break;

        int l = 1, r = 0;
        for(int i=0; i<n; i++){
            scanf("%d", &city[i]);
            r = max(r, city[i]);
        }

        for(int i=0; i<25; i++){
            int mid = (l+r)/2;
            int box = 0;
            for(int i=0; i<n; i++)
                box+=ceil(city[i]*1.0/mid);
            
            if(box>b) l = mid+1;
            else r = mid;
        }
        printf("%d\n", l);
    }
}