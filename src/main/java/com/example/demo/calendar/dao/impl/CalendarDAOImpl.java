package com.example.demo.calendar.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.calendar.dao.CalendarDAO;
import com.example.demo.calendar.model.CalReqDTO;
import com.example.demo.calendar.model.SchedulesDispDTO;

@Repository
public class CalendarDAOImpl implements CalendarDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private String ns = "schedules.";
	
	/**매개변수로 받은 년-월에 해당하는 스케줄 리턴
	 * @param calReqDto
	 * @return
	 */
	@Override
	public List<SchedulesDispDTO> getSchedulesByMonth(CalReqDTO calReqDto) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(ns + "getSchedulesByMonth", calReqDto);
	}

}
