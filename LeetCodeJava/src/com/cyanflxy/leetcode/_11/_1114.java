package com.cyanflxy.leetcode._11;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cyanflxy
 * @since 2021.07.22
 */
public class _1114 {

    public static void main(String[] args) {
        final Foo foo = new Foo();


        new Thread(() -> {
            try {
                foo.second(() -> System.out.println("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                foo.first(() -> System.out.println("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                foo.third(() -> System.out.println("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    static class Foo {

        private AtomicInteger step = new AtomicInteger(0);

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            step.incrementAndGet();
            synchronized (this) {
                notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (step.get() != 1) {
                synchronized (this) {
                    wait();
                }
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            step.incrementAndGet();
            synchronized (this) {
                notifyAll();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (step.get() != 2) {
                synchronized (this) {
                    wait();
                }
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
