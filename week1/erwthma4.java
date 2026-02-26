public class erwthma4 {


	    public static void main(String[] args) {

	    	int numThreads = 10; 
	    	Thread[] multiplesThreads = new Thread[numThreads];
	    	
	    	
	    	//	Create and start Threads     	
	    	for(int i=0; i<numThreads; i++) {
	    		multiplesThreads[i] = new MultiplesThread(i);
	
	    		multiplesThreads[i].start();
	    	}
	    	// Wait for Threads    	
	    	for(int i=0; i<numThreads; i++) {
	    		
	    		try {
					multiplesThreads[i].join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		
	    	}
	    	
	    	//	Program end
	    	System.out.println("End of Program");
	    		
	    }  
	       
	}

class MultiplesThread extends Thread {
	
	private int myID;
	
	public MultiplesThread(int id) {
		myID = id;
	}
	
	public void run() {
		for(int i = 1; i<=20; i++) {
			int product = i * (myID + 1); 
			System.out.println(i + " * " + (myID + 1) + " = " + product);
		}
		
		
	}
	
}

/* Απάντηση στην ερώτηση του ερωτήματος 4
 * Όταν απομονωνουμε τις εκτυπωσεις ενός νήματος, οι εκτυπώσεις είναι σειριακές και με σωστή σειρά
 * Ενώ όταν εκτυπώνουν ταυτόχρονα όλα τα νήματα, οι εκτυπώσεις μπλέκονται μεταξύ τους και δεν μπορούμε να προβλέψουμε την σειρά καθώς σε κάθε 
 * εκτέλεση είναι διαφορετική.
 *  */



