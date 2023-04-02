#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

struct Point {
	int x, y;
	
	Point(int a, int b){
		x = a;
		y = b;
	}
};

void rotateLeft(Point* p){
	int temp = p->x;
	p->x = -(p->y);
	p->y = temp;
}

bool equals(Point a, Point b){
	return a.x==b.x && a.y==b.y;
}

bool comp(const Point& lhs, const Point& rhs) {
   if(lhs.x==rhs.x) return lhs.y < rhs.y;
   return lhs.x < rhs.x;
}

int main() {
	int tc;
	scanf("%d", &tc);
	while(tc--){
		int n;
		scanf("%d", &n);
		vector<Point> expected;
		int minX = 100000000, minY = 1000000000;
		for(int i=0; i<n; i++){
			int x, y;
			scanf("%d %d", &x, &y);
			expected.push_back(Point(x, y));
			minX = min(minX, x);
			minY = min(minY, y);
		}
		for(int i=0; i<n; i++){
			expected[i].x-=minX;
			expected[i].y-=minY;
		}
		sort(expected.begin(), expected.end(), &comp);

		minX = 1000000000;
		minY = 1000000000;
		vector<Point> actual;
		for(int i=0; i<n; i++) {
			int x, y;
			scanf("%d %d", &x, &y);
			actual.push_back(Point(x, y));
			minX = min(minX, x);
			minY = min(minY, y);
		}
		bool matches = false;
		bool hasAll = true;
		for(int i=0; i<n; i++){
			actual[i].x-=minX;
			actual[i].y-=minY;
		}
		sort(actual.begin(), actual.end(), &comp);

		for(int i=0; hasAll && i<n; i++) 
			hasAll&=equals(expected[i], actual[i]);
		matches|=hasAll;

		for(int q=0; !matches && q<3; q++) {
			hasAll = true;
			minX = 1000000000;
			minY = 1000000000;
			for(int i=0; i<n; i++) {
				rotateLeft(&actual[i]);
				minX = min(minX, actual[i].x);
				minY = min(minY, actual[i].y);
			}
			for(int i=0; i<n; i++) {
				actual[i].x-=minX;
				actual[i].y-=minY;
			}
			sort(actual.begin(), actual.end(), &comp);

			for(int i=0; hasAll && i<n; i++) 
				hasAll&=equals(expected[i], actual[i]);
			matches|=hasAll;
		}

		printf("%s\n", matches ? "MATCHED" : "NOT MATCHED");
	}
	return 0;
}
