import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//This class Prompts the user for items that they want included in a list, then allows them to rank those items based on their opinion on them
//in relation to the other and returns a list ordered by ranking. With a score out of 10 for each item.
public class ListExample {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        addToList(myList, scanner);
        System.out.println("My List: " + myList);
        
    }
    //Behavior: 
    //Pre:
    //Post:
    //Parameters:
    //  - List<String> myList
    //  - Scanner scanner
    //Exceptions:
    //Returns:
    public static List<String> addToList(List<String> myList, Scanner scanner) {
        System.out.println("Would you like to add an item to the list? (yes/no)");
        String confirmation = scanner.nextLine();
        while(!confirmation.equalsIgnoreCase("no")) {
            System.out.println("What item would you like to add to this list?");
            myList.add(scanner.nextLine());
            System.out.println("Would you like to add an item to the list? (yes/no)");
            confirmation = scanner.nextLine();
        }
        return myList;
    }
}

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    //Insertion operation
    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        // if key is equal to root.key, do nothing (no duplicateds allowed in this)
        return root;
    }

    //Search operation
    public boolean search(int key) {
        return searchRec(root, key);
    }

    public boolean searchRec(Node root, int key) {
        if (root == null) {
            return false; // Key not found
        }

        if (root.key == key) {
            return true; // key found
        }

        if (key < root.key) {
            return searchRec(root.left, key);
        } else {
            return searchRec(root.right, key);
        }
    }

    //Deletion operation
    void delete(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            //Node to be deleted found

            //Case 1: Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            //case 2: node with 2 children
            //get the in-order successor (smallest in the right subtree)
            root.key = minValue(root.right);

            //Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    //in=-order traversal (ro verification)
    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /*  Constructing the BST:
         *        50
         *      /     \
         *     30     70
         *     / \   / \
         *    20 40 60 80
        */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("In-order tranversal of the BST:");
        tree.inorder(); // Expected: 20 30 40 50 60 70 80
        System.out.println("\n");

        // Search examples
        System.out.println("Searching for 40: " + tree.search(40)); //
        System.out.println("Searching for 90: " + tree.search(90)); //
        System.out.println("\n");

        // Deletion examples
        System.out.println("Deleting 20 (leaf node)");
        tree.delete(20);
        System.out.println("In-order tranversal after deleting 20: ");
        tree.inorder(); // Expected: 30 40 50 60 70 80
        System.out.println("\n");

        System.out.println("Deleting 70 (node with two children)");
        tree.delete(70);
        System.out.println("In-order traversal after deleting 70:");
        tree.inorder(); // Expected: 30 40 50 60 80

        System.out.println("Deleting 50: ");
        tree.delete(50);
        System.out.println("Inorder traversal after deleting 50: ");
        tree.inorder(); // Expected: 30 40 60 80
        
    }
}