/* 싱글쓰레드 예제 */
class ThreadEx4 {
	public static void main(String args[]) {
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < 300; i++) {
			System.out.print("-");
		}
		System.out.println("소요시간1:"+(System.currentTimeMillis() - startTime));
		startTime = System.currentTimeMillis();

		for(int i = 0; i < 300; i++) {
			System.out.print("|");
		}
		System.out.println("소요시간2:"+(System.currentTimeMillis() - startTime));
	}
}
