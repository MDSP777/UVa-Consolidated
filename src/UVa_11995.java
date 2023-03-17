

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class UVa_11995 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        do{
            boolean isStack = true;
            boolean isPrioQueue = true;
            boolean isQueue = true;
            int nCommands;
            try{
                nCommands = new Integer(sc.readLine());
            } catch (Exception e){
                break;
            }
            Stack<Integer> stack = new Stack();
            PriorityQueue<Integer> prioQueue = new PriorityQueue<>(nCommands, Collections.reverseOrder());
            Queue<Integer> queue = new LinkedList<>();
            for(int i=0; i<nCommands; i++){
                StringTokenizer input = new StringTokenizer(sc.readLine());
                int commandType = new Integer(input.nextToken());
                if(commandType==1){
                    int elem = new Integer(input.nextToken());
                    stack.add(elem);
                    prioQueue.add(elem);
                    queue.add(elem);
                } else{
                    int elem = new Integer(input.nextToken());
                    try{
                        int stackTop = stack.pop();
                        int prioQueueTop = prioQueue.poll();
                        int queueTop = queue.poll();

    //                    System.out.println(prioQueueTop);
                        if(stackTop!=elem) isStack = false;
                        if(prioQueueTop!=elem) isPrioQueue = false;
                        if(queueTop!=elem) isQueue = false;
                    } catch(Exception e){
                        isPrioQueue = isQueue = isStack = false;
                    }
                }
            }
            int nTrue = 0;
            if(isStack) nTrue++;
            if(isPrioQueue) nTrue++;
            if(isQueue) nTrue++;
            if(nTrue==0) out.append("impossible");
            else if(nTrue>=2) out.append("not sure");
            else{
                if(isStack) out.append("stack");
                else if(isPrioQueue) out.append("priority queue");
                else out.append("queue");
            }
//            if(nTrue==0) System.out.println("impossible");
//            else if(nTrue>=2) System.out.println("not sure");
//            else{
//                if(isStack) System.out.println("stack");
//                else if(isPrioQueue) System.out.println("priority queue");
//                else System.out.println("queue");
//            }
//            System.out.println("isStack: "+isStack);
//            System.out.println("isPrioQueue: "+isPrioQueue);
//            System.out.println("isQueue: "+isQueue);
            out.append("\n");
        }while(true);
        System.out.print(out);
    }
}
