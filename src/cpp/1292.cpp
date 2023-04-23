#include<bits/stdc++.h>

using namespace std;

vector<int> e[2000];
bool visited[2000];
int memo[2000][2];

int mvc(int cur, int taken){
	if(memo[cur][taken]!=-1) return memo[cur][taken];

	visited[cur] = true;
	int ans = taken;
	for(int next : e[cur]){
		if(!visited[next]){
			if(taken==0) ans+=mvc(next, 1);
			else ans+=min(mvc(next, 0), mvc(next, 1));
		}
	}
	visited[cur] = false;
	return memo[cur][taken] = ans;
}

int main() {
	int n;
	while(scanf("%d", &n)==1){
		for(int i=0; i<n; i++){
			e[i].clear();
			visited[i] = false;
			memo[i][0] = memo[i][1] = -1;
		}
		
		for(int i=0; i<n; i++){
			int src, num;
			scanf("%d:(%d)", &src, &num);
			while(num--){
				int dest;
				scanf("%d", &dest);
				e[src].push_back(dest);
				e[dest].push_back(src);
			}			
		}
		
		printf("%d\n", min(mvc(0, 0), mvc(0, 1)));
	}
}
