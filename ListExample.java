import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// add: adds user item to list and BST
// balance: balances the tree for quicker updates
// no delete

//This class Prompts the user for items that they want included in a list, then allows them to rank those items based on their opinion on them
//in relation to the other and returns a list ordered by ranking. With a score out of 10 for each item.
public class ListExample {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        addToList(myList, scanner);
        System.out.println("My List: " + myList);
        
    }

    //Behavior: This method prompts the user to add additional items to the list
    //Pre: Utilizes a scanner and an empty list
    //Post: Returns a list of items scanned in from the user
    //Parameters:
    //  - List<String> myList: empty list of strings
    //  - Scanner scanner: scanner to collect items from user, to add to list
    //Exceptions: NA
    //Returns:
    // - List<String> myList: list of items added by user
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

//This class creates the node object composed of an integer(value) and an additional node that it is connected to
//for project switch int to string
class Node {
    String key;
    Node left, right;

    //for project switch int item to string
    //getter method receives item from program, sets value to key of item
    public Node(String item) {
        key = item;
        left = right = null;
    }
}

//This class
class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    //rebuild similar to insert and insert rec....but compare with items already in the tree
    //Behavior: insert operation
    //Pre: 
    //Post: This method accepts an int key and uses a recursive call to find an update the tree placing the key where it belongs numerically 
    //Parameters:
    //  - int: given key to be placed within the BST
    //Exceptions: NA
    //Returns: void
    //Insertion operation
    void insert(Scanner direction, String key) {
        root = insertString(direction, root, key);
    }

    Node treeDirection(Scanner direction, Node root, String key) {
        System.out.println("Do you like " + root.key + " or " + key + " better?");
        String better = direction.next();
        if (better.equalsIgnoreCase(root.key)) {
            root.left = new Node(key);
            // root.left = insertString(direction, root, key);

        } else if (better.equalsIgnoreCase(key)) {
            root.right = new Node(key);
            // root.right = insertString(direction, root, key);
        } else {
            System.out.println("ERROR");
        }
        return root;
    }

    Node insertString(Scanner direction, Node root, String key) {
        if (root == null) {
            root = new Node(key);
            // System.out.println("poop");
            return root;
        } else {
            // System.out.println("poop again");
            treeDirection(direction, root, key);
        }
        return root;

    }

    //rebuild
    //Behavior: Goes through tree to find where new key belongs and then places it there
    //Pre: Starts at root, either empty or with other nodes and then adds them
    //Post: 
    //Parameters: 
    // - Node<Node, int>root: the initial node of a binary search tree
    // - int key: value associated with node name
    //Exceptions: NA
    //Returns: Node<Node, int>root, the starting point with the full tree connected to it
    //
    // Node insertRec(Node root, int key) {
    //     if (root == null) {
    //         root = new Node(key);
    //         return root;
    //     }

    //     if (key < root.key) {
    //         root.left = insertRec(root.left, key);
    //     } else if (key > root.key) {
    //         root.right = insertRec(root.right, key);
    //     }
    //     // if key is equal to root.key, do nothing (no duplicateds allowed in this)
    //     return root;
    // }

    //Behavior: Public private pair to trigger recursive call to logically search BST until value is found, or not found
    //Pre: 
    //Post: 
    //Parameters: int key: value from user
    //Exceptions: 
    //Returns: Recursive call, present or not present
    //
    //Search operation
    // public boolean search(int key) {
    //     return searchRec(root, key);
    // }

    //Behavior: Recursively searching for key
    //Pre: 
    //Post: 
    //Parameters:
    //  - Node root:
    //  - int key
    //Exceptions: NA
    //Returns:
    //  - null: if not found returns false
    //  - true: 
    //  - recursive call:
    // public boolean searchRec(Node root, String key) {
    //     if (root == null) {
    //         return false; // Key not found
    //     }

    //     if (root.key == key) {
    //         return true; // key found
    //     }

    //     if (key < root.key) {
    //         return searchRec(root.left, key);
    //     } else {
    //         return searchRec(root.right, key);
    //     }
    // }

    //Behavior: Calls recursive function to delete key
    //Pre: 
    //Post: 
    //Parameters: int key: Key to be found and located
    //Exceptions: NA
    //Returns: void
    //Deletion operation
    // void delete(String key) {
    //     root = deleteRec(root, key);
    // }

    //rebuild to remove comparison factor
    //Behavior:
    //Pre: 
    //Post: 
    //Parameters:
    //Exceptions: 
    //Returns:
    // Node deleteRec(Node root, String key) {
    //     if (root == null) {
    //         return root;
    //     }

    //     if (key < root.key) {
    //         root.left = deleteRec(root.left, key);
    //     } else if (key > root.key) {
    //         root.right = deleteRec(root.right, key);
    //     } else {
    //         //Node to be deleted found

    //         //Case 1: Node with only one child or no child
    //         if (root.left == null) {
    //             return root.right;
    //         } else if (root.right == null) {
    //             return root.left;
    //         }

    //         //case 2: node with 2 children
    //         //get the in-order successor (smallest in the right subtree)
    //         root.key = minValue(root.right);

    //         //Delete the inorder successor
    //         root.right = deleteRec(root.right, root.key);
    //     }
    //     return root;
    // }

    // int minValue(Node root) {
    //     int minv = root.key;
    //     while (root.left != null) {
    //         minv = root.left.key;
    //         root = root.left;
    //     }
    //     return minv;
    // }

    //Behavior: "public/private" pair for calling recursive method without parameters
    //Pre: 
    //Post: 
    //Parameters:
    //Exceptions: 
    //Returns:
    //in=-order traversal (ro verification)
    void inorder() {
        inorderRec(root);
    }

    //Behavior: Recursively calls inorder method
    //Pre: 
    //Post: 
    //Parameters:
    //Exceptions: 
    //Returns:
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    //Behavior:
    //Pre: 
    //Post: 
    //Parameters:
    //Exceptions: 
    //Returns:
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /*  Constructing the BST:
         *        50
         *      /     \
         *     30     70
         *     / \   / \
         *    20 40 60 80
        */
        Scanner scanner = new Scanner(System.in);
        tree.insert(scanner,"McDonalds"); //insert operation to add key
        tree.insert(scanner,"Burger King");
        tree.insert(scanner,"Wendys");
        // tree.insert(scanner,"In and Out");
        // tree.insert(scanner,"Jack in the Box");
        // tree.insert(scanner,"Dicks");
        // tree.insert(scanner,"Jollibee");

        System.out.println("In-order tranversal of the BST:");
        tree.inorder(); // Expected: 20 30 40 50 60 70 80 uses inorder recursion to walk through tree in order
        System.out.println("\n");
        tree.inorder(); // Expected: 30 40 50 60 80
        System.out.println("\n");
        tree.inorder(); // Expected: 30 40 60 80
        
    }
}