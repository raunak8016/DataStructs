public class Median {
	public static Node median(BinarySearchTree tree) {
		int target = tree.size()/2 + 1;
		Node median = tree.root;
		while (tree.root != null) {
			System.out.println("Target: " + target);
			System.out.println("Right: " + tree.size(tree.root.right));
			if (target - tree.size(tree.root.left) > 0) {
				target = target - tree.size(tree.root.left) - 1;
				if (target == 0) return tree.root;
				tree.root = tree.root.right;
			} else if (target - tree.size(tree.root.left) < 0) {
				tree.root = tree.root.left;
			}
			else { 
				median = tree.root.left;
				tree.root = tree.root.left;
			}
		}
		return median;
	}
	
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		 
        /* Let us create following BST
              50
           /     \ 
          30      70
         /  \    /  \
       20   40  60   80 */
		tree.insert(1);
        tree.insert(5);
        tree.insert(2);
        tree.insert(4);
        tree.insert(3);
        
        
        
        
	 
        // print inorder traversal of the BST
        tree.inorder();
        System.out.println(tree.size());
        Node median = median(tree);
        System.out.println("Median: " + median.key);
	}
}
