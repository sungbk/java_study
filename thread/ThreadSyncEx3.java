class ThreadSyncEx3 {
	public static void main(String args[]) {
		Runnable r = new RunnableEx();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);

		t1.start();
		t2.start();
	}
}

class Account {
	int balance = 1000;
	
	public synchronized void withdraw(int money) {
		if(balance >= money) {
			try { 
				Thread.sleep(1000); 
			} catch (Exception e) {}
			balance -= money;
		}
	}
}

class RunnableEx implements Runnable {
	Account acc = new Account();
	
	public void run () {
		while(acc.balance > 0) {
			// 100, 200, 300중의 한 값을 임의로 선택해서 withdraw
			int money = (int)(Math.random() * 3 + 1) * 100;
			acc.withdraw(money);
			System.out.println("Balance:"+acc.balance);
		}
	}
}
