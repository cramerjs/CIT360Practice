package executors;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SimpleThreadPoolExample {

	public static void main(String[] args) {

		Executor anExecutor = Executors.newCachedThreadPool();
		for(int threadCnt = 0; threadCnt < 3; threadCnt++) {
//			SimpleRunnableExample aSimpleRunnable = new SimpleRunnableExample();
//			anExecutor.execute(aSimpleRunnable);
			
			// bad stuff
//			InfiniteRunnableExample anInfiniteRunnable = new InfiniteRunnableExample();
//			anExecutor.execute(anInfiniteRunnable);
			
//			EmptyRunnableExample anEmptyRunnable = new EmptyRunnableExample();
//			anExecutor.execute(anEmptyRunnable);
			
			NotARunnableExample aNotARunnableRunnable = new NotARunnableExample();
			anExecutor.execute((Runnable) aNotARunnableRunnable);
		}
		try {
			Thread.sleep(5000);
			System.out.println("Done Sleeping");
			for(int threadCnt = 0; threadCnt < 3; threadCnt++) {
//				SimpleRunnableExample aSimpleRunnable = new SimpleRunnableExample();
//				anExecutor.execute(aSimpleRunnable);
				
				// bad stuff
//				InfiniteRunnableExample anInfiniteRunnable = new InfiniteRunnableExample();
//				anExecutor.execute(anInfiniteRunnable);
				
//				EmptyRunnableExample anEmptyRunnable = new EmptyRunnableExample();
//				anExecutor.execute(anEmptyRunnable);
				
				NotARunnableExample aNotARunnableRunnable = new NotARunnableExample();
				anExecutor.execute((Runnable) aNotARunnableRunnable);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
}
