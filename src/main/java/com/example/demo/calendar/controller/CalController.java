package com.example.demo.calendar.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.calendar.model.CalReqDTO;
import com.example.demo.common.util.CustomCalendarUtil;


@Controller
@RequestMapping(value = "calendar")
public class CalController {
	
	private Logger log = LoggerFactory.getLogger(CalController.class);

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
	private SqlSession ss;
	
	@GetMapping(value = "/month")
	public String calendarMonth(Model model, CalReqDTO calReq) {
		log.info("Calendar month view");
		
		List<String> lst = ss.selectList("common.getList");
		for(String str : lst) {
			System.out.println(str);
		}
		
		//요청날짜 정보가 없으면 현재날짜로 설정
//		int reqYear = 0, reqMonth = 0, reqDate = 0;
//		try {
//			reqYear = (calReq.getReqYear() == 0 )?Calendar.getInstance().get(Calendar.YEAR):calReq.getReqYear();
//			reqMonth = (calReq.getReqMonth() == 0 )?Calendar.getInstance().get(Calendar.MONTH):calReq.getReqMonth();
//			reqDate = (calReq.getReqDate() == 0 )?Calendar.getInstance().get(Calendar.DATE):calReq.getReqDate();
//		} catch(Exception e) {
//			e.printStackTrace();
//			log.warn("Exception occured");
//		}
		
		calReq.setReqYear(2019);
		calReq.setReqMonth(10);
		calReq.setReqDate(1);
				
//		model.addAttribute("todayCal", CustomCalendarUtil.getCurrentCalendarInfo(reqYear, reqMonth, reqDate) );
		model.addAttribute("todayCal", CustomCalendarUtil.getCurrentCalendarInfo(calReq.getReqYear(), calReq.getReqMonth(), calReq.getReqDate() ) );
		
		return "calendar/calendar_month";
	}
}
