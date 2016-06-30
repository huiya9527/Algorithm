package lyzHelper;

import java.util.LinkedList;
import java.util.Queue;

public class TreePrinter {

	public static void print(TreeNode root){
		if(root == null) System.out.println("#");
		TreeNodeHasWidth newRoot = deepCopy(root,0);
		Queue<TreeNodeHasWidth> nodeQueue = new LinkedList<>();
		Queue<Integer> fatherPosition = new LinkedList<>();
		nodeQueue.add(newRoot);
		fatherPosition.add(0);
		while(true){
			int length = nodeQueue.size();
			if(length == 0) break;
			int nowPosition = 0;
			//every line
			for(int i = 0; i < length; i++){
				TreeNodeHasWidth node = nodeQueue.poll();
				int pPosition = node.diff + node.leftWidth + 1; 
				while(++nowPosition != pPosition){
					System.out.print(" ");
				}
				System.out.print(node.val);
				if(node.left != null){
					nodeQueue.add(node.left);
				}
				if(node.right != null){
					nodeQueue.add(node.right);
				}
			}
			System.out.println();
		}
	}
	
	private static TreeNodeHasWidth deepCopy(TreeNode root,int diff){
		if (root== null) return null;
		TreeNodeHasWidth newRoot = new TreeNodeHasWidth(root.val,diff);
		newRoot.left = deepCopy(root.left, newRoot.diff);
		newRoot.leftWidth = newRoot.left == null ? 0 : newRoot.left.leftWidth + newRoot.left.rightWidth + 1;
		newRoot.right = deepCopy(root.right, newRoot.leftWidth+diff + 1);
		newRoot.rightWidth = newRoot.right == null ? 0 : newRoot.right.leftWidth + newRoot.right.rightWidth + 1;
		return newRoot;
	}
	
//	public static void main(String[] args) {
//		TreeNode t1 = new TreeNode(1);
//		TreeNode t2 = new TreeNode(2);
//		TreeNode t3 = new TreeNode(3);
//		TreeNode t4 = new TreeNode(4);
//		TreeNode t5 = new TreeNode(5);
//		TreeNode t6 = new TreeNode(6);
//		TreeNode t7 = new TreeNode(7);
//		TreeNode t8 = new TreeNode(8);
//		t1.left = t2;
//		t1.right = t3;
//		t2.left = t4;
//		t2.right = t5;
//		t3.left = t6;
//		t6.left = t7;
//		t5.right = t8;
//		print(t1);
//	}
}


class TreeNodeHasWidth{
	public int val;
	public int diff;
	public int leftWidth = 0;
	public int rightWidth = 0;
	TreeNodeHasWidth left = null;
	TreeNodeHasWidth right = null;
	public TreeNodeHasWidth(int val, int diff){
		this.val = val;
		this.diff = diff;
	}
}
