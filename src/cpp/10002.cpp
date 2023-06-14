#include<bits/stdc++.h>

using namespace std;

int n;

struct point {
    long long x, y;

    point(long long a, long long b) :
        x(a), y(b) {}

    bool operator < (point o) {
        if(x==o.x) return y<o.y;
        return x<o.x;
    }
};

point toVec(point a, point b){
    return point(b.x-a.x, b.y-a.y);
}

long long cross(point a, point b) {
    return a.x*b.y - a.y*b.x;
}

bool ccw(point a, point b, point c) {
    return cross(toVec(a, b), toVec(a, c)) > 0;
}

vector<point> findHull(vector<point> points) {
    vector<point> lower;
    for(int i=0; i<n; i++){
        while(lower.size()>=2 && !ccw(lower[lower.size()-2], lower[lower.size()-1], points[i])) 
            lower.pop_back();
        lower.push_back(points[i]);
    }

    vector<point> upper;
    for(int i=n-1; i>=0; i--){
        while(upper.size()>=2 && !ccw(upper[upper.size()-2], upper[upper.size()-1], points[i])) 
            upper.pop_back();
        upper.push_back(points[i]);
    }
    
    for(int i=1; i<upper.size(); i++)
        lower.push_back(upper[i]);

    return lower;
}

double area(vector<point> poly){
    double a = 0;
    for(int i=1; i<poly.size(); i++)
        a+=cross(poly[i-1], poly[i]);
    return a/2;
}

int main(){
    while(true){
        scanf("%d", &n);
        if(n<3) break;

        vector<point> points;
        for(int i=0; i<n; i++){
            long long x, y;
            scanf("%lld %lld", &x, &y);
            points.push_back(point(x, y));
        }
        sort(points.begin(), points.end());
        vector<point> hull = findHull(points);

        // https://en.wikipedia.org/wiki/Centroid#Of_a_polygon
        double a = area(hull);
        double cx = 0, cy = 0;
        for(int i=1; i<hull.size(); i++){
            cx+=(hull[i-1].x+hull[i].x)*cross(hull[i-1], hull[i]);
            cy+=(hull[i-1].y+hull[i].y)*cross(hull[i-1], hull[i]);
        }
        printf("%.3lf %.3lf\n", cx/(6*a), cy/(6*a));
    }
}
