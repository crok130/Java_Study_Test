package encapsulation_obj_array_answer.book;

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
			}
		}
	}
	
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
		
		// books 배열에 저장하기 위한 Book 객체 생성
		Book book = new Book();
		/*
		private field Book class block 외부에서 직접 접근 불가
		book.title = title;
		book.author = author;
		*/
		book.setTitle(title);
		book.setAuthor(author);
		// books 배열의 빈자리
		for(int i = 0; i < books.length; i++) {
			if(books[i] == null) {
				// 도서 관리 번호 등록
				// 도서가 저장된 index번호를 이용하여 도서관리 번호 등록
				book.setNum(i+1);
				books[i] = book;
				System.out.println("등록 완료");
				// 책 정보를 빈자이레 등록 완료 했으므로 반복문 종료
				break;
			}
		}
	}
	
	// 도서 목록 출력
	public void selectBook() {
		System.out.println("2. 도서목록");
		for(Book b : books) {
			if(b != null) {
				String info = b.toString();
				System.out.println(info);
			} // 배열 항목에 저장된 값이 null 이 아닐때 출력
		}
	}

	// 도서 정보 수정
	public void updateBook() {
		System.out.println("3. 도서수정");
		int bookNum = getSelectNum("수정 하실 책의 관리번호를 입력해주세요.");
		// 사용자가 작성한 도서관리번호로
		// 수정할 책 정보를 검색
		Book updateBook = findBook(bookNum);
		if(updateBook == null) {
			System.out.println("입력하신ㄴ 번호의 책이 존재 하지 않습니다.");
			return; // updateBook(); 즉시 종료
		}
		
		// 도서관리번호가 일치하는 책을 찾아서 출력
		System.out.println(updateBook.toString());
		
		// 책 정보 출력
		// 1. 제목수정, 2.저자수정, 3.수정완료
		boolean isUpdate = true;
		while(isUpdate) {
			System.out.println("================================");
			System.out.println("1.제목수정 | 2. 저자수정 | 3.수정완료 ");
			System.out.println("================================");
			int selctNo = getSelectNum("번호 입력 > ");
			switch(selctNo) {
				case 1 :
					System.out.println("제목 수정");
					// updateBook 의 책 제목 수정
					String title = getData("제목 입렵 > ");
					updateBook.setTitle(title);
					System.out.println("제목 수정 완료");
					break;
				case 2 :
					System.out.println("저자 수정");
					String author = getData("저자 입렵 > ");
					updateBook.setAuthor(author);
					System.out.println("저자 수정 완료");
					break;
				case 3 :
					System.out.println("수정 완료");
					isUpdate = false;
					break;
				default :
					System.out.println("없는 번호입니다");
			}
		}
	}
	
	// 도서 목록에서 책 정보 삭제
	public void deleteBook() {
		System.out.println("4. 도서삭제");
		int bookNum = getSelectNum("삭제할 도서의 관리번호를 입력해주세요.");
		// 삭제할 책이 존재하는지 검색
		Book book = findBook(bookNum);
		if(book == null) {
			System.out.println("입력하신 관리버호의 책이 존재하지 않습니다-");
			return;
		}
		
		// books 배열 순회 하면서 일치하는 책을 검색
		for(int i = 0; i < books.length; i++) {
			if(books[i] != null && books[i] == book){
				books[i] = null;
				System.out.println("삭제 완료");
				break;
			}
		}
	}
	
	// 도서관리번호로 책 정보 찾기
	public Book findBook(int num) {
		for(Book b : books) {
			if(b != null && b.getNum() == num) {
				// books 배열에 저장된 Book 객체 중에
				// 도서관리번호가 일치하는 책을 찾아서 반환
				return b;
			}
		}
		// 반복문이 종료 도;ㄹ때 까지 일치하는 책을 찾이 못하면
		// 도서관리 번호가 일치하는 책이 존재하지 않음.
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
		
}




