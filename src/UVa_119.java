

import java.util.Scanner;

public class UVa_119 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        do{
            int nNames = sc.nextInt();
            Person[] p = new Person[nNames];
            for(int i=0; i<nNames; i++)
                p[i] = new Person(sc.next());
            for(int i=0; i<nNames; i++){
                String name = sc.next();
                Person cur = null;
                for(int j=0; j<nNames; j++)
                    if(p[j].name.equals(name)){
                        cur = p[j];
                        break;
                    }
                int spent = sc.nextInt();
                int nGive = sc.nextInt();
                for(int j=0; j<nGive; j++){
                    String curGive = sc.next();
                    for(int k=0; k<nNames; k++)
                        if(p[k].name.equals(curGive)){
                            p[k].money += spent/nGive;
                            break;
                        }
                }
                if(nGive!=0){
                    cur.money += (spent%nGive);
                    cur.money -= spent;
                }
            }
            for(int i=0; i<nNames; i++)
                System.out.println(p[i].name+" "+p[i].money);
            if(sc.hasNext()) System.out.println("");
        }while(sc.hasNext());
    }
    
    static class Person{
        String name;
        int money;
        
        public Person(String n){
            name = n;
            money = 0;
        }
    }
}
