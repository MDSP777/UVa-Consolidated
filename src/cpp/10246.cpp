#include <iostream>

using namespace std;

int main(){
    int c, r, q;
    int costs[100];
    int fw[100][100];
    int feast[100][100];
    bool first = true;
    int tc = 1;
    while(1){
        scanf("%d %d %d", &c, &r, &q);
        if(c==0) break;

        if(first) first = false;
        else printf("\n");

        printf("Case #%d\n", tc++);

        for(int i=0; i<c; i++)
            for(int j=0; j<c; j++) {
                fw[i][j] = 100000000;
                feast[i][j] = -1;
            }
        for(int i=0; i<c; i++) {
            scanf("%d", &costs[i]);
            feast[i][i] = costs[i];
        }
        while(r--){
            int src, dest, cost;
            scanf("%d %d %d", &src, &dest, &cost);
            src--;
            dest--;
            fw[src][dest] = fw[dest][src] = cost;
            feast[src][dest] = feast[dest][src] = max(costs[src], costs[dest]);
            // printf("FEAST %d %d = %d\n", src, dest, feast[src][dest]);
        }

        for(int k=0; k<c; k++)
            for(int i=0; i<c; i++)
                for(int j=0; j<c; j++)
                    if(fw[i][k]+fw[k][j] + max(feast[i][k], feast[k][j])<fw[i][j]+feast[i][j]){
                        fw[i][j] = fw[i][k]+fw[k][j];
                        feast[i][j] = max(feast[i][k], feast[k][j]);
                    }
                    
        for(int k=0; k<c; k++)
            for(int i=0; i<c; i++)
                for(int j=0; j<c; j++)
                    if(fw[i][k]+fw[k][j] + max(feast[i][k], feast[k][j])<fw[i][j]+feast[i][j]){
                        fw[i][j] = fw[i][k]+fw[k][j];
                        // feast[i][j] = max(feast[i][k], feast[k][j]);
                    }
                    
        
        while(q--){
            int src, dest;
            scanf("%d %d", &src, &dest);
            src--;
            dest--;
            if(fw[src][dest]==100000000) printf("-1\n");
            else printf("%d\n", fw[src][dest]+feast[src][dest]);
        }
    }
}