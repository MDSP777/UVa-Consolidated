#include <iostream>
using namespace std;
 
int main() {
	int p, r, s;
	int score[550];
	while(scanf("%d", &p)==1){
		scanf("%d", &r);
		for(int i=0; i<p; i++) score[i] = 0;
 
		for(int i=0; i<r; i++)
			for(int j=0; j<p; j++){
				scanf("%d", &s);
				score[j]+=s;
			}
 
		int winner = -1, max = -1;
		for(int i=0; i<p; i++)
			if(score[i]>=max) {
				max = score[i];
				winner = i+1;
			}
		printf("%d\n", winner);
	}
}