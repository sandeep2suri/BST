package BST;

import java.util.Stack;

public class LevelTraversal {
	private static LevelTraversal root;
	private LevelTraversal right;
	private LevelTraversal left;
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
		
		printLevelTraversal();
	}
	
	public static void insert(int i) {
		LevelTraversal inst = new LevelTraversal();
		inst.data = i;
		
		if (root == null) {
			root = inst;
			return;
		}
		
		LevelTraversal r = root;
		
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
	
	// this does level order traversal in spiral form
	private static void printLevelTraversal() {
		Stack<LevelTraversal> s1 = new Stack<LevelTraversal>();
		Stack<LevelTraversal> s2 = new Stack<LevelTraversal>();
		
		s1.add(root);
		while ((s1.isEmpty() == false) || (s2.isEmpty() == false)){
			while(s1.isEmpty() != true) {
				LevelTraversal n = s1.pop();
				System.out.print(n.data + ", ");
				if (n.right != null) s2.push(n.right);
				if (n.left != null) s2.push(n.left);
			}
			while(s2.isEmpty() != true) {
				LevelTraversal n = s2.pop();
				System.out.print(n.data + ", ");
				if (n.left != null) s1.push(n.left);
				if (n.right != null) s1.push(n.right);
			}
		}
	}
}
