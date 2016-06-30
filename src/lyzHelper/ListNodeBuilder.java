package lyzHelper;


public class ListNodeBuilder {
	public static ListNode builde(int[] nums){
		if(nums == null || nums.length == 0){
			System.out.println("The input nums'length must larger than zero");
			return null;
		}
		ListNode pre = new ListNode(0);
		ListNode pointer = pre;
		for(int i = 0; i < nums.length; i++){
			pointer.next = new ListNode(nums[i]);
			pointer = pointer.next;
		}
		return pre.next;
	}
	
	public static ListNode builde(int num){
		if(num < 1){
			System.out.println("The input num must larger than zero");
			return null;
		}
		ListNode pre = new ListNode(0);
		ListNode pointer = pre;
		for(int i = 1; i <= num; i++){
			pointer.next = new ListNode(i);
			pointer = pointer.next;
		}
		return pre.next;
	}
}
