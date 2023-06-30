#include<bits/stdc++.h>

using namespace std;

long long nod[1000100] = {};
vector<long long> n;

int main() {
	for(int i=1; i<1000100; i++)
		for(int j=i; j<1000100; j+=i)
			nod[j]++;
		
	n.push_back(1);
	for(int i=1; i<1000100; i++){
		long long x = n[i-1]+nod[n[i-1]];
		if(x>1000000) break;
		n.push_back(x);
	}

	int tc, a, b;
	scanf("%d", &tc);
	for(int t=1; t<=tc; t++){
		scanf("%d %d", &a, &b);
		printf("Case %d: %d\n", t, upper_bound(n.begin(), n.end(), b)-n.begin() 
									- (lower_bound(n.begin(), n.end(), a)-n.begin()));
	}
}
