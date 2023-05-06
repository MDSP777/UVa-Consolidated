#include<bits/stdc++.h>

int arr[1000100];
int left[1000100];
int right[1000100];
int n;
long long inv;

void sort(int l, int r) {
	if(l>=r-1) return;
	
	int m = (l+r)/2;
	sort(l, m);
	sort(m, r);
	
	for(int i=l; i<m; i++) left[i-l] = arr[i];
	for(int i=m; i<r; i++) right[i-m] = arr[i];
	
	int i = 0, j = 0, ctr = l;
	while(i<m-l || j<r-m) {
		if(i==m-l && j<r-m) {
			while(j<r-m) 
				arr[ctr++] = right[j++];
			continue;
		}
		if(j==r-m && i<m-l) {
			while(i<m-l)
				arr[ctr++] = left[i++];
			continue;
		}
		
		if(left[i]<=right[j])
			arr[ctr++] = left[i++];
		else {
			arr[ctr++] = right[j++];
			inv+=m-l-i;
		}
	}
}
	
int main() {
	while(true) {
		scanf("%d", &n);
		if(n==0) break;
		
		for(int i=0; i<n; i++) scanf("%d", &arr[i]);
		inv = 0;
		sort(0, n);
		printf("%lld\n", inv);
	}
}
