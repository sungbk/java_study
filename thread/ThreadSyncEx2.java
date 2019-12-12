class ThreadSyncEx2 {
	public static void main(String args[]) {
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();

		t1.start();
		t2.start();
	}
}

class MyThread extends Thread {
	int iv = 0;

	public void run() {

		int lv = 0;

		while(lv < 3) {
			System.out.println(getName() + "Local Var:" + ++lv);
			System.out.println(getName() + "Instance Var:" + ++iv);
			System.out.println();
		}
	}
}

