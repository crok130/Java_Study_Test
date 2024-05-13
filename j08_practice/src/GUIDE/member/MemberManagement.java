package GUIDE.member;

import java.util.Scanner;

public class MemberManagement {

	// 사용자 입력
	Scanner sc = new Scanner(System.in);

	// 회원정보 저장
	Member[] members = new Member[100];

	// 관리자 계정
	Member master = new Member(100, "master", "root", "root");
	int count = 1;
	// 로그인한 회원
	Member loginMember = null;
	int loginNum = 0;
	// 프로그램 flag (true : 진행 , false : 종료)
	boolean isRun = true;
	boolean isrun = true;
	// 메뉴 번호 선택
	int selectNo;
	boolean login = true;
	// 프로그램 실행용 생성자
	MemberManagement() {
		// 회원목록 배열 마지막 인덱스에 관리자 계정 저장
		members[members.length - 1] = master;
		// 회원관리 메소드 호출
		isRun();
	}

	/*
	 * 기능 관리
	 */

	// 프로그램 실행
	void isRun() {
		while (isRun) {
			System.out.println("==================================================");
			System.out.println("1.회원가입 | 2.로그인 | 3.회원목록 | 4.회원정보수정 | 6.종료");
			System.out.println("==================================================");
			int sel = sc.nextInt();
			switch (sel) {
			case 1:
				join();
				break;
			case 2:
				login();
				break;
			case 3:
				select();
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			}
		}
	}

	// 프로그램 종료
	void terminate() {

	}

	// 회원 가입
	void join() {
		System.out.println("회원가입 > ");
		System.out.println("사용자정보를 입력해주세요-----------");
		System.out.println("아이디를 입력해주세요 > ");
		String id = sc.next();
		System.out.println("비밀번호를 입력해주세요 > ");
		String pw = sc.next();
		System.out.println("비밀번호를 확인해주세요 > ");
		String pw1 = sc.next();
		if (!pw.equals(pw1)) {
			System.out.println("비밀번호가 일치하지 않습니다");
			return;
		}
		for (int i = 0; i < members.length; i++) {
			if (members[i] != null) {
				if (members[i].mId.equals(id)) {
					System.out.println("이미사용중인아이디입니다");
					return;
				}
			}
		}
		System.out.println("이름을 입력해주세여 > ");
		String name = sc.next();
		for (int i = 0; i < members.length; i++) {
			if (members[i] == null) {
				members[i] = new Member(count, name, id, pw);
				System.out.println(members[i].toString());
				return;
			}
		}
	}

	// 로그인
	void login() {
		System.out.println("로그인");
		System.out.println("아이디 입력 > ");
		String id = sc.next();
		System.out.println("비밀번호 입력 > ");
		String pw = sc.next();

		for (int i = 0; i < members.length; i++) {
			if (members[i] != null) {
				if (members[i].mId.equals(id) && members[i].mPw.equals(pw)) {
					if(members[i] == master) {
						System.out.println("정상적으로 로그인 되었습니다");
						System.out.println("관리자입니다.");
						System.out.println(members[i].toString());
						loginMember = master;
						break;
					}
					System.out.println("정상적으로 로그인 되었습니다");
					System.out.println(members[i].toString());
					for(int j = 0; j < members.length; j++) {
						if(members[j] != null) {
							members[j].login = false;
						}
					}
						members[i] = new Member(login);
						loginMember = null; 
						break;
				} // end if ID check
			} // end if null
		} // end for
	} // end login()

	// 회원목록 - 로그인한 회원이 관리자 일때만 노출
	void select() {
		if(loginMember == master) {
			for(int i = 0; i < members.length; i++) {
				if(members[i] != null) {
					System.out.println(members[i].toString());
				}
			}
		}else {
			System.out.println("관리자가 아닙니다.");
		}
	}

	// 회원정보 수정 - 로그인한 회원 정보랑 일치 하거나 관리자 일때만 수정(이름정보만 수정)
	void update() {
		System.out.println("획원정보수정 > ");
		System.out.println("내정보 수정 --------");
		System.out.println("");
	}

	// 회원탈퇴 - 삭제 할려는 정보가 본인 정보일때만 삭제
	void delete() {

	}

	// 사용자 아이디 중복 체크
	boolean memberIdCheck(String mId) {
		for (Member m : members) {
			if (m != null && m.mId.equals(mId)) {
				return false;
			}
		}
		return true;
	}

	// 회원 아이디와 비밀번호로 회원 찾기
	Member findMember(Member m) {
		for (Member member : members) {
			if (member != null && member.equals(m)) {
				return member;
			}
		}
		return null;
	}

	// 회원 정보 삭제
	void deleteMember() {
		for (int i = 0; i < members.length; i++) {
			if (members[i].equals(loginMember)) {
				members[i] = null;
				loginMember = null;
				System.out.println("회원탈퇴 완료");
				return;
			}
		}
	}
}
