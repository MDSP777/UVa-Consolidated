#include<bits/stdc++.h>

int terms[100100];
int st[400100];
int shifts[1000];
int n;

using namespace std;

void build(int p, int l, int r) {
	if(l==r) st[p] = terms[l];
	else {
		int mid = (l+r)/2;
		build(p<<1, l, mid);
		build((p<<1)+1, mid+1, r);
		st[p] = min(st[p<<1], st[(p<<1)+1]);
	}
}

void update(int p, int l, int r, int index, int val) {
	if(l==r && l==index) st[p] = val;
	else {
		int mid = (l+r)/2;
		if(l<=index && index<=mid) update(p<<1, l, mid, index, val);
		else update((p<<1)+1, mid+1, r, index, val);
		st[p] = min(st[p<<1], st[(p<<1)+1]);
	}
}

void update(int index, int val) {
	terms[index] = val;
	update(1, 0, n-1, index, val);
}

int rmq(int p, int l, int r, int i, int j) {
	if(i>r || j<l) return 99999999;
	if(i<=l && r<=j) return st[p];
	int mid = (l+r)/2;
	return min(rmq(p<<1, l, mid, i, j), rmq((p<<1)+1, mid+1, r, i, j));
}

int rmq(int i, int j) {
	return rmq(1, 0, n-1, i, j);
}

int main() {
	int q, l, r, shiftLen;
	char dump;
	char str[1000];
	scanf("%d %d", &n, &q);
	
	for(int i=0; i<n; i++) scanf("%d\n", &terms[i]);
	build(1, 0, n-1);
	
	while(q--) {
		scanf("%[^(]s", str);
		scanf("%c", &dump);
		
		if(str[0]=='q') {
			scanf("%[^,]s", str);
			scanf("%c", &dump);
			l = stoi(str);
			scanf("%[^)]s%c", str);
			scanf("%c", &dump);
			r = stoi(str);
			printf("%d\n", rmq(l-1, r-1));
		} else {
			shiftLen = 0;
			do{
				scanf("%[^,)]s", str);
				scanf("%c", &dump);
				shifts[shiftLen++] = stoi(str)-1;
			}while(dump!=')');
			
			int temp = terms[shifts[0]];
			for(int i=1; i<shiftLen; i++) 
				update(shifts[i-1], terms[shifts[i]]);
			
			update(shifts[shiftLen-1], temp);
		}
		scanf("%c", &dump);
	}
}
