#include<bits/stdc++.h>

using namespace std;

int main(){
    double x1, y1, x2, y2;
    while(scanf("%lf %lf %lf %lf", &x1, &y1, &x2, &y2)!=EOF){
        double cx = (x1+x2)/2, cy = (y1+y2)/2;
        x1-=cx;
        x2-=cx;
        y1-=cy;
        y2-=cy;

        double temp = -y1;
        y1 = x1;
        x1 = temp;

        temp = -y2;
        y2 = x2;
        x2 = temp;

        x1+=cx;
        x2+=cx;
        y1+=cy;
        y2+=cy;

        printf("%.10lf %.10lf %.10lf %.10lf\n", x1, y1, x2, y2);
    }
}