import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Prod_con {

	public Prod_con() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BlockingQueue<Integer> b_queue = new ArrayBlockingQueue<Integer>(10);
		
		
		Producer_thread producer = new Producer_thread(b_queue);
		Consumer_thread consumer = new Consumer_thread(b_queue);
		
		producer.start();
		consumer.start();
		
	}

}

class Producer_thread extends Thread{
	
	private BlockingQueue<Integer> b_queue;
	
	Producer_thread(BlockingQueue<Integer> b_queue){
		this.b_queue = b_queue;
	}
	
		
	Random random = new Random();

	 public void run() {
		 
		 int i = 0;
	      while (i < 10) {
	        
	    	  int element = random.nextInt(10);
	    	  try {
	        	
	    		  b_queue.put(element);
	    		  System.out.println("produced: "+ element);
	    	  } 
	    	  
	    	  catch (InterruptedException e) {
	        	
	    	  }
	    	  i++;
	      }
	 }
}


class Consumer_thread extends Thread{
	
private BlockingQueue<Integer> b_queue;
	
	Consumer_thread(BlockingQueue<Integer> b_queue){
		this.b_queue = b_queue;
	}
	
	public void run() {
		
		 while (true) {
			 
		        try {
		        	
		          System.out.println("Consumed: " + b_queue.take());
		        } 
		        catch (InterruptedException e) {
		        	
		        	System.out.println("Exception occurred!"+ e);
		        }
		 }
	}
	
	
}