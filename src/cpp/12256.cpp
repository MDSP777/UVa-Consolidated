#include<bits/stdc++.h>

using namespace std;

int main(){
	long long ans[70];
	long long a = 1, b = 1, c = 1;
	for(int i=4; i<65; i++){
		ans[i] = a+b+c;
		a = b;
		b = c;
		c = ans[i];
	}

	int n, t = 1;
	while(true){
		scanf("%d", &n);
		if(n==0) break;
		printf("Case %d: %lld\n", t++, ans[n]);
	}
}
