package subsets;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
	public List<List<Integer>> generateSubsets(int[] nums){
		List<List<Integer>> result = new LinkedList<>();
		List<Integer> midList = new LinkedList<>();
		Arrays.sort(nums);
		result.add(midList);
		dfs(result, midList, nums, 0);
		return result;
	}
	
	private void dfs(List<List<Integer>> result, List<Integer> midList, int[] nums, int index){
		for(int i = index; i < nums.length; i++){
			if(i == index || nums[i] != nums[i-1]){
				List<Integer> list = new LinkedList<>(midList);
				list.add(nums[i]);
				result.add(list);
				dfs(result, list, nums, i+1);
			}
		}
	}
	
	public static void main(String[] args) {
		Subsets subsets = new Subsets();
		int[] nums = {1,2,2,3,5};
		System.out.println(subsets.generateSubsets(nums));
	}

}
