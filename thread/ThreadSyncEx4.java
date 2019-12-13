class ThreadSyncEx4 {
	public static void main(String args[]) {
		MyThread th1 = new MyThread("*");
		MyThread th2 = new MyThread("**");
		MyThread th3 = new MyThread("***");
		th1.start();
		th2.start();
		th3.start();

		try {
			Thread.sleep(2000);
			th1.suspend();
			Thread.sleep(2000);
			th2.suspend();
			Thread.sleep(3000);
			th1.resume();
			Thread.sleep(3000);
			th1.stop();
			th2.resume();
			th2.stop();
			Thread.sleep(2000);
			th3.stop();
		} catch (InterruptedException e) {}
	}
}

class MyThread implements Runnable {
	static final int RUNNING = 0;
	static final int SUSPENDED = 1;
	static final int STOPPED = 2;

	private int state = RUNNING;
	Thread th;
	
	MyThread(String name) {
		th = new Thread(this, name);	// Thread(Runnable r, String name)
	}

	public synchronized void setState(int state) {
		this.state = state;
		
		// state가 SUSPENDED였다가 RUNNING으로 변경되면, notify()를 호출한다
		if(state == RUNNING) {
			notify();
		} else {
			th.interrupt();
		}
	}

	public synchronized boolean checkState() {
		// state가 SUSPENDED면 wait()을 호출해서 스레드를 대기상태로 만들고,
		while(state == SUSPENDED) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}

		// state가 STOPPED이면 true를, 그 외에는 false를 리턴한다
		return state == STOPPED;
	}

	public void run() {
		String name = Thread.currentThread().getName();

		while(true) {
			System.out.println(name);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}

			//state가 STOPPED이면 checkState()가 true를 반환해서
			//while문을 벗어나게 된다
			if(checkState()) {
				break;
			}
		}
		System.out.println(name+" - END");
	}

	public void suspend() {
		setState(SUSPENDED);
	}

	public void resume() {
		setState(RUNNING);
	}

	public void stop() {
		setState(STOPPED);
	}

	public void start() {
		th.start();
	}
}
