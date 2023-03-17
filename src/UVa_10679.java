

import java.util.Scanner;

public class UVa_10679 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        sc.nextLine();
        for(int x=0; x<nC; x++){
            String str = sc.nextLine();
            int nQ = sc.nextInt();
            sc.nextLine();
            String rev = new StringBuilder(str).reverse().toString();
            for(int i=0; i<nQ; i++)
                System.out.println(lookForSubstring(rev, new StringBuilder(sc.nextLine()).reverse().toString()));
        }
    }
    
    static char lookForSubstring(String string, String substring){
        int subLength = substring.length();
        int l = string.length()-subLength+1;
        for(int i=0; i<l; i++){
            if(string.substring(i, i+subLength).equals(substring)){
                return 'y';
            }
        }
        return 'n';
    }
}

/*
Couldn't get this code AC in Java, always TLEs.
I did, however, get it AC in C. LOL #LanguageEqualityPls
Accepted C Code:

#include <stdio.h>
#include <string.h>

char lookForSubstring(char str[], char substr[]){
	if(strstr(str, substr)!=NULL) return 'y';
	return 'n';
}

int main(){
	int nC, i, a, b, x, nQ;
	char str[100002];
	char substr[1002];
	char temp;
	scanf("%d", &nC);
	for(x=0; x<nC; x++){
		scanf("%s", str);
		a=0;
		b=strlen(str)-1;
		while(a<b){
			temp = str[a];
			str[a] = str[b];
			str[b] = temp;
			a++;
			b--;
		}
		scanf("%d", &nQ);
		for(i=0; i<nQ; i++){
			scanf("%s", substr);
			a=0;
			b=strlen(substr)-1;
			while(a<b){
				temp = substr[a];
				substr[a] = substr[b];
				substr[b] = temp;
				a++;
				b--;
			}
			printf("%c\n", lookForSubstring(str, substr));
		}
	}
	return 0;
}

*/