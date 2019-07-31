/**This class is my Binary Search Tree, which serves as my container class. This uses the Node class and TreeDemo class,
 * adds nodes to the tree, and traverses the tree in all three orders.
 *
 * @author amber sibel
 * @version 7/30/19
 */

public class BinarySearchTree {

    private Node root;
    private int size;

    public BinarySearchTree(){
        root = null;
        size = 0;
    }
    public boolean isEmpty(){
        return root == null;
    }

    public void insert(String word) {

        //place word at root if empty
        if (isEmpty()) {
            root = new Node(word);
        } //see if word exists in another node
        else{
            Node searchedNode = search(word);
            if(searchedNode != null){
                searchedNode.increaseFrequency();
            }  //add to tree
            else {
                size++;
                insert(root, new Node(word));
            }
        }
    }

     void insert(Node subroot, Node n) {
         //left or right?
         if (n.getName().compareTo(subroot.getName()) < 0) {  //left
             //is there a left child?
             if (subroot.getLeftChild() == null) {
                 subroot.setLeftChild(n);
             } else {
                 insert(subroot.getLeftChild(), n);
             }
         } else {                                   //right
             //is there a right child?
             if(subroot.getRightChild() == null){
                 subroot.setRightChild(n);
             } else{
                 insert(subroot.getRightChild(), n);
             }
         }
     }

    public Node search(String word){ //search for name in Node

        Node node = search(root, word);

        if(isEmpty())
            return null;

        if(node == null){
            System.out.println("Nothing to see here.");
        } else{
           System.out.println("Found it!");
        }

        return node;
    }

    Node search(Node subroot, String word){
        //match?
        if(word.equals(subroot.getName())){
            return subroot;
        } else if (word.compareTo(subroot.getName()) < 0){  //left side
            //look for left child
            if(subroot.getLeftChild() == null){
                return null;
            } else{
                return search(subroot.getLeftChild(), word);
            }
        } else {                                            //right side
            //look for right child
            if(subroot.getRightChild() == null){
                return null;
            } else{
                return search(subroot.getRightChild(), word);
            }
        }
    }

    public void printPreOrder(){  //root > left > right
        System.out.println("-------------\nPreOrder: \n-------------");
        printPreOrder(root);
    }
    void printPreOrder(Node subroot){
        if(subroot == null)
            return;
        //print subroot
        System.out.println(subroot.toString());
        //print left subtree
        printPreOrder(subroot.getLeftChild());
        //print right subtree
        printPreOrder(subroot.getRightChild());
    }
    public void printInOrder(){  //left > root > right
        System.out.println("-------------\nInOrder: \n-------------");
        printInOrder(root);
    }
    void printInOrder(Node subroot){
        if(subroot == null)
            return;
        //print left subtree
        printInOrder(subroot.getLeftChild());
        //print subroot
        System.out.println(subroot.toString());
        //print right subtree
        printInOrder(subroot.getRightChild());
    }
    public void printPostOrder(){  //left > right > root
        System.out.println("-------------\nPostOrder: \n-------------");
        printPostOrder(root);
    }
    void printPostOrder(Node subroot){
        if(subroot == null)
            return;
        //print left subtree
        printPostOrder(subroot.getLeftChild());
        //print right subtree
        printPostOrder(subroot.getRightChild());
        //print subroot
        System.out.println(subroot.toString());
    }

}
