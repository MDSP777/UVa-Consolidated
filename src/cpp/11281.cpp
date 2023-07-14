#include<bits/stdc++.h>

using namespace std;

int main(){
    int m, n;
    scanf("%d", &m);
    double holes[150];
    for(int i=0; i<m; i++)
        scanf("%lf", &holes[i]);
    
    scanf("%d", &n);
    for(char i='A'; i<'A'+n; i++){
        double a, b, c;
        scanf("%lf %lf %lf", &a, &b, &c);
        double s = (a+b+c)/2;
        double A = sqrt(s*(s-a)*(s-b)*(s-c));
        double D = (a*b*c)/(2*A);

        double t1 = acos((a*a + b*b - c*c) / (2*a*b));
        double t2 = acos((b*b + c*c - a*a) / (2*b*c));
        double t3 = M_PI-t1-t2;
        if(t1>M_PI/2 || t2>M_PI/2 || t3>M_PI/2)
            D = max(max(a, b), c);

        vector<int> fit;
        for(int j=0; j<m; j++)
            if(holes[j]-D>-1e-9) fit.push_back(j+1);
        
        if(fit.empty()) printf("Peg %c will not fit into any holes\n", i);
        else {
            printf("Peg %c will fit into hole(s):", i);
            for(int j=0; j<fit.size(); j++) printf(" %d", fit[j]);
            printf("\n");
        }
    }
}
