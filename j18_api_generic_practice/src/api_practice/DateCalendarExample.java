package api_practice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateCalendarExample {

	public static void main(String[] args) {
		// 호출 되는 시점이 현재 시간에 대한 정보를 다루는 Calendar 객체
		Calendar now = Calendar.getInstance();
		Date date = now.getTime();
		System.out.println(date);
		
		// java.text.SimpleDateFormat
		// 시간에 대한 정보를 저장하는 Date 객체에 저장된 정보를
		// 우리가 원하는 형태의 문자열로 format 하는 클래스
		SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy년MM월dd일 E요일 a HH시mm분ss초"
		);
		String str = sdf.format(date);
		System.out.println(str);
		
		// 년도
		int year = now.get(Calendar.YEAR);
		// 월 0 ~ 11 : 1 ~ 12월로 표현
		int month = now.get(Calendar.MONTH) + 1;
		// 월 중 날짜
		int day = now.get(Calendar.DAY_OF_MONTH);
		// 주중 날짜 - 요일
		// SUNDAY : 1, SATURADAY : 7
		int week = now.get(Calendar.DAY_OF_WEEK);
		System.out.println(year+"년"+month+"월"+day+"일");
		System.out.println(week);
		
		int hour = now.get(Calendar.HOUR);
		int minute = now.get(Calendar.MINUTE);
		int seconds = now.get(Calendar.SECOND);
		System.out.println(hour+":"+minute+":"+seconds);
		
	}

}












