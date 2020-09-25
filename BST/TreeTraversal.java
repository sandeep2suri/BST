package BST;

public class TreeTraversal {
	private static TreeTraversal root;
	private TreeTraversal right;
	private TreeTraversal left;
	private int data;
	
	public TreeTraversal(TreeTraversal n) {
		this.data = n.data;
	}

	public TreeTraversal() {}

	public static void main(String[] args) {
		insert(100);
		insert(90);
		insert(110);
		insert(80);
		insert(50);
		insert(120);
		insert(130);
		insert(105);
		insert(115);
		insert(95);
		insert(85);
				
		System.out.print("PreOrder: ");
		preOrder(root);
		System.out.print("\nInorder (Increasing Order): ");
		inOrder(root);
		System.out.print("\nPostOrder: ");
		postOrder(root);
	}
	
	public static void insert(int i) {
		TreeTraversal inst = new TreeTraversal();
		inst.data = i;
		
		if (root == null) {
			root = inst;
			return;
		}
		
		TreeTraversal r = root;
		
		while (true) {
			if (i>r.data) {
				if (r.right == null) {
					r.right = inst;
					break;
				}
				r = r.right;
			} else {
				if (r.left == null) {
					r.left = inst;
					break;
				}
				r = r.left;
			}
		}
	}
	
	public static void preOrder(TreeTraversal n) {
		if (n == null)
			return;
		System.out.print(n.data + ", ");
		inOrder(n.left);
		inOrder(n.right);
	}
	public static void postOrder(TreeTraversal n) {
		if (n == null)
			return;
		
		postOrder(n.left);
		postOrder(n.right);
		System.out.print(n.data + ", ");
	}
	public static void inOrder(TreeTraversal n) {
		if (n == null)
			return;
		
		inOrder(n.left);
		System.out.print(n.data + ", ");
		inOrder(n.right);
	}
}
