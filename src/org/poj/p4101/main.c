#include <stdio.h>
#include <stdlib.h>
#include <memory.h>
#define LENGTH 10000

// ·½Ïò 
int d[4][2] = {
    {1, 0},
    {-1, 0},
    {0, 1},
    {0, -1}
};
char map[35][35];

void clean(char c, int x, int y){
    int i;
    map[x][y] = '#';
    for(i = 0; i < 4; i++){
        int k = x + d[i][0];
        int b = y + d[i][1];
        if(map[k][b] == c){
            clean(c, k, b);
        }
    }
}

int main(){
    int s, n;
    int x, y;
    scanf("%d", &n);
    while(n--){
        int numb = 0;
        int numr = 0;
        scanf("%d", &s);
        getchar();
        for(x = 0; x < s; x++){
            for(y = 0; y < s; y++){
                scanf("%c", &map[x][y]);
            }
            getchar();
        }
        
        for(x = 0; x < s; x++){
            for(y = 0; y < s; y++){
                if(map[x][y] == 'b'){
                    clean('b', x, y);
                    numb++;
                }
                if(map[x][y] == 'r'){
                    clean('r', x, y);
                    numr++;
                }
            }
        }
    
        printf("%d %d\n", numr, numb);
    }
    return 0;
}
