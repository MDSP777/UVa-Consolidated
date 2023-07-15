#include<bits/stdc++.h>

using namespace std;

double sides[10100];

double area(double a, double b, double c){
	if(c-a-b>=-1e-9) return 0;

	double s = (a+b+c)/2;
	return sqrt(s*(s-a)*(s-b)*(s-c));
}

int main() {
	int tc, n;
	scanf("%d", &tc);
	while(tc--){
		scanf("%d", &n);

		double best = 0;
		for(int i=0; i<n; i++)
			scanf("%lf", &sides[i]);
		sort(sides, sides+n);
		for(int i=2; i<n; i++)
			best = max(best, area(sides[i-2], sides[i-1], sides[i]));

		printf("%.2lf\n", best);
	}
}
