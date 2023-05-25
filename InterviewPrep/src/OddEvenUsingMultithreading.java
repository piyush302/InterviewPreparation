
public class OddEvenUsingMultithreading implements Runnable{
	Object obj = null;
	static int counter =1;
	OddEvenUsingMultithreading(Object obj){
		this.obj=obj;
	}
	@Override
	public void run() {
		while(counter<=10) {
			if(counter%2==0 && Thread.currentThread().getName().equals("Even")) {
				synchronized (obj) {
					System.out.println(counter+" "+Thread.currentThread().getName());
					counter++;
					try {
						obj.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}

			}if(counter%2!=0 && Thread.currentThread().getName().equals("Odd")) {
				synchronized (obj) {
					System.out.println(counter+" "+Thread.currentThread().getName());
					counter++;
					obj.notify();
				}
				
			}
		}
		
	}
	
	

}
