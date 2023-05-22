#include<bits/stdc++.h>

using namespace std;

int x[4000];
int y[4000];

int main(){
    while(true){
        int n, q;
        scanf("%d %d", &n, &q);
        if(n==0 && q==0) break;

        for(int i=0; i<n; i++)
            scanf("%d %d", &x[i], &y[i]);

        int dist[40000] = {};
        dist[0] = n;
        for(int i=0; i<n; i++)
            for(int j=i+1; j<n; j++){
                int d = ceil(sqrt((x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j])));
                dist[d]+=2;
            }

        for(int i=1; i<40000; i++)
            dist[i]+=dist[i-1];
    
        while(q--){
            int r;
            scanf("%d", &r);
            printf("%.2f\n", dist[r]*1.0/n);
        }
        printf("\n");
    }
}