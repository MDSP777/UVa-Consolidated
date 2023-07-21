#include<bits/stdc++.h>

using namespace std;

double area(double a, double b, double c){
    double s = (a+b+c)/2;
    return sqrt(s*(s-a)*(s-b)*(s-c));
}

double dist(double x1, double y1, double x2, double y2){
    double x = x1-x2;
    double y = y1-y2;
    return sqrt(x*x+y*y);
}

int main(){
    int tc;
    scanf("%d", &tc);
    while(tc--){
        double x1, y1, x2, y2, x3, y3;
        scanf("%lf %lf %lf %lf %lf %lf", &x1, &y1, &x2, &y2, &x3, &y3);
        printf("%.0lf\n", area(dist(x1, y1, x2, y2), dist(x1, y1, x3, y3), dist(x2, y2, x3, y3))/7);
    }
}