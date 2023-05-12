#include<bits/stdc++.h>

using namespace std;

struct Node {
    bool isWord;
    Node* next[26];
};

char str[300100];
char s[200];
int memo[300100];

int main(){
    int d, tc = 1, MOD = 20071027;

    while(scanf("%s", str)!=EOF){
        scanf("%d", &d);
        Node* t = new Node();
        while(d--){
            scanf("%s", s);
            Node* cur = t;
            int l = strlen(s);
            for(int i=0; i<l; i++){
                char c = s[i];
                if(!cur->next[c-'a'])
                    cur->next[c-'a'] = new Node();
                
                if(i==l-1)
                    cur->next[c-'a']->isWord = true;
                cur = cur->next[c-'a'];
            }
        }

        int l = strlen(str);
        for(int i=l-1; i>=0; i--){
            memo[i] = 0;
            Node* cur = t;
            for(int j=i; j<i+100 && j<l; j++){
                if(!cur->next[str[j]-'a']) break;
                cur = cur->next[str[j]-'a'];
                if(cur->isWord){
                    memo[i]+= j+1>=l ? 1 : memo[j+1];
                    memo[i]%=MOD;
                }
            }
        }

        printf("Case %d: %d\n", tc++, memo[0]%MOD);
    }
}
