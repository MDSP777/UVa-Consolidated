#include<bits/stdc++.h>

using namespace std;

// reverse-engineer formula for area of a regular polygon
// https://www.wikihow.com/Find-the-Area-of-Regular-Polygons
int main() {
	int t = 1, n;
	double A;
	while(1){
		scanf("%d %lf", &n, &A);
		if(n<3) break;
		double s = sqrt((4*A*tan(M_PI/n))/n);
		double h = s/(2*tan(M_PI/n));
		double r = sqrt((s/2*s/2)+h*h);
		
		printf("Case %d: %.5f %.5f\n", t++, M_PI*r*r-A, A-M_PI*h*h);
	}
}
