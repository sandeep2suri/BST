package BST;

public class LeftView {
	private static LeftView root;
	private LeftView right;
	private LeftView left;
	private int data;
	
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
		insert(60);
		insert(65);
		insert(140);
		insert(150);
		insert(160);
		insert(170);
		
		System.out.print("Left view: ");
		printLeftView(root, 0);
		System.out.print("\nRight view: ");
		printRightView(root, 0);
	}
	
	public static void insert(int i) {
		LeftView inst = new LeftView();
		inst.data = i;
		
		if (root == null) {
			root = inst;
			return;
		}
		
		LeftView r = root;
		
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
	
	static int maxLeftLevel = -1;
	static int maxRightLevel = -1;
	private static void printLeftView (LeftView n, int level) {
		if (n == null)
			return;
		
		if (level > maxLeftLevel) {
			maxLeftLevel = level;
			System.out.print(n.data + ", ");
		}		
		printLeftView(n.left, level + 1);
		printLeftView(n.right, level + 1);
	}
	
	private static void printRightView (LeftView n, int level) {
		if (n == null)
			return;
		
		if (level > maxRightLevel) {
			maxRightLevel = level;
			System.out.print(n.data + ", ");
		}
		printRightView(n.right, level + 1);
		printRightView(n.left, level + 1);
	}
}
