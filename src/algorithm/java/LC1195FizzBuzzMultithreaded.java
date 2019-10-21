package algorithm.java;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class LC1195FizzBuzzMultithreaded {

    public static void main(String[] args) {
        FizzBuzz fb = new FizzBuzz(15);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fb.fizz(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("fizz");
                        }
                    });
                } catch (Exception e) {
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fb.buzz(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("buzz");
                        }
                    });
                } catch (Exception e) {
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fb.fizzbuzz(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("fizzbuzz");
                        }
                    });
                } catch (Exception e) {
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fb.number(new IntConsumer() {
                        @Override
                        public void accept(int value) {
                            System.out.println(value);
                        }
                    });
                } catch (Exception e) {
                }
            }
        }).start();
    }
}

class FizzBuzz {
    private int n;
    private int fizzCount;
    private int buzzCount;
    private int fizzbuzzCount;
    private int numberCount;
    private volatile int cur = 1;
    private Semaphore fizzSem = new Semaphore(0);
    private Semaphore buzzSem = new Semaphore(0);
    private Semaphore fizzbuzzSem = new Semaphore(0);
    private Semaphore numberSem = new Semaphore(1);

    public FizzBuzz(int n) {
        this.n = n;
        this.fizzbuzzCount = n / 15;
        this.fizzCount = n / 3 - this.fizzbuzzCount;
        this.buzzCount = n / 5 - this.fizzbuzzCount;
        this.numberCount = n - this.fizzbuzzCount - this.fizzCount - this.buzzCount;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 0; i < fizzCount; i++) {
            fizzSem.acquire();
            printFizz.run();
            relaseSem();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 0; i < buzzCount; i++) {
            buzzSem.acquire();
            printBuzz.run();
            relaseSem();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 0; i < fizzbuzzCount; i++) {
            fizzbuzzSem.acquire();
            printFizzBuzz.run();
            relaseSem();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < numberCount; i++) {
            numberSem.acquire();
            printNumber.accept(cur);
            relaseSem();
        }
    }

    private void relaseSem() {
        int next = ++cur;
        if (next % 15 == 0) {
            fizzbuzzSem.release();
        } else if (next % 5 == 0) {
            buzzSem.release();
        } else if (next % 3 == 0) {
            fizzSem.release();
        } else {
            numberSem.release();
        }
    }
}
