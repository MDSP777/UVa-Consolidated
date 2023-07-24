#include<bits/stdc++.h>

using namespace std;

int main(){
    int n, m;
    while(scanf("%d %d", &n, &m)!=EOF){
        m+=n;
        double initialGap = 360.0/n, targetGap = 360.0/m, total = 0;
        set<double> locs;
        for(int i=1; i<m; i++) locs.emplace(i*targetGap);

        for(int i=1; i<n; i++){
            double theta = initialGap*i;
            set<double>::iterator it = locs.lower_bound(theta);
            double ceil = *it;
            if(abs(theta-ceil)<1e-9) continue;

            it--;
            double floor = *it;
            double mov = min(abs(theta-floor), abs(theta-ceil))/360;
            total+=mov*10000;
        }

        printf("%.4lf\n", total);
    }
}
