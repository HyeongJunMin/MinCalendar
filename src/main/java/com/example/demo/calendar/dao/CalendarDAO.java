package com.example.demo.calendar.dao;

import java.util.List;

import com.example.demo.calendar.model.CalReqDTO;
import com.example.demo.calendar.model.SchedulesDispDTO;

public interface CalendarDAO {
	
	/**매개변수로 받은 년-월에 해당하는 스케줄 리턴
	 * @param calReqDto
	 * @return
	 */
	public List<SchedulesDispDTO> getSchedulesByMonth(CalReqDTO calReqDto);
}
