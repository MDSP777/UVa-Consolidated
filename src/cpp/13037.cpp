#include<bits/stdc++.h>

using namespace std;

unordered_map<int, unordered_set<int>> m;

int main(){
    int tc, l, r, s;
    scanf("%d", &tc);
    for(int t=1; t<=tc; t++){
        m.clear();
        scanf("%d %d %d", &l, &r, &s);
        int c;
        for(int i=0; i<l; i++){
            scanf("%d", &c);
            m[c].insert(0);
        }
        for(int i=0; i<r; i++){
            scanf("%d", &c);
            m[c].insert(1);
        }
        for(int i=0; i<s; i++){
            scanf("%d", &c);
            m[c].insert(2);
        }
        
        printf("Case #%d:\n", t);
        for(int i=0; i<3; i++){
            int a = 0, b = 0;
            for(auto x : m){
                if(x.second.size()==1 && x.second.find(i) != x.second.end()) a++;
                if(x.second.size()==2 && x.second.find(i) == x.second.end()) b++;
            }
            printf("%d %d\n", a, b);
        }
    }
}