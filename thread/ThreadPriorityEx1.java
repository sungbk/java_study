class ThreadPriorityEx1 {
	public static void main(String[] args) {
		ThreadPEx1 th1 = new ThreadPEx1();
		ThreadPEx2 th2 = new ThreadPEx2();

		th2.setPriority(3);

		System.out.println("Priority of th1(-) : " 
				+ th1.getPriority() );
		System.out.println("Priority of th2(|) : "
		+ th2.getPriority() );
		
		th1.start();
		th2.start();
	}
}

class ThreadPEx1 extends Thread {
	public void run() {
		for(int i = 0; i < 300; i ++) {
			System.out.print("-");
			for(int x = 0; x < 100000000; x++);
		}
	}
}

class ThreadPEx2 extends Thread {
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print("|");
			for(int x = 0; x < 100000000; x++);
		}
	}
}
