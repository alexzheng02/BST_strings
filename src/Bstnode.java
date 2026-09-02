/**
 * represents a node in a binary search tree.
 * each node has a string and references to left and right children.
 */
public class Bstnode {
    private String data;
    private Bstnode left;
    private Bstnode right;

    /**
     *  creates a bstnode with a string input
     * @param data string for city name
     */
    public Bstnode(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    // getters and setters
    public String getData() {
        return data;
    }
    public Bstnode getLeft() {
        return left;
    }
    public Bstnode getRight() {
        return right;
    }

    public void setData(String data) {
        this.data = data;
    }
    public void setLeft(Bstnode left) {
        this.left = left;
    }
    public void setRight(Bstnode right) {
        this.right = right;
    }
}
