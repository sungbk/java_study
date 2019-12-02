import java.util.*;

class history_command {
	static Queue q = new LinkedList();
	static final int MAX_SIZE = 5;

	public static void main(String[] args) {
		System.out.println("Help를 입력하면 도움말을 볼 수 있습니다.");

		while(true) {
			System.out.print(">>");
			try {
				Scanner s = new Scanner(System.in);
				String input = s.nextLine().trim();
				
				if ( "".equals(input)) continue;
				
				if(input.equalsIgnoreCase("q")) {
					System.exit(0);
				} else if(input.equalsIgnoreCase("help")) {
					System.out.println("help - 도음말");
					System.out.println("q 또는 Q - 프로그램 종료");
					System.out.println("history - 최근에 입력한 명렁어를 보여준다");
				} else if (input.equalsIgnoreCase("history")) {
					int i = 0;
					save(input);

					LinkedList tmp = (LinkedList)q;
					ListIterator it = tmp.listIterator();
					
					while(it.hasNext()) {
						System.out.println(++i+"."+it.next());
					}
				} else {
					save(input);
					System.out.println(input);
				}
			} catch (Exception e) {
				System.out.println("입력 오류");
			}
		}
	}
	
	public static void save(String input) {
		if(!"".equals(input)) {
			q.offer(input);
		}

		if( ((LinkedList)q).size() > MAX_SIZE ) {
			q.remove();
		}
	}
}
