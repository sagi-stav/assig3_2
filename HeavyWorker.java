package assig3_2;

public class HeavyWorker {

	public void section1() {
		System.out.println(Thread.currentThread().getName() + " is in section1");
		try {
			/* sleep to simulate some work... */
			Thread.sleep(500);
		} catch (InterruptedException e) {}
		System.out.println(Thread.currentThread().getName() + " leaving section1");
	}
	
	public void section2() {
		System.out.println(Thread.currentThread().getName() + " is in section2");
		try {
			/* sleep to simulate some work... */
			Thread.sleep(500);
		} catch (InterruptedException e) {}
		System.out.println(Thread.currentThread().getName() + " leaving section2");
	}
	
	public void workA() {
		System.out.println(Thread.currentThread().getName() + " doing workA");
		
		/* section1() can be called from up to 3 threads at the same time */
		section1();
		/* section2() can be called from one thread out of the 3 above    */		
		section2();
		
	}
	
	public void workB() {

		/* this will be printed only after workA() done at least once */
		System.out.println(Thread.currentThread().getName() + " doing workB");
	}
	
}
