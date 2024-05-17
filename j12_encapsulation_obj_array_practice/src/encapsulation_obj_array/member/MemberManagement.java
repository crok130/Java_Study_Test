package encapsulation_obj_array.member;

import java.util.Scanner;


public class MemberManagement{
	
	// 사용자에게 정보를 입력받을 필드
	private Scanner sc = new Scanner(System.in);
	
	// 회원목록 정보를 저장할 필드
	private Member[] members = new Member[100];
	
	// 관리자 계정
	private Member master = new Member(100,"master","root","root");
	
	// 로그인된 회원정보를 저장하고 유지할 필드
	private Member loginMember = null;
	
	// 프로그램 flag (true : 진행 , false : 종료) 
	private boolean isRun = true;
	
	// 프로그램 실행용 생성자
	public MemberManagement() {
		// 관리자 계정을 마지막[99]인덱스에 저장
		members[members.length-1] = master;
	}

	public void isRun() {
		System.out.println("프로그램 시작!");
		while (isRun) {
			System.out.println("===========================================================");
			System.out.println("1.회원가입 |2.로그인 |3.회원목록|4.회원정보수정|5.회원탈퇴|6.프로그램종료");
			System.out.println("===========================================================");
			System.out.println("메뉴 선택 > ");
			
			if(!sc.hasNextInt()){
				System.out.println("번호를 입력해주세요. ");
				sc.next();
				continue;
			}

			int selectNo = sc.nextInt();
			
			switch (selectNo) {
				case 1:
					System.out.println("== 회원가입 == ");
					join();
					break;
				case 2:
					System.out.println("== 로그인 == ");
					login();
					break;
				case 3:
					System.out.println("== 회원목록 == ");
					select();
					break;
				case 4:
					System.out.println("== 회원정보수정 == ");
					update();
					break;
				case 5:
					System.out.println("== 회원탈퇴 == ");
					delete();
					break;
				case 6:
					System.out.println("== 종료 == ");
					terminate();
					break;
				default:
					System.out.println("선택할 수 없는 번호입니다.");
			}
		}
	}

	
	private void terminate() {
		isRun = false;
	}

	private void join() {
		
		System.out.println("아이디를 입력해주세요");
		String mId = sc.next();
		System.out.println("비밀번호를 입력해주세요");
		String mPw = sc.next();
		System.out.println("비밀번호를 한번 더 입력해주세요");
		String rePw = sc.next();
		if(!memberIdCheck(mId) || !mPw.equals(rePw)) {
			System.out.println("중복된 아이디 또는 비밀번호가 틀렸습니다");
			return;
		}
		System.out.println("이름을 입력해주세요");
		String mName = sc.next();
		for(int i = 0; i < members.length; i++) {
			if(members[i] == null) {
				members[i] = new Member(i+1,mName,mId,mPw);
				System.out.println("회원가입 완료");
				break;
			}
		}
	}

	private void login() {
		System.out.println("아이디를 입력해주세요 > ");
		String mId = sc.next();
		System.out.println("비밀번호를 입력해주세요 >");
		String mPw = sc.next();
		Member checkMember = new Member(mId,mPw);
		Member acc = findMember(checkMember);
		if(acc == null) {
			System.out.println("일치하는 회원정보가 존재하지 않습니다");
			return;
		}
		
		loginMember = acc;
		System.out.println("정상적으로 로그인 하셨습니다");
		System.out.println(acc.toString());
		if(loginMember == master) {
			System.out.println("관리자 계정입니다.");
		}
		
	}

	// 회원 목록은 관리자만 출력
	private void select() {
		if(loginMember != master) {
			System.out.println("관리자만 확인가능한 메뉴입니다.");
			return;
		}
		for(int i = 0; i < members.length; i++) {
			if(members[i] != null) {
				System.out.println(members[i].toString());
				
			}
		}
	}
	
	private void update() {
		// 개인회원 - 자기정보(이름) 만 수정 가능
		// 관리자 - 전체 회원 정보(이름) 수정 가능
		if (loginMember == null) {
			System.err.println("로그인 후 사용가능 한 메뉴입니다.");
			return;
		}
		
		if (loginMember.equals(master)) {
			// 관리자
			System.out.println("== 관리자 회원정보 수정");
			select();
			System.out.println("수정할 회원 번호를 입력해 주세요.");
			int mNum = sc.nextInt();
			for(int i = 0; i < members.length; i++) {
				if(members[i] != null && members[i].getmNum() == mNum) {
					System.out.println("수정할 회원의 이름을 입력해주세요 > ");
					String name = sc.next();
					members[i].setmName(name);
					return;
				}
			}
			System.out.println("일치하는 사용자를 찾을 수 없음.");
		
		}else {
			System.out.println("== 내 정보 수정 ==");
			System.out.println("비밀번호를 한번 더 입력해 주세요.");
			String pw = sc.next();
			if(loginMember.getmPw().equals(pw)) {
				System.out.println("수정할 이름을 입력해 주세요 > ");
				String name = sc.next();
				loginMember.setmName(name);
				System.out.println("내 정보 수정 완료");
				System.out.println(loginMember.toString());
			}else {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
		}
			
	}

	// 일반 회원만 탈퇴 요청 시 처리 - 배열항목에서 로그인된 회원 정보 삭제
	private void delete() {
		
		if(loginMember == master) {
			System.out.println("관리자는 회원탈퇴가 불가능합니다");
			return;
		}
		System.out.println("정말로 탈퇴하시겠습니까 y/n");
		String yn = sc.next();
		switch(yn) {
			case "y" : case "Y" : case "ㅛ" :
				deleteMember();
				break;
			case "n" : case "N" : case "ㅜ" :
				System.out.println("회원탈퇴가 취소되었습니다.");
				break;
		}
	}
	
	// 사용자 아이디 중복 체크
	// members 배열의 각항목에 존재하는 Member를 확인하여
	// 동일한 mId를 사용중인 사용자가 존재하면 false, 존재하지 않으면 true 반환
	private boolean memberIdCheck(String mId) {	
		for(Member m : members) {
			if(m != null && m.getmId().equals(mId)) {
				return false;
			}
		}
		return true;
	}
	
	// 회원 아이디와 비밀번호로 회원 찾기
	// members 배열의 각항목에 존재하는 Member를 확인하여
	// 매개변수로 전달된 회원의 mId, mPw가 둘다 일치하는 회원정보를 반환
	// null 값을 반환하면 존재하지 않는 회원
	private Member findMember(Member d) {
		for(Member member : members) {
			if(member != null && member.equals(d)) {
				return member;
			}
		}
		return null;
	}
	
	void deleteMember() {
		for(int i=0; i<members.length; i++) {
			if(members[i].equals(loginMember)) {
				members[i] = null;
				loginMember = null;
				System.out.println("회원탈퇴 완료");
				return;
			}
		}
	}
}
