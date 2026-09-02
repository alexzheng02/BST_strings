/**
 * creates a binary search tree that holds strings and compares in alphabetical order
 */
public class BST {
    private Bstnode root;

    //creates an empty BST
    public BST() {
        root = null;
    }

    /**
     * inserts a string into the BST.
     * @param element the string inserted.
     */
    public void insert(String element) {
        if (root == null) {
            root = new Bstnode(element);
            return;
        }
        Bstnode current = root;
        while(true) {
            int cmp = element.compareTo(current.getData());
            if (cmp < 0) {
                if (current.getLeft() == null) {
                    current.setLeft(new Bstnode(element));
                    return;
                }
                current = current.getLeft();
            }
            else if (cmp > 0) {
                if (current.getRight() == null) {
                    current.setRight(new Bstnode(element));
                    return;
                }
                current = current.getRight();
            }
            else {
                return;
            }
        }
    }

    /**
     * searches for a string in BST
     * @param element the string we are looking for
     * @return true if found, false if not
     */
    public boolean search(String element) {
        Bstnode current = root;
        while (current != null) {
            int cmp = element.compareTo(current.getData());
            if(cmp == 0) {
                return true;
            }

            if(cmp < 0) {
                current = current.getLeft();
            }
            else {
                current = current.getRight();
            }
        }
        return false;
    }

    /**
     *Deletes a string from BST in 3 cases:
     * node is a leaf,
     * node has one child,
     * node has two children.
     *
     * @param element string to delete
     */
    public void delete(String element) {
        Bstnode parent = null;
        Bstnode current = root;

        while(current != null && !current.getData().equals(element)) {
            parent = current;
            if (element.compareTo(current.getData()) < 0) {
                current = current.getLeft();
            }
            else {
                current = current.getRight();
            }
        }

        if (current == null) {
            System.out.println(element + " not found in tree.");
            return;
        }

        if (current.getLeft() != null && current.getRight() != null) {
            Bstnode successorParent = current;
            Bstnode successor = current.getRight();
            while (successor.getLeft() != null) {
                successorParent = successor;
                successor = successor.getLeft();
            }
            current.setData(successor.getData());

            current = successor;
            parent = successorParent;
        }

        Bstnode child;
        if (current.getLeft() != null) {
            child = current.getLeft();
        }
        else {
            child = current.getRight();
        }

        if(parent == null) {
            root = child;
        }
        else if (parent.getLeft() == current) {
            parent.setLeft(child);
        }
        else {
            parent.setRight(child);
        }

    }

    // inorder traversal
    public void inorder() {
        System.out.print ("Inorder: ");
        inorder(root);
        System.out.println();
    }
    private void inorder(Bstnode node) {
        if(node == null) {
            return;
        }
        inorder(node.getLeft());
        System.out.print(node.getData() + " ");
        inorder(node.getRight());
    }

    // preorder traversal
    public void preorder() {
        System.out.print("Preorder:  ");
        preorder(root);
        System.out.println();
    }

    private void preorder(Bstnode node) {
        if (node == null) return;
        System.out.print(node.getData() + "  ");
        preorder(node.getLeft());
        preorder(node.getRight());
    }

    //postorder traversal
    public void postorder() {
        System.out.print("Postorder: ");
        postorder(root);
        System.out.println();
    }

    private void postorder(Bstnode node) {
        if (node == null) return;
        postorder(node.getLeft());
        postorder(node.getRight());
        System.out.print(node.getData() + "  ");
    }
}
