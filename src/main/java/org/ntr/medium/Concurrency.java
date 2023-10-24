package org.ntr.medium;

import java.util.concurrent.Semaphore;

public class Concurrency {

    private static int recResult = 0;
    private static final Semaphore foo = new Semaphore(1);
    private static final Semaphore bar = new Semaphore(0);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("result: " + "");
        foo.acquire();
        foo.release();
    }


}