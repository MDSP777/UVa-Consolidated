#include<bits/stdc++.h>

using namespace std;

struct point {
	double x, y;

	point() {}

	point(double a, double b) :
		x(a), y(b) {}
};

double area(double a, double b, double c){
	double s = (a+b+c)/2;
	return sqrt(s*(s-a)*(s-b)*(s-c));
}

double dist(point p1, point p2){
	double x = p1.x-p2.x;
	double y = p1.y-p2.y;
	return sqrt(x*x+y*y);
}

point toVec(point a, point b){
	return point(b.x-a.x, b.y-a.y);
}

double dot(point a, point b){
	return a.x*b.x+a.y*b.y;
}

double angle(point a, point o, point b){
	point oa = toVec(o, a), ob = toVec(o, b);
	return acos(dot(oa, ob) / sqrt(dot(oa, oa)*dot(ob, ob)));
}

int main() {
	point a, b, c, d, e, f;
	while(1){
		scanf("%lf %lf %lf %lf %lf %lf %lf %lf %lf %lf %lf %lf", 
			&a.x, &a.y, &b.x, &b.y, &c.x, &c.y, &d.x, &d.y, &e.x, &e.y, &f.x, &f.y);
		if(a.x==0 && a.y==0 && b.x==0 && b.y==0 && c.x==0 && c.y==0
			&& d.x==0 && d.y==0 && e.x==0 && e.y==0 && f.x==0 && f.y==0) break;

		double tArea = area(dist(d, e), dist(d, f), dist(e, f));
		double theta = angle(c, a, b);
		double pBase = dist(a, b);
		double pHeight = tArea/pBase;
		double B = pHeight/tan(theta);
		double h = sqrt(pHeight*pHeight+B*B);

		point ac = toVec(a, c);
		double len = dist(a, c);
		double t = h/len;
		point G = point(ac.x*t+b.x, ac.y*t+b.y);
		point H = point(ac.x*t+a.x, ac.y*t+a.y);
		printf("%.3lf %.3lf %.3lf %.3lf\n", G.x, G.y, H.x, H.y);
	}
}
