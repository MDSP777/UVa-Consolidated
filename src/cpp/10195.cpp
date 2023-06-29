#include<bits/stdc++.h>

using namespace std;

int main(){
    double a, b, c;
    while(scanf("%lf %lf %lf", &a, &b, &c)!=EOF){
        double s = (a+b+c)/2;
        double A = sqrt(s*(s-a)*(s-b)*(s-c));
        printf("The radius of the round table is: %.3lf\n", s==0 ? 0 : A/s);
    }
}
