#include<bits/stdc++.h>

using namespace std;

double x[200];
double y[200];

double eps = 1e-9;

double dist(double x1, double y1, double x2, double y2) {
    double xDiff = x1-x2;
    double yDiff = y1-y2;
    return sqrt(xDiff*xDiff + yDiff*yDiff);
}

void translate(int i, double percent, double *curX, double *curY){
    double rise = y[i]-y[i-1];
    double run = x[i]-x[i-1];
    *curX = x[i-1]+run*percent;
    *curY = y[i-1]+rise*percent;
}

int main() {
    int tc, n, t;
    scanf("%d", &tc);
    for(int q=1; q<=tc; q++){
        scanf("%d %d", &n, &t);
        double total = 0;
        for(int i=0; i<n; i++){
            scanf("%lf %lf", &x[i], &y[i]);
            if(i>0) total+=dist(x[i-1], y[i-1], x[i], y[i]);
        }
        printf("Road #%d:\n", q);
        printf("%.2lf %.2lf\n", x[0], y[0]);
        int curRoad = 1;
        double curDist = 0;
        double curPercent = 0;
        double segmentDist = total/(t-1);
        double curX = x[0];
        double curY = y[0];
        for(int i=1; i<t-1; i++){
            while(true){
                double remRoad = dist(curX, curY, x[curRoad], y[curRoad]);
                if(curDist+remRoad<segmentDist){
                    curDist+=remRoad;
                    curX = x[curRoad];
                    curY = y[curRoad++];
                    curPercent = 0;
                } else if(curDist+remRoad>=segmentDist){
                    double remDist = segmentDist-curDist;
                    double remPercent = remDist/dist(x[curRoad-1], y[curRoad-1], x[curRoad], y[curRoad]);
                    curPercent+=remPercent;
                    translate(curRoad, curPercent, &curX, &curY);
                    printf("%.2lf %.2lf\n", curX, curY);
                    curDist = 0;
                    break;
                }
            }

            if(abs(1-curPercent)<eps){
                curPercent = 0;
                curX = x[curRoad];
                curY = y[curRoad++];
            }
        }
        printf("%.2lf %.2lf\n\n", x[n-1], y[n-1]);
    }
}