package GUIDE.account;

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
		  System.out.println("계좌번호 입력: ");
	        String ano = sc.next();
	        System.out.println("계좌주 입력: ");
	        String owner = sc.next();
	        System.out.println("초기 입금액 입력: ");
	        int balance = sc.nextInt();
	        System.out.println("비밀번호 입력: ");
	        String password = sc.next();
	        
	        account[count] = new Account(ano, owner, balance, password);
	        count++;
	        System.out.println("계좌가 생성되었습니다.");
	}
	// 계좌조회
	void selectAccount() {
        System.out.println("조회할 계좌번호 입력: ");
        String ano = sc.next();
        System.out.println("비밀번호 입력: ");
        String password = sc.next();
        Account a = this.findAccount(ano,password);
        if(a != null){
        	System.out.println(a.toString());
        }
        	
        
    }
      
	
	// 예금
	void deposit() {
        System.out.println("조회할 계좌번호 입력: ");
        String ano = sc.next();
        System.out.println("비밀번호 입력: ");
        String password = sc.next();
		Account a = this.findAccount(ano,password);
        if(a != null){
        	System.out.println("예금하실 금액 : ");
        	int balance = sc.nextInt();
        	a.balance += balance;
        }
       
	}
	//출금
	void withdraw() {
        System.out.println("조회할 계좌번호 입력: ");
        String ano = sc.next();
        System.out.println("비밀번호 입력: ");
        String password = sc.next();
		Account a = this.findAccount(ano,password);
        if(a != null){
        	System.out.println("예금하실 금액 : ");
        	int balance = sc.nextInt();
        	a.balance -= balance;
        }
	}
	
	// 계좌번호와 비밀번호가 일치하는 Account 객체를 찾아서 반환 
	Account findAccount(String ano, String password) {
		for(int i = 0; i < account.length; i++) {
			if(account[i] != null) {
				if(ano.equals(account[i].ano) && password.equals(account[i].password)) {
					return account[i];
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		new BankApplication();
	}
}
