package com.androidleaf.multithreading.implementation;

public class ImplementationThread02 {

	public static void main(String[] args) {
		
		/*----------------------实现多线程第二种方式：继承Thread类----------------------------*/
	    new MyThread().start();
		new MyThread().start();
		new MyThread().start();
	}
}

class MyThread extends Thread{
	
	private int tickets = 5;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true){
			synchronized (this) {
				if(tickets > 0){
					System.out.println("总票数：" + tickets + "  窗口号："
							+ Thread.currentThread().getName()
							+ "出售1张        剩下票数：" + --tickets);
				}else{
					System.out.println("车票已卖完！！");
					break;
				}
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
