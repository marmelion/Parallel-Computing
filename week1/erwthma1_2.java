/* Απάντηση στην ερώτηση του ερωτήματος 1
 * Αν δεν χρησιμοποιήσουμε δομή δεδομένων για την αποθήκευση των νημάτων, δεν έχουμε αναφορά στα αντικείμενα Thread.
 * Χωρίς αναφορά στα νήματα δεν μπορούμε να καλέσουμε τη μέθοδο join(), με αποτέλεσμα η main() να μην περιμένει την ολοκλήρωση των νημάτων 
 * και το πρόγραμμα να συνεχίζει την εκτέλεσή του ενώ τα νήματα ακόμα τρέχουν.
 */

public class erwthma1_2 {


	    public static void main(String[] args) {

	    	Thread helloThread = new HelloThread(0) ;
	    	Thread newYearCountdownThread = new NewYearCountdownThread(0) ;
	    	
	    	newYearCountdownThread.start();
	    	helloThread.start();
	    		    	
	    	try {
				helloThread.join();
				newYearCountdownThread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    	
	    	
	    }  
	       
	}

class HelloThread extends Thread {
	
	private int myID;
	
	public HelloThread(int id) {
		myID = id;
	}
	
	public void run() {
		System.out.println("Hello from thread " + myID);
	}
	
}

class NewYearCountdownThread extends Thread{
	
	private int myID;

	public NewYearCountdownThread(int id) {
		myID = id;
	}
	
	public void run() {
		for(int i=3; i>0; i--) {
			System.out.println(i);
		}
		System.out.println("Thread " + myID +  " wishes Happy Year!");
	}
}


