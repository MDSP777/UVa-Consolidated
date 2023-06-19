#include<bits/stdc++.h>

using namespace std;

int main(){
	int tc, n;
	scanf("%d", &tc);
	while(tc--){
		scanf("%d", &n);
		map<double, double> map;
		for(int i=0; i<n; i++){
			double x1, y1, x2, y2, mul;
			scanf("%lf %lf %lf %lf %lf", &x1, &y1, &x2, &y2, &mul);
			if(x1>x2){
				double temp = x1;
				x1 = x2;
				x2 = temp;
			}
			map[x1] = mul;
			map[x2] = 1/mul;
		}

		printf("%d\n", n*2+1);
		double tr = 1;
		printf("-inf %.3lf 1.000\n", map.begin()->first);
		for(std::map<double, double>::iterator itr=map.begin(); itr!=map.end(); itr++){
			tr*=itr->second;
			std::map<double, double>::iterator right = itr;
			right++;
			if(right==map.end())
		        printf("%.3lf +inf 1.000\n", map.rbegin()->first);
	        else
    			printf("%.3lf %.3lf %.3lf\n", itr->first, right->first, tr);
		}
		if(tc>0) printf("\n");
	}
}