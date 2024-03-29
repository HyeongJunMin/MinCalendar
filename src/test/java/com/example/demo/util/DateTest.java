package com.example.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DateTest {

	@Test
	public void addMonthes() {
		String sdate = "2019-10-25 14:00:00";
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
		
		for(int i = 0 ; i < 12 ; i ++ ) {
			DateTime sd = formatter.parseDateTime(sdate);
			
			System.out.println(sd.plusMonths(i).toString(formatter));
		}
		
	}
	
	
	//@Test
	public void currCal() {

		String date1 = "2016-09-21";
		String date2 = "2016-09-10";

		try { // String Type을 Date Type으로 캐스팅하면서 생기는 예외로 인해 여기서 예외처리 해주지 않으면 컴파일러에서 에러가 발생해서
				// 컴파일을 할 수 없다.
			SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
			// date1, date2 두 날짜를 parse()를 통해 Date형으로 변환.
			Date FirstDate = format.parse(date1);
			Date SecondDate = format.parse(date2);

			// Date로 변환된 두 날짜를 계산한 뒤 그 리턴값으로 long type 변수를 초기화 하고 있다.
			// 연산결과 -950400000. long type 으로 return 된다.
			long calDate = FirstDate.getTime() - SecondDate.getTime();

			// Date.getTime() 은 해당날짜를 기준으로1970년 00:00:00 부터 몇 초가 흘렀는지를 반환해준다.
			// 이제 24*60*60*1000(각 시간값에 따른 차이점) 을 나눠주면 일수가 나온다.
			long calDateDays = calDate / (24 * 60 * 60 * 1000);

			calDateDays = Math.abs(calDateDays);

			System.out.println("두 날짜의 날짜 차이: " + calDateDays);
		} catch (ParseException e) {
			// 예외 처리
		}

	}
}
