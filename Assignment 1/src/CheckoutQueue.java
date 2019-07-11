/**This program will contain the queue for the customers in line at a grocery store. It will be using a linked list
 * queue so that the customers are helped in the order they arrive.
 *
 * @author Amber Sibel
 * @version 7/11/19
 **/

public class CheckoutQueue {

    private Customer first, last;

    public CheckoutQueue(){
        first = last = null;
    }
    public boolean isEmpty(){
        return first == null; //first/last will be null if nothing is there
    }

    //enqueue to add people to the back of the line
    public void enqueue(Customer person){

        if(isEmpty()){
            //if line is empty, person becomes first person in line
            first = person;
        }
        else{
            //if someone is already in line, this person is referenced in the last spot
            last.setNext(person);
        }
        //since person is added to the back of the line, they become last
        last = person;
    }

    //dequeue to remove the first person in line, returns first person in line
    public Customer dequeue(){

        if(isEmpty()){
            return null;
        }
        //temp for first person
        Customer temp = first;

        //set first to second person in line
        first = first.getNext();

        //if they were last in line, make last null
        if(isEmpty()){
            last = null;
        }
        return temp;
    }

    //getter method that returns first person in line
    public Customer getFirst(){
        return first;
    }
}
