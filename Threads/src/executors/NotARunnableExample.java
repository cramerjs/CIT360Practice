package executors;

public class NotARunnableExample {

	public void run() {

		for (int i = 0; i < 3; i++) {
			System.out.println("Thread id: " + Thread.currentThread().getName());
			try {
				Thread.currentThread().sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
