#include<bits/stdc++.h>

using namespace std;

struct point {
	int x, y;

	point(int a, int b) :
		x(a), y(b) {}
};

int cross(point a, point b){
	return a.x*b.y - b.x*a.y;
}

point toVec(point a, point b){
	return point(b.x-a.x, b.y-a.y);
}

int orientation(point a, point b, point c){
	int o = cross(toVec(a, b), toVec(a, c));
	if(o==0) return 0;
	if(o>0) return 1;
	return -1;
}

bool contains(point a, point q, point b){
	int minX = min(a.x, b.x);
	int minY = min(a.y, b.y);
	int maxX = max(a.x, b.x);
	int maxY = max(a.y, b.y);
	return minX<=q.x && q.x<=maxX && minY<=q.y && q.y<=maxY;
}

bool intersects(pair<point, point> l1, pair<point, point> l2){
	int o1 = orientation(l1.first, l1.second, l2.first);
	int o2 = orientation(l1.first, l1.second, l2.second);
	int o3 = orientation(l2.first, l2.second, l1.first);
	int o4 = orientation(l2.first, l2.second, l1.second);

	if(o1!=o2 && o3!=o4) return true;

	if(o1==0 && contains(l1.first, l2.first, l1.second))
		return true;
	if(o2==0 && contains(l1.first, l2.second, l1.second))
		return true;
	if(o3==0 && contains(l2.first, l1.first, l2.second))
		return true;
	if(o4==0 && contains(l2.first, l1.second, l2.second))
		return true;
	return false;
}

int main() {
	int tc, n, x1, y1, x2, y2;
	scanf("%d", &tc);
	while(tc--){
		vector<pair<point, point>> segments;
		scanf("%d", &n);
		for(int i=0; i<n; i++){
			scanf("%d %d %d %d", &x1, &y1, &x2, &y2);
			segments.push_back(pair<point, point>(point(x1, y1), point(x2, y2)));
		}

		int ans = 0;
		for(int i=0; i<n; i++){
			bool has = false;
			for(int j=0; !has && j<n; j++)
				if(i!=j) has |= intersects(segments[i], segments[j]);
			if(!has) ans++;
		}
		printf("%d\n", ans);
	}
}