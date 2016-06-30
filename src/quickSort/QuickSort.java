package quickSort;

import java.util.Arrays;

public class QuickSort {
	public void sort(int[] nums) {
		if (nums == null || nums.length <= 1)
			return;
		quickSortHelper(nums, 0, nums.length - 1);
	}

	private void quickSortHelper(int[] nums, int start, int end) {
		// 如果只有一个数或者传入的数据下标不正确直接发挥
		if (start >= end)
			return;
		// 选取第一个数放在中间
		int i = start+1;
		int j = end;
		int pivot = nums[start];
		while (i < j) {
			while (i < j && nums[j] >= pivot) {
				j--;
			}
			while (i < j && nums[i] <= pivot) {
				i++;
			}
			// swap
			if (i != j) {
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
			} else {
				break;
			}
		}
		//判断是否要交换
		if (nums[i] < pivot) {
			nums[start] = nums[i];
			nums[i] = pivot;
		}
		quickSortHelper(nums,start,i - 1);
		quickSortHelper(nums,i,end);
	}
	
	public static void main(String[] args){
		QuickSort instance = new QuickSort();
		int[] nums;
		nums = new int[]{4,1,5,3,7,6,2,8};
		instance.sort(nums);
		System.out.println(Arrays.toString(nums));
		nums = new int[]{8,7,6,5,4,3,2,1};
		instance.sort(nums);
		System.out.println(Arrays.toString(nums));
		nums = new int[]{1,2,3,4,5,6,7,8};
		instance.sort(nums);
		System.out.println(Arrays.toString(nums));
	}

}
