

import java.util.Scanner;

public class UVa_706 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            String num = sc.nextInt()+"";
            if(n==0) break;
            StringBuilder[] out = new StringBuilder[2*n+3];
            for(int i=0; i<out.length; i++)
                out[i] = new StringBuilder("");
            for(int i=0; i<num.length(); i++){
                char c = num.charAt(i);
                genChar(out, c, n);
                if(i<num.length()-1)
                    for(int j=0; j<out.length; j++)
                        out[j].append(' ');
            }
            for(int i=0; i<out.length; i++)
                System.out.println(out[i]);
            System.out.println("");
        }
    }
    
    static void genChar(StringBuilder[] out, char c, int n){
        if(c=='1'){
            for(int i=0; i<n+2; i++){
                out[0].append(' ');
                out[n+1].append(' ');
                out[out.length-1].append(' ');
            }
            for(int i=1; i<=n; i++){
                for(int j=0; j<=n; j++){
                    out[i].append(' ');
                    out[i+n+1].append(' ');
                }
                out[i].append('|');
                out[i+n+1].append('|');
            }
        }
        else if(c=='2'){
            out[0].append(' ');
            out[n+1].append(' ');
            out[out.length-1].append(' ');
            for(int i=0; i<n; i++){
                out[0].append('-');
                out[n+1].append('-');
                out[out.length-1].append('-');
            }
            out[0].append(' ');
            out[n+1].append(' ');
            out[out.length-1].append(' ');
            for(int i=1; i<=n; i++){
                for(int j=0; j<=n; j++){
                    out[i].append(' ');
                }
                out[i].append('|');
            }
            for(int i=1; i<=n; i++){
                out[i+n+1].append('|');
                for(int j=0; j<=n; j++){
                    out[i+n+1].append(' ');
                }
            }
        }
        else if(c=='3'){
            out[0].append(' ');
            out[n+1].append(' ');
            out[out.length-1].append(' ');
            for(int i=0; i<n; i++){
                out[0].append('-');
                out[n+1].append('-');
                out[out.length-1].append('-');
            }
            out[0].append(' ');
            out[n+1].append(' ');
            out[out.length-1].append(' ');
            for(int i=1; i<=n; i++){
                for(int j=0; j<=n; j++){
                    out[i].append(' ');
                    out[i+n+1].append(' ');
                }
                out[i].append('|');
                out[i+n+1].append('|');
            }
        }
        else if(c=='4'){
            for(int i=0; i<n+2; i++){
                out[0].append(' ');
                out[out.length-1].append(' ');
            }
            out[n+1].append(' ');
            for(int i=0; i<n; i++){
                out[n+1].append('-');
            }
            out[n+1].append(' ');
            for(int i=1; i<=n; i++){
                out[i].append('|');
                for(int j=0; j<n; j++){
                    out[i].append(' ');
                }
                out[i].append('|');
            }
            for(int i=1; i<=n; i++){
                for(int j=0; j<=n; j++){
                    out[i+n+1].append(' ');
                }
                out[i+n+1].append('|');
            }
        }
        else if(c=='5'){
            out[0].append(' ');
            out[n+1].append(' ');
            out[out.length-1].append(' ');
            for(int i=0; i<n; i++){
                out[0].append('-');
                out[n+1].append('-');
                out[out.length-1].append('-');
            }
            out[0].append(' ');
            out[n+1].append(' ');
            out[out.length-1].append(' ');
            for(int i=1; i<=n; i++){
                out[i].append('|');
                for(int j=0; j<=n; j++){
                    out[i].append(' ');
                }
            }
            for(int i=1; i<=n; i++){
                for(int j=0; j<=n; j++){
                    out[i+n+1].append(' ');
                }
                out[i+n+1].append('|');
            }
        }
        else if(c=='6'){
            out[0].append(' ');
            out[n+1].append(' ');
            out[out.length-1].append(' ');
            for(int i=0; i<n; i++){
                out[0].append('-');
                out[n+1].append('-');
                out[out.length-1].append('-');
            }
            out[0].append(' ');
            out[n+1].append(' ');
            out[out.length-1].append(' ');
            for(int i=1; i<=n; i++){
                out[i].append('|');
                for(int j=0; j<=n; j++){
                    out[i].append(' ');
                }
            }
            for(int i=1; i<=n; i++){
                out[i+n+1].append('|');
                for(int j=0; j<n; j++){
                    out[i+n+1].append(' ');
                }
                out[i+n+1].append('|');
            }
        }
        else if(c=='7'){
            out[0].append(' ');
            for(int i=0; i<n; i++){
                out[0].append('-');
            }
            out[0].append(' ');
            for(int i=0; i<n+2; i++){
                out[n+1].append(' ');
                out[out.length-1].append(' ');
            }
            for(int i=1; i<=n; i++){
                for(int j=0; j<=n; j++){
                    out[i].append(' ');
                    out[i+n+1].append(' ');
                }
                out[i].append('|');
                out[i+n+1].append('|');
            }
        }
        else if(c=='8'){
            out[0].append(' ');
            out[n+1].append(' ');
            out[out.length-1].append(' ');
            for(int i=0; i<n; i++){
                out[0].append('-');
                out[n+1].append('-');
                out[out.length-1].append('-');
            }
            out[0].append(' ');
            out[n+1].append(' ');
            out[out.length-1].append(' ');
            for(int i=1; i<=n; i++){
                out[i].append('|');
                out[i+n+1].append('|');
                for(int j=0; j<n; j++){
                    out[i].append(' ');
                    out[i+n+1].append(' ');
                }
                out[i].append('|');
                out[i+n+1].append('|');
            }
        }
        else if(c=='9'){
            out[0].append(' ');
            out[n+1].append(' ');
            out[out.length-1].append(' ');
            for(int i=0; i<n; i++){
                out[0].append('-');
                out[n+1].append('-');
                out[out.length-1].append('-');
            }
            out[0].append(' ');
            out[n+1].append(' ');
            out[out.length-1].append(' ');
            for(int i=1; i<=n; i++){
                out[i].append('|');
                for(int j=0; j<n; j++){
                    out[i].append(' ');
                }
                out[i].append('|');
            }
            for(int i=1; i<=n; i++){
                for(int j=0; j<=n; j++){
                    out[i+n+1].append(' ');
                }
                out[i+n+1].append('|');
            }
        }
        else if(c=='0'){
            out[0].append(' ');
            out[out.length-1].append(' ');
            for(int i=0; i<n; i++){
                out[0].append('-');
                out[out.length-1].append('-');
            }
            out[0].append(' ');
            out[out.length-1].append(' ');
            for(int i=0; i<n+2; i++){
                out[n+1].append(' ');
            }
            for(int i=1; i<=n; i++){
                out[i].append('|');
                out[i+n+1].append('|');
                for(int j=0; j<n; j++){
                    out[i].append(' ');
                    out[i+n+1].append(' ');
                }
                out[i].append('|');
                out[i+n+1].append('|');
            }
        }
    }
}
