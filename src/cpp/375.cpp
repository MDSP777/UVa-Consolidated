#include<bits/stdc++.h>

using namespace std;

double incircle(double b, double h){
    double hypot = sqrt((b/2)*(b/2)+h*h);
    double s = (b+hypot*2)/2;
    double A = b*h/2;
    return A/s;
}

int main() {
    int tc;
    scanf("%d", &tc);
    while(tc--){
        double b, h;
        scanf("%lf %lf", &b, &h);
        double total = 0;
        double rad = incircle(b, h);
        double theta = atan(h/(b/2));
        while(rad>=1e-6){
            double d = rad*2;
            total+=d;
            double u = d/tan(theta);
            h-=d;
            b-=u*2;
            rad = incircle(b, h);
        }
        
        printf("%13.6lf\n", total*M_PI);
        if(tc>0) printf("\n");
    }
}
