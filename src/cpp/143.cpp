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

point toVec(point p1, point p2){
	return point(p2.x-p1.x, p2.y-p1.y);
}

double cross(point a, point b){
	return a.x*b.y-a.y*b.x;
}

bool collinear(point a, point b, point c){
	return abs(cross(toVec(a, b), toVec(a, c))) < 1e-9;
}

bool equal(point a, point b){
	return abs(a.x-b.x)<1e-9 && abs(a.y-b.y)<1e-9;
}

int main(){
	point a, b, c;
	while(1){
		scanf("%lf %lf %lf %lf %lf %lf", &a.x, &a.y, &b.x, &b.y, &c.x, &c.y);
		if(a.x==0 && a.y==0 && b.x==0 && b.y==0 && c.x==0 && c.y==0) break;

		double ab = dist(a, b), ac = dist(a, c), bc = dist(b, c);
		double A = collinear(a, b, c) ? 0 : area(ab, ac, bc);
		bool coll = collinear(a, b, c);

		int unique = 3;
		if(equal(a, b) && equal(a, c)) unique = 1;
		else if(equal(a, b)){
			a = c;
			unique = 2;
		} else if(equal(a, c) || equal(b, c)){
			unique = 2;
		} 

		int total = 0;
		for(int x=1; x<100; x++)
			for(int y=1; y<100; y++){
				point p = point(x, y);
				if(unique==1){
					if(a.x==x && a.y==y) total++;
				} else if(unique==2){
					if(min(a.x, b.x)<=x && x<= max(a.x, b.x) && 
						min(a.y, b.y)<=y && y<=max(a.y, b.y) &&
						collinear(a, p, b)) total++;
				} else {
					if(coll){
						if(min(min(a.x, b.x), c.x)<=x && x<= max(max(a.x, b.x), c.x) && 
							min(min(a.y, b.y), c.y)<=y && y<=max(max(a.y, b.y), c.y) &&
							collinear(a, p, b)) total++;
					} else {
						double a1 = area(dist(p, a), dist(p, b), ab);
						a1 += area(dist(p, a), dist(p, c), ac);
						a1 += area(dist(p, b), dist(p, c), bc);
						if(abs(a1-A)<1e-4) total++;
					}
				}
			}
		
		printf("%4d\n", total);
	}
}
