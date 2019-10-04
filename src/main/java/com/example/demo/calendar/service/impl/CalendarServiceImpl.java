package com.example.demo.calendar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.calendar.dao.CalendarDAO;
import com.example.demo.calendar.model.CalReqDTO;
import com.example.demo.calendar.model.SchedulesDispDTO;
import com.example.demo.calendar.service.CalendarService;

/**일정정보를 제공하는 서비스 클래스
 * @author minhj
 *
 */
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

	/**매개변수로 받은 년-월-일에 해당하는 스케줄 리턴
	 * @param calReqDto
	 * @return
	 */
	@Override
	public List<SchedulesDispDTO> getSchedulesByDay(CalReqDTO calReqDto) {
		// TODO Auto-generated method stub
		return calendarDAO.getSchedulesByDay(calReqDto);
	}

	
	/**매개변수로 받는 스케줄 정보 저장하고 저장된 pk(컬럼명=id)을 매개변수 dto에 set
	 * @param scheDispDto
	 * @return
	 */
	@Override
	public SchedulesDispDTO insertNewSchedules(SchedulesDispDTO scheDispDto) {
		// TODO Auto-generated method stub
		calendarDAO.insertNewSchedules(scheDispDto);
		return scheDispDto;
	}

	/**매개변수로 받은 스케줄 디테일을 DB에 저장
	 * @param scheDispDto
	 * @return
	 */
	@Override
	public int insertNewScheDetails(SchedulesDispDTO scheDispDto) {
		// TODO Auto-generated method stub
		return calendarDAO.insertNewScheDetails(scheDispDto);
	}	
}
