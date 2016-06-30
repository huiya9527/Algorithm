package guessNumber;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class GuessNumber {
	public List<String> items = new LinkedList<>();
	String num;
	public String compare = null;
	public int A = 0;
	public int B = 0;
	public GuessNumber(int index){
		for(int i = 0; i <= 9; i++){
			for(int j = 0; j <= 9; j++){
				if(j == i) continue;
				for(int k = 0; k <= 9; k++){
					if(k == i || k == j) continue;
					for(int l = 0; l <= 9; l++){
						if(l == i || l == j || l == k) continue;
						StringBuilder sBuilder = new StringBuilder();
						sBuilder.append((char)(i + '0'));
						sBuilder.append((char)(j + '0'));
						sBuilder.append((char)(k + '0'));
						sBuilder.append((char)(l + '0'));
						items.add(sBuilder.toString());
					}
				}
			}
		}
		this.num = this.items.get(index);
		
	}
	
	public void outNumber(){
		if(compare == null){
			System.out.println("0123");
			System.out.println("the left num of items is " + items.size());
			compare = "0123";
		}
		else{
			items.remove(compare);
			boolean haveOutPut = false;
			String nextCompare = "";
			Iterator<String> iterator = items.iterator();
			while(iterator.hasNext()){
				String temp = iterator.next();
				if(judge(temp)){
					if(!haveOutPut){
						System.out.println(temp);
						haveOutPut = true;
						nextCompare = temp;
					}
				} else{
					iterator.remove();
				}
			}
			compare = nextCompare;
			System.out.println("the left num of items is " + items.size());
		}
		
	}
	
	
	
	private boolean judge(String s){
		Set<Integer> set = new HashSet<>();
		int a = 0;
		int b = 0;
		for(int i = 0; i < 4; i++){
			if(s.charAt(i) == compare.charAt(i)){
				a++;
				set.add(i);
			}
		}
		Set<Character> recordSet = new HashSet<>();
		for(int i = 0; i < 4; i++){
			if(!set.contains(i)){
				recordSet.add(s.charAt(i));
			}
		}
		for(int i = 0; i < 4; i++){
			if(!set.contains(i) && recordSet.contains(compare.charAt(i))){
				b++;
			}
		}
		return (a == A && b == B);
	}
	
	public int[] offer(){
		Set<Integer> set = new HashSet<>();
		int a = 0;
		int b = 0;
		for(int i = 0; i < 4; i++){
			if(num.charAt(i) == compare.charAt(i)){
				a++;
				set.add(i);
			}
		}
		Set<Character> recordSet = new HashSet<>();
		for(int i = 0; i < 4; i++){
			if(!set.contains(i)){
				recordSet.add(num.charAt(i));
			}
		}
		for(int i = 0; i < 4; i++){
			if(!set.contains(i) && recordSet.contains(compare.charAt(i))){
				b++;
			}
		}
		return new int[]{a,b};
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int maxTimes = 0;
//		for(int i = 0; i < 5040; i++){
			GuessNumber guessNumber = new GuessNumber(2683);
			int count = 0;
			while(true){
				guessNumber.outNumber();
				count++;
//				int[] temp = guessNumber.offer();
//				System.out.println(temp[0] + " " + temp[1]);
//				guessNumber.A = temp[0];
//				guessNumber.B = temp[1];
				guessNumber.A = input.nextInt();
				guessNumber.B = input.nextInt();
				if(guessNumber.A == 4) break;
			}
//			if(count == 9) System.out.println(i);
//			maxTimes = Math.max(maxTimes, count);
//		}
//		System.out.println(maxTimes);
		input.close();
		
	}
}
