#include<bits/stdc++.h>

using namespace std;

double area(double a, double b, double c){
    double s = (a+b+c)/2;
    return sqrt(s*(s-a)*(s-b)*(s-c));
}

int main() {
    int tc;
    scanf("%d", &tc);
    while(tc--){
        double r1, r2, r3;
        scanf("%lf %lf %lf", &r1, &r2, &r3);
        double a = r2+r3, b = r1+r3, c = r1+r2;
        double A = area(a, b, c);
        double thetaC1 = acos((b*b + c*c - a*a)/(2*b*c));
        double thetaC2 = acos((c*c + a*a - b*b)/(2*a*c));
        double thetaC3 = acos((a*a + b*b - c*c)/(2*a*b));
        double aC1 = M_PI*r1*r1, aC2 = M_PI*r2*r2, aC3 = M_PI*r3*r3;
        A-=thetaC1/(2*M_PI)*aC1;
        A-=thetaC2/(2*M_PI)*aC2;
        A-=thetaC3/(2*M_PI)*aC3;
        printf("%.6lf\n", A);
    }
}
