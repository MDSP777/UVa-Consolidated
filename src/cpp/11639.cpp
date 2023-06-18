#include<bits/stdc++.h>

using namespace std;

struct point {
	int x, y;
};

int area(point ll, point ur){
	return (ur.x-ll.x)*(ur.y-ll.y);
}

int main() {
	int tc;
	scanf("%d", &tc);
	for(int t=1; t<=tc; t++){
		point ll1, ll2, ur1, ur2;
		scanf("%d %d %d %d %d %d %d %d", 
			&ll1.x, &ll1.y, &ur1.x, &ur1.y, &ll2.x, &ll2.y, &ur2.x, &ur2.y);
		point maxLL, minUR;
		maxLL.x = max(ll1.x, ll2.x);
		maxLL.y = max(ll1.y, ll2.y);
		minUR.x = min(ur1.x, ur2.x);
		minUR.y = min(ur1.y, ur2.y);
		int total = area(ll1, ur1) + area(ll2, ur2);
		int inter = (maxLL.x > minUR.x || maxLL.y > minUR.y) ? 0 : area(maxLL, minUR);
		printf("Night %d: %d %d %d\n", t, inter, total-inter*2, 10000-total+inter);
	}
}
