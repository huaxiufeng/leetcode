package algorithm.java;

import java.util.concurrent.Semaphore;

public class LC1114PrintInOrder {

    public static void main(String[] args) {
        Foo foo = new Foo();
        new Thread(() -> {
            try {
                foo.third(() -> System.out.print("third"));
            } catch (Exception e) {
            }
        }).start();
        new Thread(() -> {
            try {
                foo.second(() -> System.out.print("second"));
            } catch (Exception e) {
            }
        }).start();
        new Thread(() -> {
            try {
                foo.first(() -> System.out.print("first"));
            } catch (Exception e) {
            }
        }).start();
    }
}

class Foo {

    Semaphore semaphore2;
    Semaphore semaphore3;

    public Foo() {
        semaphore2 = new Semaphore(0);
        semaphore3 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        semaphore2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphore2.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        semaphore3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        semaphore3.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
