/**This program will contain the priority queue for the customers in line at a grocery store. It will be using a heap
 * so that the customers are helped in the order they arrive, with the highest priority next up in line.
 *
 * @author Amber Sibel
 * @version 7/19/19
 **/

public class PriorityQueue {

    private PriorityCustomer[] heap;
    private int size;

    public PriorityQueue(){
        heap = new PriorityCustomer[30];
        size = 0;
    }
    //adds people to the back of the line
    public void add(PriorityCustomer person){
        //make sure heap's not full
        if(size + 1 >= heap.length){
            return;
        }
        size++;

        heap[size] = person;

        int index = size;

        while(index > 2){ //don't replace the first person in line
            int parentIndex = index / 2;

            if(heap[index].getPriority() > heap[parentIndex].getPriority()){
                //swap
                PriorityCustomer temp = heap[index];
                heap[index] = heap[parentIndex];
                heap[parentIndex] = temp;

                index = parentIndex;
            }
            else{
                break;
            }
        }
    }
    //removes the first person in line, returns first person in line
    public PriorityCustomer remove(){
        //make sure heap's not empty
        if(size == 0){
            return null;
        }
        //variable to return at the end
        PriorityCustomer temp = heap[1];  //removing the one in the front of the line, at the top of the heap

        //move last customer in line to fill the spot
        heap[1] = heap[size];
        heap[size] = null; //nothing is there any longer
        size--;

        int index = 1;

        //compare to other people in line to get correct priority order, highest being in front (top)
        while(index <= size / 2){
            int leftIndex = index * 2;
            int rightIndex = leftIndex + 1;
            int leftValue = heap[leftIndex].getPriority();
            int rightValue = Integer.MIN_VALUE;
            //check if right exists
            if(rightIndex <= size){
                rightValue = heap[rightIndex].getPriority();
            }

            //check to see who has higher priority
            int largerValue;
            int largerIndex;

            if(rightValue > leftValue){
                largerValue = rightValue;
                largerIndex = rightIndex;
            } else{
                largerValue = leftValue;
                largerIndex = leftIndex;
            }

            //check swap
            if(heap[index].getPriority() < largerValue){
                PriorityCustomer swap = heap[index];
                heap[index] = heap[largerIndex];
                heap[largerIndex] = swap;

                index = largerIndex;
            } else{
                break;
            }
        }
        return temp;
    }
    //getter method that returns first person in line
    public PriorityCustomer getFirst(){ return heap[1];}

    //isEmpty method to see if there is anyone in the line
    public boolean isEmpty(){
        return heap[1] == null;
    }
}
