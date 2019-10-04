package com.example.demo.calendar.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
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

	/**매개변수로 받은 년-월-일에 해당하는 스케줄 리턴
	 * @param calReqDto
	 * @return
	 */
	@Override
	public List<SchedulesDispDTO> getSchedulesByDay(CalReqDTO calReqDto) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(ns + "getSchedulesByDay", calReqDto);
	}
	
	/**매개변수로 받는 스케줄 정보 저장하고 저장된 pk(컬럼명=id)을 매개변수 dto에 set
	 * @param scheDispDto
	 * @return
	 */
	@Override
	public SchedulesDispDTO insertNewSchedules(SchedulesDispDTO scheDispDto) {
		// TODO Auto-generated method stub
		sqlSession.insert(ns + "insertNewSchedules", scheDispDto);
		return scheDispDto;
	}

	/**매개변수로 받은 스케줄 디테일을 DB에 저장
	 * @param scheDispDto
	 * @return
	 */
	@Override
	public int insertNewScheDetails(SchedulesDispDTO scheDispDto) {
		// TODO Auto-generated method stub
		if( null != scheDispDto.getSche_type() && "반복".equals(scheDispDto.getSche_type()) ) {
			String sdate = scheDispDto.getSdate();
			String edate = scheDispDto.getEdate();
			DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
			
			for(int i = 0 ; i < 12 ; i ++ ) {
				DateTime sd = formatter.parseDateTime(sdate);
				DateTime ed = formatter.parseDateTime(edate);
				scheDispDto.setSdate( sd.plusMonths(i).toString(formatter) );
				scheDispDto.setEdate( ed.plusMonths(i).toString(formatter) );
				sqlSession.insert(ns + "insertNewScheDetails", scheDispDto);
			}
			return 1;
		}else {
			DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
			DateTime sd = formatter.parseDateTime(scheDispDto.getSdate().split(" ")[0]);
			DateTime ed = formatter.parseDateTime(scheDispDto.getEdate().split(" ")[0]);
			
			if( false == sd.equals(ed) ) {
				scheDispDto.setSche_type("연속");
			}
			return sqlSession.insert(ns + "insertNewScheDetails" , scheDispDto);
		}
	}
	
	
}
