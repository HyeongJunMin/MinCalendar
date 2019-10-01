package com.example.demo.calendar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
		
		model.addAttribute("weekNames", CustomCalendarUtil.getDayNames());
		
		return "calendar/calendar";
	}
	
	@GetMapping(value = "/month")
	public String calendarMonth(Model model) {
		model.addAttribute("todayCal", CustomCalendarUtil.getCurrentCalendarInfo() );
		return "calendar/calendar_month";
	}
}
