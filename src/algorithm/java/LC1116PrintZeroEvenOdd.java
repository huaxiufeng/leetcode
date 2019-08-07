package algorithm.java;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * The same instance of ZeroEvenOdd will be passed to three different threads:
 *
 * Thread A will call zero() which should only output 0's.
 * Thread B will call even() which should only ouput even numbers.
 * Thread C will call odd() which should only output odd numbers.
 * Each of the threads is given a printNumber method to output an integer. Modify the given program to output the series 010203040506... where the length of the series must be 2n.
 */
public class LC1116PrintZeroEvenOdd {

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(10);
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(new PrintNumber());
            } catch (Exception e) {
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.even(new PrintNumber());
            } catch (Exception e) {
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd(new PrintNumber());
            } catch (Exception e) {
            }
        }).start();
    }
}

class PrintNumber implements IntConsumer {
    @Override
    public void accept(int value) {
        System.out.print(value);
    }
}

class ZeroEvenOdd {
    private int n;
    private volatile int cur;
    private Semaphore semaphoreZero;
    private Semaphore semaphoreEven;
    private Semaphore semaphoreOld;

    public ZeroEvenOdd(int n) {
        this.n = n;
        semaphoreZero = new Semaphore(1);
        semaphoreEven = new Semaphore(0);
        semaphoreOld = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            semaphoreZero.acquire();
            printNumber.accept(0);
            if (cur % 2 == 0) {
                semaphoreOld.release();
            } else {
                semaphoreEven.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i+=2) {
            semaphoreEven.acquire();
            printNumber.accept(i);
            cur = i;
            semaphoreZero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i+=2) {
            semaphoreOld.acquire();
            printNumber.accept(i);
            cur = i;
            semaphoreZero.release();
        }
    }
}
