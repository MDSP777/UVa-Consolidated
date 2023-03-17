

import java.util.Scanner;

public class UVa_507 {
    static int[] terms;
    static int start, end;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        for(int x=1; x<=nC; x++){
            int nRoutes = sc.nextInt()-1;
            terms = new int[nRoutes]; 
            for(int i=0; i<nRoutes; i++){
                terms[i] = sc.nextInt();
            }
            if(kadane()<0) System.out.println("Route "+x+" has no nice parts");
            else System.out.println("The nicest part of route "+x+" is between stops "+(start+1)+" and "+(end+2));
        }
    }
 
//  Kadane's Algorithm
    static int kadane(){
        int max = Integer.MIN_VALUE;
        start = 0;
        end = 0;
        int tempMax = 0;
        int curStart = 0;
        for(int i=0; i<terms.length; i++){
            tempMax+=terms[i];
            if(tempMax>max || (tempMax==max && start == curStart && i>end)){
                max = tempMax;
                start = curStart;
                end = i;
            }
            if(tempMax<0){
                tempMax = 0;
                curStart = i+1;
            }
        }
        return max;
    }
}

/*
Edit: Java code revised using Kadane's Algorithm. Java code AC now.
Java code TLEs. C code AC:
#include <stdio.h>

int terms[20000];
int start, end, length, tempLength;
int nRoutes;

int dp(int index, int total2, int temptempLength){
	int best = total2;
    int remove = 0;
    int offset = 0;
    int i;
    tempLength = temptempLength;
    for(i=nRoutes-1; i>=index; i--){
        offset++;
        remove+=terms[i];
        if(total2-remove>best){
            tempLength = temptempLength-offset;
            best = total2-remove;
        }
    }
    return best;
}

int main(){
	int nC, x, i, best, tempBest, tempRoutes, max=0, tempMax;
	scanf("%d", &nC);
	for(x=1; x<=nC; x++){
		max = 0;
		scanf("%d", &nRoutes);
		nRoutes--;
		tempRoutes = nRoutes;
		for(i=0; i<nRoutes; i++){
			scanf("%d", &terms[i]);
			max+=terms[i];	
		} 
		tempMax = max;
		best = -10000;
		tempLength = -10000;
		best = dp(0, max, tempRoutes);
		start = 1;
		end = tempLength+1;
		length = tempLength;
		tempRoutes--;
		tempMax-=terms[0];
		for(i=1; i<nRoutes; i++){
			if(tempMax<=max){
				tempMax-=terms[i];
				tempRoutes--;
				continue;
			}
			max = tempMax;
			tempBest = dp(i, tempMax, tempRoutes);
			if(tempBest>best || (tempBest==best && tempLength>length)){
				best = tempBest;
				length = tempLength;
				start = i+1;
				end = start+length;
			}
			tempRoutes--;
			max = tempMax;
			tempMax-=terms[i];
		}
		if(best<0 || start==end) printf("Route %d has no nice parts\n", x);
		else printf("The nicest part of route %d is between stops %d and %d\n", x, start, end);
	}
	return 0;
}

*/
