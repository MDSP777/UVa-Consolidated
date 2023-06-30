#include<bits/stdc++.h>

using namespace std;

int main(){
    int tc;
    scanf("%d", &tc);
    while(tc--){
        vector<int> t;
        for(int i=0; i<3; i++){
            int x;
            scanf("%d", &x);
            t.push_back(x);
        }
        sort(t.begin(), t.end());
        printf("%s\n", t[2]>=t[1]+t[0] ? "Wrong!!" : "OK");
    }
}
