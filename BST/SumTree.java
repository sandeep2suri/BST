package BST;

public class SumTree {
	private SumTree root;
	private SumTree left;
	private SumTree right;
	private int data;
	
	public SumTree(int i) {
		this.data = i;
	}

	public static void main(String args[]) {
		SumTree tree = new SumTree(144);
		tree.root = tree;
		tree.root.left = new SumTree(20);
		
		tree.root.left.left = new SumTree(3);
		tree.root.left.left.left = new SumTree(1);
		tree.root.left.left.right = new SumTree(2);
		
		tree.root.left.right = new SumTree(7);
		tree.root.left.right.left = new SumTree(3);
		tree.root.left.right.right = new SumTree(4);
		
		tree.root.right = new SumTree(52);
		
		tree.root.right.left = new SumTree(11);
		tree.root.right.left.left = new SumTree(5);
		tree.root.right.left.right = new SumTree(6);
		
		tree.root.right.right = new SumTree(15);
		tree.root.right.right.left = new SumTree(7);
		tree.root.right.right.right = new SumTree(8);
		
        System.out.println(isSumTree(tree));
	}
	
	private static int isLeaf(SumTree s) {
		if ((s.left == null) && (s.right == null))
			return 1;
		return 0;
	}
	
	private static int isSumTree(SumTree n) {
		if (n == null || isLeaf(n) == 1)
			return 1;
		
		if((isSumTree(n.left) == 0) || (isSumTree(n.right) == 0))
			return 0;
		
		int left = (isLeaf(n.left) == 1)? n.left.data : (2*n.left.data);
		int right = (isLeaf(n.right) == 1)? n.right.data : (2*n.right.data);
		if (n.data != (left + right))
			return 0;
		
		return 1;
	}
}
