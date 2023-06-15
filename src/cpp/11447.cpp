#include<bits/stdc++.h>

using namespace std;

int x[10500];
int y[10500];

int cross(int i, int j){
    return x[i]*y[j] - x[j]*y[i];
}

double area(int n){
    double a = 0;
    for(int i=1; i<=n; i++)
        a+=cross(i-1, i);
    return a/2;
}

int main(){
    int tc, n, w;
    double initial, consume, add;
    scanf("%d", &tc);
    while(tc--){
        scanf("%d", &n);
        for(int i=0; i<n; i++)
            scanf("%d %d", &x[i], &y[i]);
        x[n] = x[0];
        y[n] = y[0];
        scanf("%d %lf %lf %lf", &w, &initial, &consume, &add);
        initial/=100;
        double maxVol = area(n)*w;
        double curVol = initial*maxVol;
        curVol-=consume;
        if(curVol<0){
            printf("Lack of water. ");
            curVol = 0;
        }
        curVol+=add;
        if(curVol>maxVol){
            printf("Excess of water. ");
            curVol = maxVol;
        }
        printf("Final percentage: %d%\n", (int)(curVol/maxVol*100));
    }
}