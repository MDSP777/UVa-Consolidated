#include<bits/stdc++.h>

using namespace std;

int x[200200];
int y[200200];

int main(){
	int n, xl, yl;
	while(true){
		scanf("%d", &n);
		if(n==0) break;

		for(int i=0; i<n; i++) scanf("%d %d", &x[i], &y[i]);
		xl = x[n/2];
		yl = y[n/2];

		int a = 0, b = 0;
		for(int i=0; i<n; i++){
			if(x[i]<xl){
				if(y[i]<yl) a++;
				else if(y[i]>yl) b++;
			} else if(x[i]>xl){
				if(y[i]<yl) b++;
				else if(y[i]>yl) a++;
			}
		}

		printf("%d %d\n", a, b);
	}
}
