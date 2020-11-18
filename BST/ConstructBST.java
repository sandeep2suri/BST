package BST;
import java.util.*;

public class ConstructBST {
	static class BST {
		public BST(int i) {
			data = i;
		}
		public static BST root;
		public BST left;
		public BST right;
		public int data;
	}
	
	public static void main(String args[]) {
		int inOrder[] = {};
		int postOrder[] = {};
		int preOrder[] = {};
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int loop = 0; loop < inOrder.length; ++ loop)
			map.put(inOrder[loop], loop);
		
		Index index = new Index();
	    index.index = postOrder.length -1;
	    
	    
		contructFromPostAndInorder(postOrder, 0, postOrder.length - 1, index, map);
		
		index.index = 0;
		contructFromPreAndInorder(preOrder, 0, preOrder.length - 1, index, map);
	}
	
	static class Index { 
	    int index; 
	}
	
	private static BST contructFromPostAndInorder(int []postOrder, int start, int end, Index index, HashMap<Integer, Integer> inOrder) {
		if (start > end)
			return null;
		
		BST n = new BST(postOrder[end]);
		if (BST.root == null)
			BST.root = n;
		
		// find index in inorder
		int i = inOrder.get(postOrder[index.index--]);
		n.left = contructFromPostAndInorder(postOrder, start, i-1 , index, inOrder);
		n.right = contructFromPostAndInorder(postOrder, i+1, end, index, inOrder);
		return n;
	}
	
	private static BST contructFromPreAndInorder(int []preOrder, int start, int end, Index index, HashMap<Integer, Integer> inOrder) {
		if (start > end)
			return null;
		
		BST n = new BST(preOrder[start]);
		
		if (BST.root == null)
			BST.root = n;
		
		// find index in inorder
		int i = inOrder.get(preOrder[index.index++]);
		n.left = contructFromPostAndInorder(preOrder, start, i-1 , index, inOrder);
		n.right = contructFromPostAndInorder(preOrder, i+1, end, index, inOrder);
		return n;
	}
}
