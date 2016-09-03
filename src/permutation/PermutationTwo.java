package permutation;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationTwo {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> list = new LinkedList<>();
		if (nums == null || nums.length == 0) {
			return list;
		}
		List<Integer> midList = new LinkedList<>();
		Arrays.sort(nums);
		for (int i : nums) {
			midList.add(i);
		}
		helper(list, midList, 0);
		return list;
	}

	public void helper(List<List<Integer>> result, List<Integer> midList, int index) {
		if (index == midList.size() - 1) {
			List<Integer> list = new LinkedList<>(midList);
			result.add(list);
			return;
		}
		for (int i = index; i < midList.size(); i++) {
			if (index == i || midList.get(i) != midList.get(i-1)) {
				int temp = midList.remove(i);
				midList.add(index,temp);
				helper(result, midList, index + 1);
				temp = midList.remove(index);
				midList.add(i,temp);
			}
		}
	}
}
