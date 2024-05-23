package practice_07.member;

import java.util.Scanner;

public class MemberManagement{
	
	// 사용자 입력
	private Scanner sc = new Scanner(System.in);
	
	// 회원정보 저장
	private Member[] members = new Member[100];
	
	// 관리자 계정
	private Member master = new Member(100,"master","root","root");
	
	// 로그인한 회원
	private Member loginMember = null;
	
	// 프로그램 flag (true : 진행 , false : 종료) 
	private boolean isRun = true;
	
	// 메뉴 번호 선택
	private int selectNo;
	
	// 프로그램 실행용 생성자
	public MemberManagement() {
		// 관리자 계정을 99인덱스에 저장
		members[members.length - 1] = master;
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

			selectNo = sc.nextInt();
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
		// 여기서 memberIdCheck(mId)는 null이아니고 파라미터로 입력된 값과 Member m : members 향상된 for문으로 m에 담긴 id와 비교해서 둘다 참이면 true를 반환하고 아니면 false를 반환한다
		// 그러면 저 두 조건신이 참이 아니라면 false가 반환한다 false가 반환되면 없는 아이디니깐 중복되지 않은 아이디 인걸 알수 있다
		// 그렇게 해서 중복아이디 체크후 for문으로 배열의 null인 자리에 아이디 생성후 break;
		if(memberIdCheck(mId) || !mPw.equals(rePw)) {
			System.out.println("아이디가 중복됬거나 비밀번호가 일치하지 않습니다");
		}
		System.out.println("이름을 입력해 주세요");
		String name = sc.next();
		for(int i = 0; i < members.length; i++) {
			if(members[i] == null) {
				members[i] = new Member(i+1,name,mId,mPw);
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
		// 멤버타입 객체 cheakmember를 만들고 findMember(Member m)이 파라미터로 전달받은 멤버타입 객체랑 members배열안에 들어가있는 아이디 비번을 체크후 참이라면 그 참인 배열을 반환해주는 메소드를 이용해
		// 아이디 비번이 일치하는지 체크후 일치한다면 그 리턴반은 값을 loginMember에 대입연산하여 로그인체크부분을 만듬
		Member cheakmember = new Member(mId,mPw);
		Member accmember = findMember(cheakmember);
		if(accmember == null) {
			System.out.println("없는 아이디이거나 아이디 비밀번호가 틀렸습니다");
			return;
		}
		
		loginMember = accmember;
		System.out.println("정상적으로 로그인 되었습니다");
		System.out.println(loginMember.toString());
		// 여기는 로그인 계쩡이 관리자 계정인지 체크하는 부분
		if(loginMember == master) {
			System.out.println("관리자 계정입니다");
			return;
		}
	}

	private void select() {
		// 회원 목록은 관리자만 사용가능한 메뉴이니깐 loginMember가 관리자가 아니면 프린트후 리턴으로 돌려보내는 코드 loginMember가 master 이면 아래코드 실행
		if(loginMember != master) {
			System.out.println("관리자만 확인가능한 메뉴 입니다");
			return;
		}
		// 향상된 for문으로 m에 members배열을 담고 m이 널이 아닐때 m.toString으로 회원 목록을 출력
		for(Member m : members) {
			if(m != null) {
				System.out.println(m.toString());
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
		
		// loginMember가 master 이면 아랫줄실행
		if (loginMember.equals(master)) {
			System.out.println("== 관리자 회원정보 수정");
			select();
			System.out.println("수정할 회원 번호를 입력해 주세요.");
			int mNum = sc.nextInt();
			// 반복문으로 배열을 순회 하면서 null이 아니고 입력 받은 회원 번호와 배열에 존재하는 회원번호 비교 해서 존재한다면 스캐너로 이름을 입력받아 회원번호의 이름을 수정
			for(int i = 0; i < members.length; i++) {
				if(members[i] != null && members[i].getNum() == mNum) {
					System.out.println("수정하실 이름을 입력해 주세요 > ");
					String name = sc.next();
					members[i].setName(name);
					System.err.println("수정 완료");
					return;
				} // end null cheak if
			} // end for 
		}else { // 관리자가 아닌 개인회원일때 실행되는 코드
			// 비밀번호를 스캐너로 입력받아 loginMember에 있는 pw와 스캐너로 입력 받는 pw가 같으면 이름 수정
			System.out.println("비밀번호를 한번더 입력해주세요 > ");
			String pw = sc.next();
			if(loginMember.getPw().equals(pw)) {
				System.out.println("수정할 이름을 입력해주세요 > ");
				String name = sc.next();
				loginMember.setName(name);
				System.out.println("내정보 수정완료");
				return;
			}else {
				System.out.println("비밀번호가 일치하지 않습니다");
				return;
			}
		}
	}

	private void delete() {
		System.out.println("회원탈퇴 > ");
		// loginMember가 null 이면 로그인한 계정이없으니 오류 문가후 리턴 널이 아니라면 loginMember가 마스터 인지 확인 마스터가 아니라 일반 사용자라면 계정 삭제
		if(loginMember == null) {
			System.out.println("로그인후 사용가능한 메뉴입니다");
			return;
		}
		if(loginMember == master) {
			System.out.println("관리자는 탈퇴하실수 없습니다");
			return;
		}
		deleteMember();
	}
	
	// 회원 정보 삭제
	private void deleteMember() {
		for(int i=0; i<members.length; i++) {
			if(members[i].equals(loginMember)) {
				members[i] = null;
				loginMember = null;
				System.out.println("회원탈퇴 완료");
				return;
			}
		}
	}
	
	// 사용자 아이디 중복 체크
	// 향상된 for문으로 m안에 배열을 담고 if문 논리곱연산으로 m이 null이 아니고  m안에 아이디와 파라미터가 같을때 트루가 리턴되고 아니라면 false가 리턴되는 메소드
	private boolean memberIdCheck(String mId) {
		for(Member m : members) {
			if(m != null && m.getId().equals(mId)) {
				return true;
			}
		}
		return false;
	}
	
	// 회원 아이디와 비밀번호로 회원 찾기
	private Member findMember(Member m) {
		for(Member member : members) {
			if(member != null && member.equals(m)) {
				return member;
			}
		}
		return null;
	}
}
