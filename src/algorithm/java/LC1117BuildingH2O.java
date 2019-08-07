package algorithm.java;

import java.util.concurrent.Semaphore;

public class LC1117BuildingH2O {

    public static void main(String[] args) {
        H2O h2o = new H2O();
        for (int i = 0; i < 20; i ++) {
            new Thread(() -> {
                try {
                    h2o.hydrogen(() -> System.out.print("H"));
                } catch (Exception e) {
                }
            }).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    h2o.oxygen(() -> System.out.print("O"));
                } catch (Exception e) {
                }
            }).start();
        }
    }
}

class H2O {

    private Semaphore semaphoreH;
    private Semaphore semaphoreO;

    public H2O() {
        semaphoreH = new Semaphore(2);
        semaphoreO = new Semaphore(0);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        semaphoreH.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        semaphoreO.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        semaphoreO.acquire(2);
        releaseOxygen.run();
        semaphoreH.release(2);
    }
}
