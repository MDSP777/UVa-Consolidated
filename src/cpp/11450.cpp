#include <iostream>

using namespace std;

int garments[25][25];
int memo[25][250];
int counts[25];

int MAX = 10000000;

int dp(int index, int money, int n){
    if(index==n) return 0;
    if(memo[index][money]!=-1) return memo[index][money];

    int best = -10000000;
    for(int i=0; i<counts[index]; i++){
        if(money-garments[index][i]>=0)
            best = max(best, garments[index][i]+dp(index+1, money-garments[index][i], n));
    }
    return memo[index][money] = best;
}

int main(){
    int tc;
    scanf("%d", &tc);
    while(tc--){
        int m, n;
        scanf("%d %d", &m, &n);
        for(int i=0; i<n; i++){
            scanf("%d", &counts[i]);
            for(int j=0; j<counts[i]; j++)
                scanf("%d", &garments[i][j]);
        }

        for(int i=0; i<25; i++)
            for(int j=0; j<250; j++)
                memo[i][j] = -1;

        int ans = dp(0, m, n);
        if(ans<0) printf("no solution\n");
        else printf("%d\n", ans);
    }
}