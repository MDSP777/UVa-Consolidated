#include<bits/stdc++.h>

using namespace std;

double eps = 1e-9;

bool equals(double x1, double y1, double x2, double y2){
    return abs(x1-x2)<eps && abs(y1-y2)<eps;
}

int main(){
    double x1, y1, x2, y2, x3, y3, x4, y4;
    while(scanf("%lf %lf %lf %lf %lf %lf %lf %lf", &x1, &y1, &x2, &y2, &x3, &y3, &x4, &y4)!=EOF){
        if(equals(x1, y1, x3, y3)){
            x3 = x4;
            y3 = y4;

            double temp = x1;
            x1 = x2;
            x2 = temp;
            temp = y1;
            y1 = y2;
            y2 = temp;
        } else if(equals(x2, y2, x3, y3)){
            x3 = x4;
            y3 = y4;
        } else if(equals(x1, y1, x4, y4)){
            double temp = x1;
            x1 = x2;
            x2 = temp;
            temp = y1;
            y1 = y2;
            y2 = temp;
        }

        double vx = x2-x1;
        double vy = y2-y1;
        printf("%.3lf %.3lf\n", x3-vx, y3-vy);
    } 
}