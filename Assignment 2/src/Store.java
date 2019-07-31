/**This is the driver containing the main method used with the PriorityQueue and PriorityCustomer classes.
 *
 * @author Amber Sibel
 * @version 7/19/19
 *
 * This program simulates 60 minutes of activity at a store, allowing each run in the loop to represent 1 min.
 * Each minute will have a 25% chance a new customer appears and added to the PriorityQueue, and for the customer
 * in the front of the line to be updated until completely serviced. Once fully serviced (via service time assigned),
 * customer will be removed from the line.
 * Additionally, each customer will have a priority and be sorted in the line according to their priority,
 * with the highest priority being next in line.
 */

public class Store {

    public static void main(String[] args){
        //create the grocery line
        PriorityQueue line = new PriorityQueue();

        int rand = 0; //variable to hold the random number
        int currentLineCount = 0; //variable to keep track of how many are in line
        int totalServiced = 0; //variable to keep track of how many customers were serviced
        int maxLineLength = 0; //max number of people in line

        //loop for 60 iterations (minutes)
        for(int i = 0; i < 60; i++){
            //get a random number between 1-100
            rand = (int)(Math.random()*100) + 1;
            //if 1-25, add a customer (25% chance to add a customer every minute)

            if(rand > 0 && rand < 26){
                PriorityCustomer person = new PriorityCustomer();
                line.add(person);
                currentLineCount++;
                System.out.println("New customer added! Queue length is now " +  currentLineCount);
//                serviceTime = person.getServiceTime();
            }
            if(!(line.isEmpty())) {
                //update first customer in line's service time
                if (line.getFirst().getServiceTime() > 0) {
                    line.getFirst().decServiceTime();
                }
                //if they've been completely serviced, remove from line
                else {
                    line.remove();
                    currentLineCount--;
                    totalServiced++;
                    System.out.println("Customer serviced and removed from queue. Queue length is now " + currentLineCount);
                }
            }
            if(currentLineCount > maxLineLength){
                maxLineLength = currentLineCount;
            }
            //represent passing of time
            System.out.println("----------------------------------------------------------------");
        }
        //show how many were serviced
        System.out.println("Total number of customers serviced: " + totalServiced);
        //maximum line length during simulation
        System.out.println("Maximum line length during simulation: " + maxLineLength);
    }
}
