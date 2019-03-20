package com.example.helloWorld.restfulwebservices.core.java.practice;

public class MultiThreadingTest {

	public static void main(String[] args) {
		Counter counter = new Counter();
		MyThread1 myThread1 = new MyThread1(counter);
		myThread1.setName("MyThread1");
		myThread1.start();
		MyThread2 myThread2 = new MyThread2(counter);
		myThread2.setName("MyThread2");
		myThread2.start();
	}

}

class Counter {
	protected int count = 0;

	public synchronized void add(int value) {
		this.count = this.count + value;
	}

	public synchronized int getCount() {
		return count;
	}

}

class MyThread1 extends Thread {
	Counter counter;

	public MyThread1(Counter counter) {
		super();
		this.counter = counter;
	}

	@Override
	public void run() {
		// System.out.println(Thread.currentThread().getName());
		for (int i = 0; i < 11; i++) {
			counter.add(i);
			System.out.println(counter.getCount() + " " + Thread.currentThread().getName());
		}

	}

}

class MyThread2 extends Thread {
	Counter counter;

	public MyThread2(Counter counter) {
		super();
		this.counter = counter;
	}

	@Override
	public void run() {
		// System.out.println(Thread.currentThread().getName());
		for (int i = 0; i < 11; i++) {
			counter.add(i);
			System.out.println(counter.getCount() + " " + Thread.currentThread().getName());
		}

	}

}