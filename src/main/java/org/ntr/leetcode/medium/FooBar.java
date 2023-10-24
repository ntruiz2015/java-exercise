package org.ntr.leetcode.medium;

import java.util.concurrent.Semaphore;

public class FooBar {

    private final int n;
    private final Semaphore foo = new Semaphore(1);
    private final Semaphore bar = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            foo.acquire();
            printFoo.run();
            bar.release();
            System.out.println("foo --> foo available permits: " + foo.availablePermits());
            System.out.println("foo --> bar available permits: " + bar.availablePermits());
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            bar.acquire();
            printBar.run();
            foo.release();
            System.out.println("bar --> foo available permits: " + foo.availablePermits());
            System.out.println("bar --> bar available permits: " + bar.availablePermits());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FooBar fooBar = new FooBar(5);
        Thread foo = new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.println("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread bar = new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.println("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        foo.start();
        bar.start();

        foo.join();
        bar.join();
    }

}
