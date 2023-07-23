#include<bits/stdc++.h>

using namespace std;

void solve(double h, double w, bool& grid, int& max){

	double r = sqrt(3), diff = 1+sqrt(3)/2 - sqrt(3);
	grid = true;
	max = (int)h*(int)w;
	if(h<1 || w<1) return;

	int skew2Rows = (int)(h/r);
	if(skew2Rows*r+diff>h) skew2Rows--;

	int skew2Cols = (int)(w)*2-1;
	if(w-(int)w>=0.5) skew2Cols++;

	int skewMax = skew2Rows*skew2Cols;
	if(h-r*skew2Rows>=1) skewMax+=w;

	if(skewMax>max){
		max = skewMax;
		grid = false;
	}
}

int main(){
	double h, w;
	while(scanf("%lf %lf", &h, &w)!=EOF){
		bool grid1, grid2;
		int max1, max2;

		solve(h, w, grid1, max1);
		solve(w, h, grid2, max2);

		if(max2>max1){
			max1 = max2;
			grid1 = grid2;
		}

		printf("%d %s\n", max1, grid1 ? "grid" : "skew");
	}
}
