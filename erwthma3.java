public class erwthma3 {


	    public static void main(String[] args) {

	    	int numThreads = 10; 
	    	Thread[] helloThreads = new Thread[numThreads];
	    	Thread[] newYearCountdownThreads = new Thread[numThreads];
	    	
	    	
	    	//	Create and start Threads     	
	    	for(int i=0; i<numThreads; i++) {
	    		helloThreads[i] = new HelloThread(i);
	    		newYearCountdownThreads[i] = new NewYearCountdownThread(i);
	    		helloThreads[i].start();
	    		newYearCountdownThreads[i].start();
	    	}
	    	// Wait for Threads    	
	    	for(int i=0; i<numThreads; i++) {
	    		
	    		try {
					helloThreads[i].join();
					newYearCountdownThreads[i].join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		
	    	}
	    	
	    	//	Program end
	    	System.out.println("End of Program");
	    		
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


