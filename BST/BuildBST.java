package BST;
import java.util.*;

public class BuildBST {
	private static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	private static BuildBST root;
	private BuildBST left;
	private BuildBST right;
	private int data;
	
	private BuildBST(int i) {
		this.data = i;
	}
	
	public static void main(String args[]) {
		int in[] = { 4, 8, 2, 5, 1, 6, 3, 7 }; 
	    int post[] = { 8, 4, 5, 2, 6, 7, 3, 1 };
	    for (int loop = 0; loop < in.length; ++loop)
	    	map.put(in[loop], in[loop]);
	    
	    Index index = new Index();
	    index.index = post.length -1;
	    buildTree(post, 0, post.length - 1, index);
	    
	    System.out.println();
	}
	
	static class Index { 
	    int index; 
	}
	
	private static BuildBST buildTree(int post[], int low, int high, Index index) {
		if (low > high)
			return null;
		
		BuildBST currRoot = new BuildBST(post[high]);
		// check if it is root node
		if (root == null)
			BuildBST.root = currRoot;
		
		// check if leaf node
		if (low == high)
			return null;
		
		// search index in inorder array
		int i = map.get(post[index.index]);
		index.index--;
		// build right sub tree
		currRoot.right = buildTree(post, i+1, high, index);
		// build left sub tree
		currRoot.left = buildTree(post, low, i-1, index);
		
		return currRoot;
	}
}
