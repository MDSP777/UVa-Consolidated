

import java.util.Scanner;

public class UVa_1586 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nC = sc.nextInt();
        sc.nextLine();
        for(int x=0; x<nC; x++){
            int nc = 0;
            int nh = 0;
            int no = 0;
            int nn = 0;
            String in = sc.nextLine();
            for(int i=0; i<in.length(); i++){
                try{
                    if(in.charAt(i)=='C'){
                        String num = "";
                        if(i<in.length()-1 && in.charAt(i+1) <= 57 && in.charAt(i+1)>=48){
                            num += in.charAt(i+1);
                            i++;
                            if(i<in.length()-1 && in.charAt(i+1)>=48 && in.charAt(i+1)<=57){
                                num+= in.charAt(i+1);
                                i++;
                            }
                            nc += new Integer(num);
                        }
                        else nc++;
                    }
                    else if(in.charAt(i)=='H'){
                        String num = "";
                        if(i<in.length()-1 && in.charAt(i+1) <= 57 && in.charAt(i+1)>=48){
                            num += in.charAt(i+1);
                            i++;
                            if(i<in.length()-1 && in.charAt(i+1)>=48 && in.charAt(i+1)<=57){
                                num+= in.charAt(i+1);
                                i++;
                            }
                            nh += new Integer(num);
                        }
                        else nh++;
                    }
                    else if(in.charAt(i)=='O'){
                        String num = "";
                        if(i<in.length()-1 && in.charAt(i+1) <= 57 && in.charAt(i+1)>=48){
                            num += in.charAt(i+1);
                            i++;
                            if(i<in.length()-1 && in.charAt(i+1)>=48 && in.charAt(i+1)<=57){
                                num+= in.charAt(i+1);
                                i++;
                            }
                            no += new Integer(num);
                        }
                        else no++;
                    }
                    else if(in.charAt(i)=='N'){
                        String num = "";
                        if(i<in.length()-1 && in.charAt(i+1) <= 57 && in.charAt(i+1)>=48){
                            num += in.charAt(i+1);
                            i++;
                            if(i<in.length()-1 && in.charAt(i+1)>=48 && in.charAt(i+1)<=57){
                                num+= in.charAt(i+1);
                                i++;
                            }
                            nn += new Integer(num);
                        }
                        else nn++;
                    }
                }catch(Exception e){}
            }
            System.out.printf("%.3f\n", nc*12.01+nh*1.008+no*16+nn*14.01);
        }
    }
}
