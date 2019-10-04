package com.example.demo.db;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.calendar.model.SchedulesDispDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DBQueryTest {

	@Autowired
	private SqlSession ss;
	
	@Test
	public void insertAndReturnTest() {
		
		SchedulesDispDTO dto = new SchedulesDispDTO();
		dto.setTitle("테스트1111제목");
		dto.setContent("테스트11본문");
		dto.setSche_type("테스트1111타입");
		
		int result = ss.insert("schedules.insertNewSchedules", dto);
		System.out.println("결과 : " + result);
		System.out.println("결과다! : " + dto.getId());
	}
}
