

import java.util.Scanner;

public class UVa_11221 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x , a, b, size, c;
        boolean isEqual = true;
        String asdf, trash;
        char[] arr = new char[10000];
        x = sc.nextInt();
        trash = sc.nextLine();
        for(int i=0; i<x; i++){
            asdf = sc.nextLine();
            arr = asdf.toCharArray();
            
            size = arr.length;
            for(a = 0; a < size; a++){
                if(!((arr[a]>='a' && arr[a]<='z') || (arr[a]>='A' && arr[a] <= 'Z'))){
                    for(b = a; b < arr.length-1; b++)
                        arr[b] = arr[b+1];
                    size--;
                    a--;
                }
            }
            
            if(Math.sqrt(size) != Math.floor(Math.sqrt(size))){
                System.out.println("Case #" + (i+1) + ":");
                System.out.println("No magic :(");
            }
            else{
                isEqual = true;
                int sqrtsize = (int)Math.sqrt(size);
                char[] newArr = new char[size];
                for(a=0; a<newArr.length; a++)
                    newArr[a] = arr[a];
                char[][] newArr2 = new char[sqrtsize][sqrtsize];
                c = 0;
                for(a = 0; a<sqrtsize; a++)
                    for(b = 0; b<sqrtsize; b++){
                        newArr2[a][b] = newArr[c];
                        c++;
                    }
                char[] newArr3 = new char[size];
                
                c=0;
                for(a = 0; a<sqrtsize; a++)
                    for(b = 0; b<sqrtsize; b++){
                        newArr3[c] = newArr2[a][b];
                        c++;
                    }
                
                for(c=0; c<size; c++)
                    if(newArr[c] != newArr3[c])
                        isEqual = false;
                
                c=0;
                if(isEqual){
                    for(a = 0; a<sqrtsize; a++)
                        for(b = 0; b<sqrtsize; b++){
                            newArr3[c] = newArr2[b][a];
                            c++;
                        }
                
                    for(c=0; c<size; c++)
                        if(newArr[c] != newArr3[c])
                            isEqual = false;
                }
                
                c=0;
                if(isEqual){
                    for(a = sqrtsize; a>0; a--)
                        for(b = sqrtsize; b>sqrtsize; b--){
                            newArr3[c] = newArr2[b][a];
                            c++;
                        }
                
                    for(c=0; c<size; c++)
                        if(newArr[c] != newArr3[c])
                            isEqual = false;
                }
                
                c=0;
                if(isEqual){
                    for(a = sqrtsize; a>0; a--)
                        for(b = sqrtsize; b>sqrtsize; b--){
                            newArr3[c] = newArr2[a][b];
                            c++;
                        }
                
                    for(c=0; c<size; c++)
                        if(newArr[c] != newArr3[c])
                            isEqual = false;
                }
                System.out.println("Case #" + (i+1) + ":");
                if(isEqual)
                    System.out.println(sqrtsize);
                else
                    System.out.println("No magic :(");
                    
            }
            
        }
    }
}
