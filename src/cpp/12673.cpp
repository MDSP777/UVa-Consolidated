#include<bits/stdc++.h>

using namespace std;

// note: Java version of solution will TLE
int main(){
	int n, g;
	while(scanf("%d %d", &n, &g)!=EOF){
		vector<int> games;
		int total = 0, draws = 0;
		while(n--){
			int w, l;
			scanf("%d %d", &w, &l);
			int need = l-w+1;
			if(w<l) 
				games.push_back(need);
			else if(w==l)
			    draws++;
			else
				total+=3;
		}
		sort(games.begin(), games.end());
		
		// can probably optimize this via min() but am lazy lol
		while(draws>1 && g>0){
		    g--;
		    draws--;
		    total+=3;
		}

		for(int i=0; i<games.size(); i++) {
			int cur = games[i];
			if(g>=cur) {
				g-=cur;
				total+=3;
			} else if(g>=cur-1){
			    if(draws==1 && g>0) {
        		    draws--;
        		    g--;
        		    total+=3;
        		}
        		if(g>=cur-1){
    			    g-=cur-1;
    			    total++;
        		}
			} else break;
		}
		
		if(draws==1 && g>0) {
		    draws--;
		    g--;
		    total+=3;
		}

		printf("%d\n", total+draws);
	}
}
