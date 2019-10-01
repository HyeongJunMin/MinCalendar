package com.example.demo.calendar.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.calendar.model.CalReqDTO;
import com.example.demo.common.util.CustomCalendarUtil;

@Controller
@RequestMapping(value = "calendar")
public class CalController {

	@GetMapping(value = "/exam")
	public String calendarExam() {
		return "CalendarExam";
	}
	
	@GetMapping(value = "/main")
	public String calendarMain(Model model) {
		
		model.addAttribute("weekNames", CustomCalendarUtil.getDayNames());//요일 정보
		model.addAttribute("todayCal", CustomCalendarUtil.getCurrentCalendarInfo() );//현재 조회시간 기준 날짜로 초기값 세팅
		
		return "calendar/calendar";
	}
	
	@GetMapping(value = "/month")
	public String calendarMonth(Model model, CalReqDTO calReq) {
		
		//요청날짜 정보가 없으면 현재날짜로 설정
		int reqYear = (calReq.getReqYear() == 0 )?Calendar.getInstance().get(Calendar.YEAR):calReq.getReqYear();
		int reqMonth = (calReq.getReqMonth() == 0 )?Calendar.getInstance().get(Calendar.MONTH):calReq.getReqMonth();
		int reqDate = (calReq.getReqDate() == 0 )?Calendar.getInstance().get(Calendar.DATE):calReq.getReqDate();
		
		model.addAttribute("todayCal", CustomCalendarUtil.getCurrentCalendarInfo(reqYear, reqMonth, reqDate) );
		System.out.println("왔다! 년:" + reqYear +" , 월:" + reqMonth);
		
		return "calendar/calendar_month";
	}
}
