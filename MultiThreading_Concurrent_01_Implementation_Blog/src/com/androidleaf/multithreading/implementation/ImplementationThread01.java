package com.androidleaf.multithreading.implementation;

public class ImplementationThread01 {
	
	public static void main(String[] args) {
		
		/*----------------------实现多线程第一种方式：实现Runable接口----------------------------*/
		MyRunnable myRunnable = new MyRunnable();
		new Thread(myRunnable).start();
		new Thread(myRunnable).start();
		new Thread(myRunnable).start();
	}

}

class MyRunnable implements Runnable{

	private int tickets = 10;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			synchronized (this) {
				if(tickets > 0){
					System.out.println("总票数：" + tickets + "  窗口号："
							+ Thread.currentThread().getName()
							+ " 出售1张        剩下票数：" + --tickets);
				}else{
					System.out.println("车票已卖完！！");
					break;
				}
			}
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

