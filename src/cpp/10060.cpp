#include<bits/stdc++.h>

using namespace std;

double x[100100], y[100100];

double cross(int i, int j){
	return x[i]*y[j] - x[j]*y[i];
}

double area(int n){
	double a = 0;
	for(int i=1; i<n; i++)
			a+=cross(i-1, i);
	return abs(a/2);
}

int main(){
	int n;
	double r, t, firstX, firstY;
	while(true){
	    scanf("%d", &n);
		if(n==0) break;
		double pVol = 0;
		for(int i=0; i<n; i++){
			scanf("%lf %lf %lf", &t, &firstX, &firstY);
			int s = 0;
			x[s] = firstX;
			y[s++] = firstY;
			while(true){
				double a, b;
				scanf("%lf %lf", &a, &b);
				x[s] = a;
				y[s++] = b;
				if(a==firstX && b==firstY) break;
			}
			pVol+=area(s)*t;
		}
		scanf("%lf %lf", &r, &t);
		double cVol = M_PI*r*r*t;
		printf("%d\n", (int)(pVol/cVol));
	}
}