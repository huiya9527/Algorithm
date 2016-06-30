package permutation;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutation {
	public List<List<Integer>> generatePermutation(int[] nums) {
		List<List<Integer>> result = new LinkedList<>();
		List<Integer> midList = new LinkedList<>();
		Arrays.sort(nums);
		dfs(result, midList, 0, nums);
		return result;
	}

	private void dfs(List<List<Integer>> result, List<Integer> midList, int index, int[] nums) {
		if (index == nums.length - 1) {
			midList.add(nums[index]);
			result.add(new LinkedList<>(midList));
			midList.remove(midList.size() - 1);
			return;
		}
		for (int i = index; i < nums.length; i++) {
			if (i == index || nums[i] != nums[i - 1]) {
				int temp = nums[index];
				nums[index] = nums[i];
				nums[i] = temp;
				midList.add(nums[index]);
				dfs(result, midList, index + 1, nums);
				midList.remove(midList.size() - 1);
				temp = nums[index];
				nums[index] = nums[i];
				nums[i] = temp;
			}
		}
	}

	public static void main(String[] args) {
		Permutation permutation = new Permutation();
		int[] nums = { 1, 2, 2, 3 };
		System.out.println(permutation.generatePermutation(nums));

	}
}
