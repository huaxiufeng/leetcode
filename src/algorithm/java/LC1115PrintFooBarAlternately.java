package algorithm.java;

import java.util.concurrent.Semaphore;

public class LC1115PrintFooBarAlternately {

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(5);
        new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.print("foo"));
            } catch (Exception e) {
            }
        }).start();
        new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.print("bar"));
            } catch (Exception e) {
            }
        }).start();
    }
}

class FooBar {
    private int n;
    private Semaphore semaphore1;
    private Semaphore semaphore2;

    public FooBar(int n) {
        this.n = n;
        semaphore1 = new Semaphore(1);
        semaphore2 = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphore1.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            semaphore2.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphore2.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            semaphore1.release();
        }
    }
}
