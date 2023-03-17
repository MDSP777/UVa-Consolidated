#include <iostream>

void parse(char grid[5][500], int n){
    for(int i=0; i<n; i++){
        int start = 4*i;
        if(grid[0][start]=='.') printf("1");
        else if(grid[3][start]=='*') printf("2");
        else printf("3");
    }  
    printf("\n");
}

int main(){
    int n;
    char dump;
    scanf("%d%c", &n, &dump);
    char grid[5][500];
    for(int i=0; i<5; i++){
        for(int j=0; j<4*n; j++){
            scanf("%c", &grid[i][j]);
        }
        scanf("%c", &dump);
    }
    parse(grid, n);
    return 0;
}
