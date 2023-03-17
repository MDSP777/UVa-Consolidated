#include<bits/stdc++.h>
using namespace std;

#include<bits/extc++.h>
using namespace __gnu_pbds;
typedef tree<int, null_type, less<int>, rb_tree_tag, tree_order_statistics_node_update> ost;

int actual[100100];

int main(){
    int tc;
    scanf("%d", &tc);
    while(tc--){
        int n, m;
        scanf("%d %d", &n, &m);
        ost tree;
        for(int i=0; i<n; i++) {
            tree.insert(i);
            actual[i] = i;
        }
        int idx = -1;
        bool first = true;
        while(m--){
            int x;
            scanf("%d", &x);
            x--;
            int i = actual[x];
            if(!first) printf(" %d", tree.order_of_key(i));
            else printf("%d", tree.order_of_key(i));
            tree.erase(tree.lower_bound(i));
            tree.insert(idx);
            actual[x] = idx--;
            first = false;
        }
        printf("\n");
    }
}
