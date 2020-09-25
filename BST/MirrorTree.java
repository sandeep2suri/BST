package BST;

public class MirrorTree {
	private static MirrorTree mirrorRoot;
	private static MirrorTree root;
	private MirrorTree right;
	private MirrorTree left;
	private int data;
	
	public MirrorTree(MirrorTree n) {
		this.data = n.data;
	}

	public MirrorTree() {}

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
		
		mirrorTree();
		
		System.out.print("PreOrder: ");
		preOrder(root);
		System.out.print("\nInorder (Increasing Order): ");
		inOrder(root);
		System.out.print("\nInorder (Decreasing Order): ");
		inOrder(mirrorRoot);
		System.out.print("\nPostOrder: ");
		postOrder(root);
	}
	
	public static void insert(int i) {
		MirrorTree inst = new MirrorTree();
		inst.data = i;
		
		if (root == null) {
			root = inst;
			return;
		}
		
		MirrorTree r = root;
		
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
	
	public static void mirrorTree() {
		mirrorRoot = new MirrorTree(root);
		
		generateMirror(root, mirrorRoot);
	}
	
	public static void generateMirror(MirrorTree orignalNode, MirrorTree mirrorNode) {
		// leaf node
		if (orignalNode == null)
			return;
		
		if (orignalNode.left != null) {
			MirrorTree m = new MirrorTree(orignalNode.left);
			mirrorNode.right = m;
			generateMirror(orignalNode.left, m);
		}
		if (orignalNode.right != null) {
			MirrorTree m = new MirrorTree(orignalNode.right);
			mirrorNode.left = m;
			generateMirror(orignalNode.right, m);
		}
	}
	
	public static void preOrder(MirrorTree n) {
		if (n == null)
			return;
		System.out.print(n.data + ", ");
		inOrder(n.left);
		inOrder(n.right);
	}
	public static void postOrder(MirrorTree n) {
		if (n == null)
			return;
		
		postOrder(n.left);
		postOrder(n.right);
		System.out.print(n.data + ", ");
	}
	public static void inOrder(MirrorTree n) {
		if (n == null)
			return;
		
		inOrder(n.left);
		System.out.print(n.data + ", ");
		inOrder(n.right);
	}
}
