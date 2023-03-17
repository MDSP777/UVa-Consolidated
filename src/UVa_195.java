

import java.util.HashSet;
import java.util.Scanner;

public class UVa_195 {
    static HashSet<String> s;
    static int[] newCode;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        sc.nextLine();
        StringBuilder out = new StringBuilder("");
        
        newCode = new int[255];
        for(int i='A'; i<='Z'; i++){
            newCode[i] = i*2;
            newCode[i+32] = i*2+1;
        }
        for(int x=0; x<nC; x++){
            s = new HashSet();
            String c = sc.nextLine();
            int inputLength = c.length();
            boolean[ ] used = new boolean[ inputLength ];
            StringBuffer outputString = new StringBuffer();
            char[ ] in = c.toCharArray();

            permute ( in, outputString, used, inputLength, 0 );
            String[] a = new String[s.size()];
            System.out.println(s.size());
            int index=0;
            for(String str: s){
                a[index] = str;
                index++;
            }
            sort(a);
            for(int i=0; i<a.length; i++)
                out.append(a[i]+"\n");
        }
        System.out.print(out);
    }
    
    static void sort(String[] a){
        for(int i=0; i<a.length; i++)
            for(int j=0; j<a.length-i-1; j++)
                if(compare(a[j], a[j+1])==1){
                    String temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
    }
    
    static void permute ( char[ ] in, StringBuffer outputString, 
                    boolean[ ] used, int inputLength, int level)
    {
       if( level == inputLength) {
       s.add(outputString.toString()); 
       return;
       }

      for( int i = 0; i < inputLength; ++i )
      {       

         if( used[i] ) continue;

         outputString.append( in[i] );      
         used[i] = true;       
         permute( in,   outputString, used, inputLength, level + 1 );       
         used[i] = false;       
           outputString.setLength(   outputString.length() - 1 );   
      }
    }
    
    static int compare(String a, String b){
        if(a.equals(b)) return 0;
        int l = a.length();
        for(int i=0; i<l; i++)
            if(a.charAt(i)!=b.charAt(i))
                if(newCode[a.charAt(i)]>newCode[b.charAt(i)]) return 1;
                else return -1;
        return 0;
    }
}
