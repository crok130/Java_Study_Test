package encapsulation_obj_array.book;

import java.util.Scanner;

public class BookManagement {
	
	// 문자열 입력
	private Scanner scanLine = new Scanner(System.in);
	// 선택번호 입력
	private Scanner scanSelectnum = new Scanner(System.in);
	
	// 도서목록을 저장할 배열
	private static Book[] books = new Book[100];
	// 프로그램 실행 flag
	private boolean isRun = true;
	// 메인 메뉴 선택 번호
	private int selectNo = 0;
	
	public BookManagement(){}
	
	public void run() {
		while(isRun) {
			System.out.println("================================================");
			System.out.println("1.도서등록 | 2. 도서목록 | 3.도서수정 | 4.도서삭제 | 5. 종료");
			System.out.println("================================================");
			selectNo = getSelectNum("번호를 선택하세요>");
			
			switch(selectNo) {
				case 1 :
					registerBook();
					break;
				case 2 :
					selectBook();
					break;
				case 3 :
					updateBook();
					break;
				case 4 : 
					deleteBook();
					break;
				case 5 : 
					terminate();
					break;	
				default : 
					System.out.println("등록된 메뉴가 아닙니다.");
			} // end switch
		} // end while
	} // end run method
	
	// 프로그램 종료
	public void terminate() {
		this.isRun = false;
		System.out.println("프로그램 종료");
	}

	// 도서 등록
	public void  registerBook() {
		System.out.println("1. 도서등록");
		String title = getData("등록할 도서의 제목을 입력해 주세요 >");
		String author = getData("등록할 도서의 저자를 입력해 주세요 >");
		for(int i = 0; i < books.length; i++) {
			if(books[i] == null) {
				books[i] = new Book(i+1,title,author);
				return;
			}
		}
		System.out.println("등록완료");
		
	}
	
	// 도서 목록 출력
	public void selectBook() {
		System.out.println("2. 도서목록");
		for(int i = 0; i < books.length; i++) {
			if(books[i] != null) {
				System.out.println(books[i].toString());
			}
		}
	}

	// 도서 정보 수정
	public void updateBook() {
		System.out.println("3. 도서수정");
		int bookNum = getSelectNum("수정 하실 책의 관리번호를 입력해주세요.");
		Book bookUp = findBook(bookNum);
		if(bookUp == null) {
			System.out.println("잘못된 번호입니다.");
			return;
		}
		
		System.out.println(bookUp.toString());
		while(isRun) {
			System.out.println("===================================");
			System.out.println("1.제목 수정 | 2. 저자 수정 | 3.수정 완료 ");
			System.out.println("===================================");
			selectNo = getSelectNum("번호를 선택하세요>");
			switch(selectNo) {
				case 1 : 
					String retitle = getData("제목 입력");
					bookUp.setTitle(retitle);
					System.out.println("제목 수정 완료");
					break;
				case 2 :
					String reauthor = getData("저자 입력");
					bookUp.setAuthor(reauthor);
					System.out.println("저자 수정 완료");
					break;
				case 3 :
					return;
				default :
					System.out.println("없는 번호입니다 다시 입력해주세요");
					break;
			}

		}	
		
	}
	
	// 도서 목록에서 책 정보 삭제
	public void deleteBook() {
		System.out.println("4. 도서삭제");
		int bookNum = getSelectNum("삭제할 도서의 관리번호를 입력해주세요.");
		for(int i = 0; i < books.length; i++) {
			if(books[i] != null && books[i].getNum() == bookNum) {
				books[i] = null;
				System.out.println("삭제완료");
				break;
			}
		}
	}
	
	// 도서관리번호로 책 정보 찾기
	public Book findBook(int num) {
		for(int i = 0; i < books.length; i++) {
			if(books[i] != null && books[i].getNum() == num) {
				return books[i];
			}
		}
		return null;
	}
	
	// 사용자에게 메시지를 전달 받아 출력하고 문자열 값 받아 반환
	String getData(String message) {
		System.out.println(message);
		return scanLine.nextLine();
	}
	
	// 번호 선택 받기
	int getSelectNum(String message) {
		System.out.println(message);
		if(!scanSelectnum.hasNextInt()) {
			System.out.println("숫자를 입력해주세요.");
			scanSelectnum.next();
			return 0;
		}
		return scanSelectnum.nextInt();
	}
		
} // end BookManagement class




