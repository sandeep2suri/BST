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
		
        System.out.println(sumTree(tree));
	}
	
	private static int isLeaf(SumTree s) {
		if ((s.left == null) && (s.right == null))
			return 1;
		return 0;
	}
	
	private static int sumTree(SumTree s) {
		if ((s == null) || (isLeaf(s) == 1))
			return 1;
		
		int l = 0;
		int r = 0;
		
		if ((sumTree(s.left) != 0) && (sumTree(s.right) != 0)) {
			if (s.left != null) {
				if (isLeaf(s.left) == 1)
					l = s.left.data;
				else
					l = s.left.data * 2;
			}
			
			if (s.right != null) {
				if (isLeaf(s.right) == 1)
					r = s.right.data;
				else
					r = s.right.data * 2;
			}
			
			if ((l+r) == s.data)
				return 1;
			else
				return 0;
		}
		return 0;
	}
}
