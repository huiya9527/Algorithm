package permutation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Permutation {
	public List<List<Integer>> generatePermutation(int[] nums) {
		List<List<Integer>> list = new LinkedList<>();
		Arrays.sort(nums);
		if (nums == null) {
			return list;
		}
		helper(list, nums, 0);
		return list;

	}

	public void helper(List<List<Integer>> result, int[] nums, int index) {
		if (index == nums.length - 1) {
			List<Integer> list = new LinkedList<>();
			for (int i = 0; i < nums.length; i++) {
				list.add(nums[i]);
			}
			result.add(list);
			return;
		}
		Set<Integer> set = new HashSet<>();
		set.add(nums[index]);
		for (int i = index; i < nums.length; i++) {
			if (index == i || !set.contains(nums[i])) {
				set.add(nums[i]);
				int temp = nums[i];
				nums[i] = nums[index];
				nums[index] = temp;
				helper(result, nums, index + 1);
				temp = nums[i];
				nums[i] = nums[index];
				nums[index] = temp;
			}
		}
	}

	public static void main(String[] args) {
		Permutation permutation = new Permutation();
		int[] nums = { 1, 2, 2, 3 };
		System.out.println(permutation.generatePermutation(nums));

	}
}
