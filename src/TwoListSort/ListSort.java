package TwoListSort;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListSort {
	public void sort(List<List<String>> list, int[] nums){
		List<innerType> tempList = new LinkedList<>();
		for(int i = 0; i < list.size(); i++){
			tempList.add(new innerType(list.get(i), nums));
		}
		Collections.sort(tempList);
		for(int i = 0; i < list.size(); i++){
			list.add(tempList.get(i).ss);
			list.remove(0);
		}
	}
	
	private class innerType implements Comparable<Object>{
		public List<String> ss;
		int[] nums;
		public innerType(List<String> ss, int[] nums){
			this.ss = ss;
			this.nums = nums;
		}
		@Override
		public int compareTo(Object object) {
			for(int i = 0; i < nums.length; i++){
				int index = nums[i];
				if(this.ss.get(index).compareTo(((innerType)object).ss.get(index)) < 0 ){
					return -1;
				} else if(this.ss.get(index).compareTo(((innerType)object).ss.get(index)) > 0){
					return 1;
				} else{
					///////
				}
			}
			return 0;
		}

	}

	public static void main(String[] args) {
		//构建测试数据
		List<List<String>> list = new LinkedList<>();
		List<String> line1 = new LinkedList<>();
		line1.add("3");
		line1.add("good");
		line1.add("nice");
		line1.add("ok");
		line1.add("12");
		List<String> line2 = new LinkedList<>();
		line2.add("6");
		line2.add("abc");
		line2.add("def");
		line2.add("better");
		line2.add("10");
		List<String> line3 = new LinkedList<>();
		line3.add("9");
		line3.add("abc");
		line3.add("def");
		line3.add("best");
		line3.add("10");
		List<String> line4 = new LinkedList<>();
		line4.add("12");
		line4.add("abc");
		line4.add("def");
		line4.add("nicest");
		line4.add("8");
		list.add(line1);
		list.add(line2);
		list.add(line3);
		list.add(line4);
		//打印初始测试数据
		System.out.println(list); 
		//////////
		ListSort instance = new ListSort();
		////////////第一次排序
		int [] nums = { 1, 2, 4};
		instance.sort(list, nums);
		System.out.println(list);
		////////////第二次排序
		nums = new int[]{ 1, 3, 4};
		instance.sort(list, nums);
		System.out.println(list);
		////////////第二次排序
		nums = new int[]{ 2, 3};
		instance.sort(list, nums);
		System.out.println(list);
		nums = new int[]{4};
		instance.sort(list, nums);
		System.out.println(list);

	}
}
