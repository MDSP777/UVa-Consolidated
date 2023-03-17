#include <iostream>

using namespace std;

bool can(int k, int arr[], int n){
    int cur = 0;
    for(int i=0; i<n; i++){
        if(arr[i]-cur>k) return false;
        if(arr[i]-cur==k) k--;
        cur = arr[i];
    }
    return true;
}

int main(){
    int tc, n;
    int arr[100100];
    scanf("%d", &tc);
    for(int t=1; t<=tc; t++){
        scanf("%d", &n);
        int left = 1, right = 0;
        for(int i=0; i<n; i++){
            scanf("%d", &arr[i]);
            right = max(right, arr[i]);
        }
        while(right-left>1){
            int mid = (right+left)/2;
            if(can(mid, arr, n)) right = mid;
            else left = mid+1;
        }
        printf("Case %d: %d\n", t, can(left, arr, n) ? left : right);
    }
}