#include<bits/stdc++.h>

using namespace std;

int main(){
    int w, n, a, b;
    while(scanf("%d", &w)==1){
        scanf("%d", &n);
        int area = 0;
        while(n--){
            scanf("%d %d", &a, &b);
            area+=a*b;
        }
        printf("%d\n", area/w);
    }
}
