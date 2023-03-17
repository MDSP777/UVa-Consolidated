#include <iostream>

using namespace std;

int arr[1<<15];
int pot[1<<15];

int main(){
    int s, n;
    while(scanf("%d", &s)==1){
        n = 1<<s;
        for(int i=0; i<n; i++)
            scanf("%d", &arr[i]);
        
        for(int i=0; i<n; i++){
            pot[i] = 0;
            for(int j=0; j<s; j++)
                pot[i]+=arr[i ^ (1<<j)];
        }

        int ans = -100000000;
        for(int i=0; i<n; i++)
            for(int j=0; j<s; j++)
                ans = max(ans, pot[i]+pot[i ^ (1<<j)]);

        printf("%d\n", ans);
    }
}