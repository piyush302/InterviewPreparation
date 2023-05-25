
public class MultiThreading {

	public static void main(String[] args) {
		Object object = new Object();
		Runnable r1 = new OddEvenUsingMultithreading(object);
		Runnable r2 = new OddEvenUsingMultithreading(object);
		Thread t1 = new Thread(r1,"Even");
		Thread t2 = new Thread(r2,"Odd");
		t1.start();
		t2.start();

	}

}
