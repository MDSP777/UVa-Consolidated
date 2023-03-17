import java.util.Scanner;

public class UVa_12482 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int nWords = sc.nextInt();
            int nLinesPerPage = sc.nextInt();
            int nCharsPerLine = sc.nextInt();
            if(nWords==0 && nLinesPerPage==0 && nCharsPerLine==0) break;
            int nPages = 1;
            int curLine = 1;
            int curChar = 0;
            for(int i=0; i<nWords; i++){
                String cur = sc.next();
                if(curChar==0){
                    curChar+=cur.length();
                } else {
                    if(1+curChar+cur.length()<=nCharsPerLine){
                        curChar+=cur.length()+1;
                    } else {
                        curChar = 0;
                        curLine++;
                        if(curLine>nLinesPerPage){
                            curLine = 1;
                            nPages++;
                        }
                        curChar+=cur.length();
                    }
                }
            }
            System.out.println(nPages);
        }
    }
}