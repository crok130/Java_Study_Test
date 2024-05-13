package object_array_guide.account;

import java.util.Scanner;

public class BankApplication {
	
	Account[] account = new Account[100];
	
	Scanner sc = new Scanner(System.in);
	int count = 0;
	BankApplication(){
		run();
	}
	
	void run() {
		// 1. 계좌생성
		// 2. 계좌조회 
		// 3. 예금
		// 4. 출금
		// 5. 종료
		boolean isRun = true;
		
		while(isRun) {
			System.out.println("========================================");
			System.out.println("1.계좌생성 2.계좌조회 3.예금 4.출금 5.종료");
			System.out.println("========================================");
			
			int selectNo = sc.nextInt();
			if(selectNo == 1) {
				// 계좌생성
				createAccount();
			}else if(selectNo ==2) {
				// 계좌조회
				selectAccount();
			}else if(selectNo ==3) {
				// 예금
				deposit();
			}else if(selectNo ==4) {
				// 출금
				withdraw();
			}else if(selectNo ==5) {
				// 종료
				isRun = false;
				sc.close();
			}
		}
		System.out.println("프로그램 종료");
	}
	
	
	//계좌생성
	void createAccount() {
		System.out.println("---------------");
		System.out.println("계좌생성");
		System.out.println("---------------");
		System.out.println("계좌주 : ");
		String owner = sc.next(); // 계좌 수유주 이름을 문자열로 입력받음.
		
		System.out.print("계좌번호 : ");
		// 계좌번호를 문자열로 입력받음.
		String ano = sc.next();
		
		System.out.println("초기입금액 : ");
		// 초기입금액을 정수 타입의 int 타입으로 입력받아 저장.
		int balance = sc.nextInt();
		
		System.out.println("비밀번호 : ");
		// 비밀번호를 문자열로 입력받아 저장.
		String password = sc.next();
		
		// 계좌 정보를 저장하는 객체 생성
		Account newAccount = new Account();
		newAccount.ano = ano;
		newAccount.owner = owner;
		newAccount.balance = balance;
		newAccount.password = password;
		//   0            1     2    3      4 .......... 99
		// [newAccount][null][null][null][null] .......[null]
		// account[0] == null : 아직 계좌정보가 등록되지않은 항목
		// account[0] = newAccount;
		for(int i = 0; i < account.length; i++){
			// account배열의 각 항목을 순회 하면서 빈자리(null)를 찾아
			// 새로 생성한 account 객체 정보를 동록시키고 반복문을 종료
			if(account[i] == null) {
				account[i] = newAccount;
				System.out.println("계좌 생성이 완료 되었습니다.");
				break;
				
			}
		}
	}
	
	// 계좌조회
	void selectAccount() {
		System.out.println("-----------------");
		System.out.println("계좌 조회");
		System.out.println("-----------------");
		System.out.print("계좌번호 : ");
		String ano = sc.next();
		
		System.out.print("비밀번호 : ");
		String password = sc.next();
		
		// 등록된 계좌정보들 중에 계좌번호와 비밀번호가 일치하는지 Account 객체 조회
		for(int i = 0; i < account.length; i++) {
			// account[i] 항목에 할당된  Account객체가 존재하는지 확인
			if(account[i] != null) {
				// Account객체가 존재하면 각 계좌번호 비밀번호 필드의 값과
				// 사용자가 입력한 계좌번호와 비밀번호의 문자열이 일치하는지 비교
				if(account[i].ano.equals(ano) && account[i].password.equals(password)) {
					String info = account[i].toString();
					// 계좌번호 비밀번호가 일치하는 계좌정보를 콘솔에 출력
					System.out.println(info);
					break;
				}	// end 계좌정보 칠치 확인 if
			}
		}
		Account registAccount = findAccount(ano, password);
		if(registAccount == null) {
			System.out.println("일치하는 계좌정보가 존재하지 않습니다.");
		}else {
			System.out.println(registAccount.toString());
		}
	}
	
	// 예금
	void deposit() {
		System.out.println("---------------");
		System.out.println("계좌입금");
		System.out.println("---------------");
		System.out.println("계좌번호 : ");
		String ano = sc.next();
		System.out.println("비밀번호 : ");
		String password = sc.next();
		
		// 입금 기능을 수행할 계좌 정보 검색
		Account registAccount = findAccount(ano, password);
		if(registAccount == null) {
			System.out.println("일치하는 계좌정보가 존재하지 않습니다.");
		}else {
			System.out.println("입금액 : ");
			int money = sc.nextInt();
			registAccount.balance += money;
			System.out.printf("%s님의 계좌에 %d원이 입금되었습니다. 잔고는%d원 %n",registAccount.ano,money,registAccount.balance);
		}
		
	}
	//출금
	void withdraw() {
		System.out.println("---------------");
		System.out.println("계좌출금");
		System.out.println("---------------");
		System.out.println("계좌번호 : ");
		String ano = sc.next();
		System.out.println("비밀번호 : ");
		String password = sc.next();
		
		// 계좌번호와 비밀본호가 일치하는 계좌정보 검색
		Account registAccount = findAccount(ano, password);
		if(registAccount == null) {
			System.out.println("잘못된 정보를 입력하셨습니다.");
			return; // withdraw()종료
		}else {
			System.out.println("출금액 : ");
			int money = sc.nextInt();
			// 계좌 잔고에서 money만큼 차감한 금액을 result에 저장
			int result = registAccount.balance - money;
			
			// 잔고 보다 큰 근액을 출금 요청
			if(result < 0) {
				System.out.println("잔고 부족");
				return;
			}
			registAccount.balance = result;
			
			System.out.printf("%s님의 계좌에 %d원이 출금되었습니다. 잔고는%d원 %n",registAccount.ano,money,registAccount.balance);
		}
		
	}
	
	// 계좌번호와 비밀번호가 일치하는 Account 객체를 찾아서 반환 
	Account findAccount(String ano, String password) {
		for(int i = 0; i < account.length; i++) {
			if(account[i] != null && account[i].ano.equals(ano) && account[i].password.equals(password)) {
				// account[i] 번째 항목에 계좌정보가
				// 매개변수로 전달된 계좌번호와 비밀번호가 일치하는 계좌정보
				return account[i];
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		new BankApplication();
	}
}
