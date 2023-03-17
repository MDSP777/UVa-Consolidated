import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


public class UVa_11111 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String s = br.readLine();
			if(s==null || s.isEmpty()) break;
			String[] split = s.split(" ");
			Stack<Doll> stack = new Stack<>();
			boolean yes = true;
			for(String str : split){
				int cur = Integer.parseInt(str);
				if(cur<0) {
					if(!stack.isEmpty() && stack.peek().val>=cur){
						yes = false;
						break;
					}
					stack.push(new Doll(cur));
				} else {
					if(stack.isEmpty() || stack.peek().val+cur!=0){
						yes = false;
						break;
					}
					stack.pop();
					if(!stack.isEmpty()){
						stack.peek().contents+=cur;
						if(stack.peek().contents>=Math.abs(stack.peek().val)){
							yes = false;
							break;
						}
					}
				}
			}
			if(yes && stack.isEmpty()) System.out.println(":-) Matrioshka!");
			else System.out.println(":-( Try again.");
		}
	}
	
	static class Doll {
		int val;
		int contents;
		
		Doll(int v){
			val = v;
			contents = 0;
		}
		
		public String toString(){
			return val+" "+contents;
		}
	}
}
