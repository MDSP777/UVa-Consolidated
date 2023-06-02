#include<bits/stdc++.h>

using namespace std;

int factors[1000100];
int ans[1000100];

int main(){
    int tc, x;
    for(int i=1; i<=1000000; i++)
        for(int j=i; j<=1000000; j+=i)
            factors[j]++;

    int best = 1, bestId = -1;
    for(int i=1; i<=1000000; i++){
        if(factors[i]>=best){
            best = factors[i];
            bestId = i;
        }
        ans[i] = bestId;
    }
    
    scanf("%d", &tc);
    while(tc--){
        scanf("%d", &x);
        printf("%d\n", ans[x]);
    }
}