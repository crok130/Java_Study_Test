package api_practice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeExample {

	public static void main(String[] args) {
		
		LocalDate toDay = LocalDate.now();		// 현재 시간에 대한 날짜 정보
		LocalTime present = LocalTime.now();	// 현재 시간에 대한 정보
		System.out.println(toDay);
		System.out.println(present);
		
		// 날짜 - 년도, 월, 일
		LocalDate birthDay = LocalDate.of(1982, 6, 7);
		System.out.println(birthDay);
		// 시간 - 시, 분, 초
		LocalTime birthTime = LocalTime.of(02, 07, 59);
		System.out.println(birthTime);
		
		birthTime = LocalTime.of(02, 07, 59, 999999999);
		System.out.println(birthTime);
		
		int year = birthDay.getYear();
		System.out.println("year : " + year);
		// 월을 1 ~ 12월로 표현
		int month = birthDay.getMonthValue();
		System.out.println("month : " + month);
		// 월중 날짜
		int day = birthDay.getDayOfMonth();
		System.out.println("day : " + day);
		// 주중 날짜
		System.out.println(birthDay.getDayOfWeek()); // MONDAY - SUNDAY
		// 월요일 - 1 ~ 일요일 - 7
		System.out.println(birthDay.getDayOfWeek().getValue());
		
		// 시간 정보 추출 - LocalTime
		int hour = birthTime.getHour();
		System.out.println("hour : " + hour);
		int minute = birthTime.getMinute();
		System.out.println("minute : " + minute);
		int second = birthTime.getSecond();
		System.out.println("second : " + second);
		System.out.println("==================================");
		
		// 날짜와 시간 정보를 다루는 객체
		LocalDateTime targetDateTime = LocalDateTime.now(); // 현재 시간
		System.out.println(targetDateTime);
		
		targetDateTime = LocalDateTime.of(2023,11,24,12,11,23);
		System.out.println(targetDateTime);
		
		targetDateTime = targetDateTime.withYear(2024)
						 .withMonth(12)
						 .withDayOfMonth(25)
						 .withHour(23)
						 .withMinute(59)
						 .withSecond(59);
		
		System.out.println(targetDateTime);
		System.out.println("=======================================");
		// targetDateTime : 2024-12-25T23:59:59
		// 시간의 차를 이용하여 새로운 시간 정보 객체 생성
		
		// 1년 전
		LocalDateTime target = targetDateTime.minusYears(1);
		System.out.println(target);
		
		// 10년 후
		target = targetDateTime.plusYears(10);
		System.out.println(target);
		
		// 5달 전
		target = targetDateTime.minusMonths(5);
		System.out.println(target);
		
		// 20일 전
		target = targetDateTime.minusDays(20);
		System.out.println(target);
		
		// 5시간 전
		target = targetDateTime.minusHours(5);
		System.out.println(target);
		
		System.out.println("==========================");
		// pattern 
		// LocalDate, LocalTime 객체로 DateTime 객체 초기화
		target = LocalDateTime.of(toDay, present);
		System.out.println(target);
		
		// 패턴을 저장하는 객체 - DateTimeFormatter
		// 사용되는 패턴은 SimpleDateFormat 객체와 동일
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern(
			"yyyy년MM월dd일 E요일 a KK시mm분ss초"
		);
		
		String time = target.format(pattern);
		System.out.println(time);
		
		// 문자열에 저장된 시간 정보를 시간 객체로 반환
		// "2023-10-12"
		// "2023-11-24T12:11:23"
		LocalDate date = LocalDate.parse(
			"2023-12-25"
		);
		System.out.println(date);
		
		date = LocalDate.parse(
				"2024년12월25일",
				DateTimeFormatter.ofPattern("yyyy년MM월dd일")
			);
		System.out.println(date);
		
		LocalDateTime dateTime = LocalDateTime.parse(
					"2023년11월24일 12시27분30초",
					DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH시mm분ss초")
				);
		System.out.println(dateTime);
						 
		
	}

}









