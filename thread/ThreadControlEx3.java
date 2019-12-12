class ThreadControlEx3 {
	public static void main(String args[]) {
		ThreadControlEx3_1 gc = new ThreadControlEx3_1();
		gc.setDaemon(true);
		gc.start();

		int reqMemory = 0;

		for(int i = 0; i < 20; i ++) {
			reqMemory = (int)(Math.random() * 10) * 20;

			// 필요한 메모리가 사용할 수 있는 양보다 크거나 전체 메모리의 60%이상을
			// 사용했을 경우 gc깨운다
			if(gc.freeMemory() < reqMemory ||
					gc.freeMemory() < gc.totalMemory() * 0.4 ) {
				gc.interrupt();		//자고있는 스레드 t1을 깨운다
			}

			gc.usedMemory += reqMemory;
			System.out.println("Req Mem : ("+reqMemory+") Used Mem : "+gc.usedMemory);
		}
	}
}

class ThreadControlEx3_1 extends Thread {
	final static int MAX_MEMORY = 1000;
	int usedMemory = 0;

	public void run () {
		while(true) {
			try {
				Thread.sleep(10*1000);	//10초를 기다린다
			} catch (InterruptedException e) {
				System.out.println("Awaken by interrupt()");
			}

			gc();
			System.out.println("GC Free Memory :" + freeMemory());
		}
	}

	public void gc() {
		usedMemory -= 300;
		if(usedMemory < 0) usedMemory = 0;
	}

	public int totalMemory() {
		return MAX_MEMORY;
	}

	public int freeMemory() {
		return MAX_MEMORY - usedMemory;
	}
}
