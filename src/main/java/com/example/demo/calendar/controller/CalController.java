package com.example.demo.calendar.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.calendar.model.CalReqDTO;
import com.example.demo.calendar.model.SchedulesDispDTO;
import com.example.demo.calendar.service.CalendarService;
import com.example.demo.common.util.CustomCalendarUtil;


@Controller
@RequestMapping(value = "calendar")
public class CalController {
	
	private Logger log = LoggerFactory.getLogger(CalController.class);
	
	@Autowired
	private CalendarService calendarService;

	@GetMapping(value = "/exam")
	public String calendarExam() {
		return "CalendarExam";
	}
	
	@GetMapping(value = "/main")
	public String calendarMain(Model model) {
		log.info("Calendar main view");
		
		model.addAttribute("weekNames", CustomCalendarUtil.getDayNames());//요일 정보
		model.addAttribute("todayCal", CustomCalendarUtil.getCurrentCalendarInfo() );//현재 조회시간 기준 날짜로 초기값 세팅
		
		return "calendar/calendar";
	}
	
	@Autowired
	SqlSession ss;
		
	@GetMapping(value = "/month")
	public String calendarMonth(Model model, CalReqDTO calReq) {
		log.info("Calendar month view");
						
		//요청날짜 정보가 없으면 현재날짜로 설정하여 모델에 추가
		model.addAttribute("todayCal", getCalendarInfo(calReq) ); 
		
		//년-월에 맞는 일정정보 모델에 추가
		List<SchedulesDispDTO> scheList = calendarService.getSchedulesByMonth(calReq);
		Map<String, List<SchedulesDispDTO>> scheCalMap = new HashMap<String, List<SchedulesDispDTO>>();
		for(SchedulesDispDTO scheItem : scheList) {
			String sdate = scheItem.getSdate().split(" ")[0];
			System.out.println(scheItem.getSdate().split(" ")[0]);
			if( scheCalMap.get(sdate) == null ) {//키가 없는 경우
				scheCalMap.put(sdate, new ArrayList<SchedulesDispDTO>() );
				scheCalMap.get(sdate).add(scheItem);				
			}else {	//키가 있는 경우
				scheCalMap.get(sdate).add(scheItem);
			}
		}
		System.out.println("맵사이즈 : " + scheCalMap.size());
		
		Iterator<String> it = scheCalMap.keySet().iterator();
		while(it.hasNext()) {
			String k = it.next();
			System.out.println("k : " + k + " , v : " + scheCalMap.get(k).toString());
		}
		 
		Set<String> scheCalMapKeySet = scheCalMap.keySet();
		
		model.addAttribute("scheCalMapKeySet", scheCalMapKeySet);
		model.addAttribute("scheCalMap", scheCalMap);
		model.addAttribute("scheList", scheList);
		
		return "calendar/calendar_month";
	}
	
	@GetMapping(value = "/day")
	public String calendarDay(Model model, CalReqDTO calReq) {
		log.info("Calendar day view");
		
		//요청날짜 정보가 없으면 현재날짜로 설정하여 모델에 추가
		model.addAttribute("todayCal", getCalendarInfo(calReq) ); 
		
		return "calendar/calendar_day";
	}
	
	private Map<String, Integer> getCalendarInfo(CalReqDTO calReq){		
		
		//요청날짜 정보가 없으면 현재날짜로 설정
		int reqYear = 0, reqMonth = 0, reqDate = 0;
		try {
			reqYear = (calReq.getReqYear() == 0 )?Calendar.getInstance().get(Calendar.YEAR):calReq.getReqYear();
			reqMonth = (calReq.getReqMonth() == 0 )?Calendar.getInstance().get(Calendar.MONTH):calReq.getReqMonth();
			reqDate = (calReq.getReqDate() == 0 )?Calendar.getInstance().get(Calendar.DATE):calReq.getReqDate();
		} catch(Exception e) {
			e.printStackTrace();
			log.warn("Exception occured");
		}
		
		return CustomCalendarUtil.getCurrentCalendarInfo(reqYear, reqMonth, reqDate);
	}
}
