/**This class works alongside the BinarySearchTree and the TreeDemo. The Node class creates the objects that go into
 * the BinarySearchTree, along with keeping up with the two children, the string entered by the user, and the frequency.
 *
 * @author amber sibel
 * @version 7/30/19
 */
//poptart
public class Node {

    private int frequency;
    private String name;
    private Node leftChild, rightChild;

    public Node(String n){
        frequency = 1;
        name = n;
        leftChild = rightChild = null;
    }
    public void increaseFrequency(){
        frequency++; //eh?
    }

    public void setLeftChild(Node n){
        leftChild = n;
    }

    public void setRightChild(Node n){
        rightChild = n;
    }

    public Node getLeftChild(){
        return leftChild;
    }

    public Node getRightChild(){
        return rightChild;
    }

    public String getName(){
        return name;
    }

    public String toString(){
        return "" + name + " - " + frequency;
    }

}
