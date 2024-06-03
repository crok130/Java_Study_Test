package api_practice;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Practice03StringCaseExample {

	public static void main(String[] args) {
		String chars = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		
		System.out.println("문자나 숫자를 입력해 주세요.");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		// 특정 문자열에 매개변수로 전달된 지정 문자열이 포함되어있는지 확인하는 메소드
		// 문자열.contains("확인할 문자열");  true : 존재, false : 존재하지 않음
		boolean isCheckEng = chars.contains(str); 
		System.out.println("영어문자 : " + isCheckEng);
		
		boolean isCheckDigit = numbers.contains(str);
		System.out.println("숫자문자 : " + isCheckDigit);
		
		System.out.println("======================================");
		// 문자열.indexOf("확인할 문자열");
		// "확인할 문자열" 이 시작되는 시작 인덱스 번호 반환
		// "확인할 문자열" 이 포함되어 있지 않으면 인덱스 번호가 아닌 -1을 반환
		isCheckDigit = numbers.indexOf(str) != -1;
		System.out.println("숫자문자 : " + isCheckDigit);
		
		// 사용자가 입력한 문자열을 소문자 알파벳으로 변환
		str = str.toLowerCase();
		isCheckEng = chars.contains(str);
		System.out.println("lower case 영어문자 : " + isCheckEng);
		
		// 정규 표현식을 이용한 문자열 비교
		System.out.println("정규 표현식 =========================");
		// 정규 표현식으로 알파벳 체크
		String pattern = "[a-zA-Z]*";
		boolean isCheck = Pattern.matches(pattern, str);
		System.out.println("알파벳 패턴 : " + isCheck);
		
		// 정규 표현식으로 한글 체크
		pattern = "[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]*"; // {n}, {n,} , {n,m} n ~ m 
		isCheck = Pattern.matches(pattern, str);
		System.out.println("한글 패턴 : " + isCheck);
		
		
	}

}














