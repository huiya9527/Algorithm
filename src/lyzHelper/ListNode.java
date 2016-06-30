package lyzHelper;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x) { val = x; }

	@Override
	public String toString(){
		String result = Integer.toString(val);
		if(next != null){
			result = result + " -> " + next.toString();
		}
		return result;
	}
}
