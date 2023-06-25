#include<bits/stdc++.h>

using namespace std;

struct point {
	int x, y, z;

	point(int a, int b, int c) :
		x(a), y(b), z(c) {}
};

double dist(point a, point b){
	int xDiff = a.x-b.x;
	int yDiff = a.y-b.y;
	int zDiff = a.z-b.z;

	return sqrt(xDiff*xDiff + yDiff*yDiff + zDiff*zDiff);
}

int main(){
	double f, b, v;
	int n, tc = 1;
	while(true){
		scanf("%lf %lf %lf %d", &f, &b, &v, &n);
		if(f==0) break;

		vector<point> points;
		points.push_back(point(0, 0, 1));
		for(int i=0; i<n; i++){
			int x, y, z;
			scanf("%d %d %d", &x, &y, &z);
			points.push_back(point(x, y, z));
		}
		n++;

		double r = f/b;
		double d = 0;
		point cur = points[0];
		bool visited[25] = {};
		visited[0] = true;
		for(int q=1; q<n; q++) {
			double nearest = 1000000;
			int nearestIdx = -1;
			for(int i=1; i<n; i++)
				if(!visited[i] && dist(cur, points[i])<nearest){
					nearest = dist(cur, points[i]);
					nearestIdx = i;
				}
			cur = points[nearestIdx];
			visited[nearestIdx] = true;
			d+=nearest;
		}

		double t = d/v;
		if(r<t) printf("Mission %d: FAILURE!! Traveled: %.2lf  From Home: %.2lf\n", tc++, r*v, d-r*v);
		else printf("Mission %d: SUCCESS!! Time: %.2lf  Traveled: %.2lf  Fuel Left: %.2lf\n", tc++, t, d, f-b*t);
	}	
}
