#include<bits/stdc++.h>

using namespace std;

int main(){
    int tc, n;
    scanf("%d", &tc);
    for(int t=1; t<=tc; t++){
        scanf("%d", &n);
        int maxLLx = -100000000, maxLLy = -100000000;
        int minURx = 100000000, minURy = 100000000;
        while(n--){
            int llx, lly, urx, ury;
            scanf("%d %d %d %d", &llx, &lly, &urx, &ury);
            maxLLx = max(maxLLx, llx);
            maxLLy = max(maxLLy, lly);
            minURx = min(minURx, urx);
            minURy = min(minURy, ury);
        }
        int xDiff = minURx-maxLLx;
        int yDiff = minURy-maxLLy;
        int ans = (xDiff<0 || yDiff<0) ? 0 : xDiff*yDiff;
        printf("Case %d: %d\n", t, ans);
    }
}