package com.example.demo.calendar.service;

import java.util.List;

import com.example.demo.calendar.model.CalReqDTO;
import com.example.demo.calendar.model.SchedulesDispDTO;

/**일정 정보를 제공하는 서비스 인터페이스
 * @author minhj
 *
 */
public interface CalendarService {
	
	/**매개변수로 받은 년-월에 해당하는 스케줄 리턴
	 * @param calReqDto
	 * @return
	 */
	public List<SchedulesDispDTO> getSchedulesByMonth(CalReqDTO calReqDto);
	
	/**매개변수로 받은 년-월-일에 해당하는 스케줄 리턴
	 * @param calReqDto
	 * @return
	 */
	public List<SchedulesDispDTO> getSchedulesByDay(CalReqDTO calReqDto);
		
	/**매개변수로 받는 스케줄 정보 저장하고 저장된 pk(컬럼명=id)을 매개변수 dto에 set
	 * @param scheDispDto
	 * @return
	 */
	public SchedulesDispDTO insertNewSchedules(SchedulesDispDTO scheDispDto);
	
	/**매개변수로 받은 스케줄 디테일을 DB에 저장
	 * @param scheDispDto
	 * @return
	 */
	public int insertNewScheDetails(SchedulesDispDTO scheDispDto);
}
