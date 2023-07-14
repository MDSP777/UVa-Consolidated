#include<bits/stdc++.h>

int main() {
    int R, n;
    while(scanf("%d %d", &R, &n)!=EOF) {
        if(R==0) {
            printf("%.10lf %.10lf %.10lf\n", 0.0, 0.0, 0.0);
            continue;
        }
        if(n==1) {
            printf("%.10lf %.10lf %.10lf\n", R*1.0, 0.0, 0.0);
            continue;
        }

        double A = M_PI*R*R;
        if(n==2){
            double r = R/2.0;
            printf("%.10lf %.10lf %.10lf\n", r, 0, A-2*M_PI*r*r);
            continue;
        }

        double theta = M_PI/n;
        double theta2 = M_PI/2-theta;
        double r = (sin(theta)*R)/(1+sin(theta));
        double a = M_PI*r*r;
        double h = (R-r)*cos(theta);
        double t = r*h/2;
        double p = t-(r*r*theta2/2);
        printf("%.10lf %.10lf %.10lf\n", r, p*2*n, A-(a*n)-(p*2*n));
    }
}
