package assig3_2;

public class HeavyWorker {
    MySemaphore section1 = new MySemaphore(3);
    MySemaphore section2 = new MySemaphore(1);
    MySemaphore workB = new MySemaphore(0);
    //MySemaphore workA = new MySemaphore(1);
    public void section1() {

        System.out.println(Thread.currentThread().getName() + " is in section1");
        try {
            /* sleep to simulate some work... */
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        System.out.println(Thread.currentThread().getName() + " leaving section1");

    }

    public void section2() {

        System.out.println(Thread.currentThread().getName() + " is in section2");
        try {
            /* sleep to simulate some work... */
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        System.out.println(Thread.currentThread().getName() + " leaving section2");
    }

    public void workA() {
        section1.down();
        System.out.println(Thread.currentThread().getName() + " doing workA");
        /* section1() can be called from up to 3 threads at the same time */
        section1();
        /* section2() can be called from one thread out of the 3 above    */
        section2.down();
        section2();
        section1.up();
        section2.up();
        workB.up();
    }

    public void workB() {
        workB.down();
        section2.down();
        /* this will be printed only after workA() done at least once */
        System.out.println(Thread.currentThread().getName() + " doing workB");
        section2.up();
        workB.up();

    }

}
