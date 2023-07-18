#include<bits/stdc++.h>

using namespace std;

int main() {
    int n, T, r, t;
    while(scanf("%d %d", &n, &T)!=EOF){
        double x = 0, y = 0;
        for(int i=0; i<n; i++) {
            scanf("%d %d", &r, &t);
            double curT = 2*M_PI*T/t;
            x+=r*cos(curT);
            y+=r*sin(curT);
            if(i>0) printf(" ");
            printf("%.4lf", sqrt(x*x+y*y));
        }
        printf("\n");
    }
}
