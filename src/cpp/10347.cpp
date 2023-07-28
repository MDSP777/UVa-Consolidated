#include<bits/stdc++.h>

using namespace std;

int main(){
    double a, b, c;
    while(scanf("%lf %lf %lf", &a, &b, &c)!=EOF){
        double s = (a+b+c)/2;
        double A = 4.0/3.0*sqrt(s*(s-a)*(s-b)*(s-c));
        printf("%.3lf\n", isnan(A) || A<1e-9 ? -1.0 : A);
    }
}
