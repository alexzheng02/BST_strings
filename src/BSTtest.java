/**
 * test class for binary search tree with all the locations
 */
public class BSTtest {
    public static void main(String[] args) {

        String[] cities = {
                "New York", "Chicago", "Los Angeles", "Boston", "Houston",
                "Miami", "Seattle", "Denver", "Atlanta", "Dallas"
        };

        BST tree = new BST();
        for (String city : cities)
            tree.insert(city);

        System.out.println("initial BST");
        tree.inorder();
        tree.preorder();
        tree.postorder();

        System.out.println("\n adding San Francisco...");
        tree.insert("San Francisco");
        tree.inorder();

        System.out.println("\n search test");
        System.out.println("Miami: " + tree.search("Miami"));
        System.out.println("Austin: " + tree.search("Austin"));

        System.out.println("\n removing Atlanta...");
        tree.delete("Atlanta");
        tree.inorder();

        System.out.println("\n removing Seattle...");
        tree.delete("Seattle");
        tree.inorder();

        System.out.println("\n removing Chicago...");
        tree.delete("Chicago");
        tree.inorder();

        // Part C - final traversals
        System.out.println("\n final traversals");
        tree.inorder();
        tree.preorder();
        tree.postorder();

        System.out.println("\n inorder is alphabetical because BST property makes sure left < root < right for all nodes.");
    }
}
