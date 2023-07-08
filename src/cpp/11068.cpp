#include<bits/stdc++.h>

using namespace std;

struct line {
	double a, b, c;

	line(double x, double y, double z) :
		a(x), b(y), c(z) {}

};

int main() {
    double eps = 1e-9;
	while(1){
		double a1, b1, c1, a2, b2, c2;
		scanf("%lf %lf %lf %lf %lf %lf", &a1, &b1, &c1, &a2, &b2, &c2);
		if(a1==0 && b1==0 && c1==0 && a2==0 && b2==0 && c2==0) break;
		
		line l1 = b1==0 ? line(a1, 0, -c1) : line(a1/b1, 1, -c1/b1);
		line l2 = b2==0 ? line(a2, 0, -c2) : line(a2/b2, 1, -c2/b2);

		if(abs(l1.a-l2.a)<eps && abs(l1.b-l2.b)<eps) {
			printf("No fixed point exists.\n");
		} else {
			double x = (l2.b*l1.c - l1.b*l2.c) / (l2.a*l1.b - l1.a*l2.b), y;

			if (fabs(l1.b) > eps) y = -(l1.a*x + l1.c);
			else y = -(l2.a*x + l2.c);

			if(abs(x)<eps) x = 0;
			if(abs(y)<eps) y = 0;

			printf("The fixed point is at %.2lf %.2lf.\n", x, y);
		}
	}
}
