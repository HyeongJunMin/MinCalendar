package com.example.demo.calendar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.calendar.dao.CalendarDAO;
import com.example.demo.calendar.model.CalReqDTO;
import com.example.demo.calendar.model.SchedulesDispDTO;
import com.example.demo.calendar.service.CalendarService;

@Service
public class CalendarServiceImpl implements CalendarService {

	@Autowired
	private CalendarDAO calendarDAO;	

	/**매개변수로 받은 년-월에 해당하는 스케줄 리턴
	 * @param calReqDto
	 * @return
	 */
	@Override
	public List<SchedulesDispDTO> getSchedulesByMonth(CalReqDTO calReqDto) {
		// TODO Auto-generated method stub
		return calendarDAO.getSchedulesByMonth(calReqDto);
	}

}
