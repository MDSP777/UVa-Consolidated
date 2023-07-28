#include<bits/stdc++.h>

using namespace std;

struct point {
    double x, y;

    point(double a, double b) :
        x(a), y(b) {}

    point() {}
};

double dist(point a, point b){
    double x = a.x-b.x;
    double y = a.y-b.y;
    return sqrt(x*x+y*y);
}

point toVec(point a, point b){
    return point(b.x-a.x, b.y-a.y);
}

double dot(point a, point b){
    return a.x*b.x + a.y*b.y;
}

point scale(point p, double s){
    return point(p.x*s, p.y*s);
}

point translate(point p, point v){
    return point(p.x+v.x, p.y+v.y);
}

double distToLine(point p, point a, point b){
    point ap = toVec(a, p), ab = toVec(a, b);
    double u = dot(ap, ab) / dot(ab, ab);
    point c = translate(a, scale(ab, u));
    return dist(p, c);
}

double distToLineSegment(point p, point a, point b){
    point ap = toVec(a, p), ab = toVec(a, b);
    double u = dot(ap, ab) / dot(ab, ab);
    if(u<0.0) return dist(p, a);
    if(u>1.0) return dist(p, b);
    return distToLine(p, a, b);
}

double angle(point a, point o, point b){
    point oa = toVec(o, a), ob = toVec(o, b);
    return acos(dot(oa, ob) / sqrt(dot(oa, oa)*dot(ob, ob)));
}

int main(){
    int tc;
    point origin = point(0, 0);
    scanf("%d", &tc);
    while(tc--){
        point a, b;
        double r;
        scanf("%lf %lf %lf %lf %lf", &a.x, &a.y, &b.x, &b.y, &r);
        double d = distToLineSegment(origin, a, b);
        if(isnan(d) || d>r) printf("%.3lf\n", dist(a, b));
        else {
            double theta = angle(a, origin, b);
            
            double h = dist(a, origin);
            double total = sqrt(h*h-r*r);
            theta-=acos(r/h);

            h = dist(b, origin);
            total += sqrt(h*h-r*r);
            theta-=acos(r/h);

            total+=r*theta;
            printf("%.3lf\n", total);
        }
    }
}
