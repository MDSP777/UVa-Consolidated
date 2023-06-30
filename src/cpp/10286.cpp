#include<bits/stdc++.h>

using namespace std;

double toRad(double deg){
    return deg*M_PI/180;
}


int main(){
    double F;
    while(scanf("%lf", &F)!=EOF){
        double x = F*cos(toRad(9));
        double h = F*sin(toRad(9));
        double y = h/tan(toRad(63));
        printf("%.10lf\n", x+y);
    }
}
