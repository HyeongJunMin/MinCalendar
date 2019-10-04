package com.example.demo.calendar.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.calendar.model.CalReqDTO;
import com.example.demo.calendar.model.SchedulesDispDTO;
import com.example.demo.calendar.service.CalendarService;
import com.example.demo.common.util.CustomCalendarUtil;


/**달력 뷰를 만들어 응답하고 일정 정보를 보여주는 컨트롤러
 * @author minhj
 *
 */
@Controller
@RequestMapping(value = "/calendar")
public class CalController {
	
	private Logger log = LoggerFactory.getLogger(CalController.class);
	
	@Autowired
	private CalendarService calendarService;

	/**달력 예제 뷰를 리턴하는 메소드 
	 * @return
	 */
	@GetMapping(value = "/exam")
	public String calendarExam() {
		return "CalendarExam";
	}
	
	/**달력 메인 뷰를 리턴하는 메소드
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/main")
	public String calendarMain(Model model) {
		log.info("Calendar main view");
		
		model.addAttribute("weekNames", CustomCalendarUtil.getDayNames());//요일 정보
		model.addAttribute("todayCal", CustomCalendarUtil.getCurrentCalendarInfo() );//현재 조회시간 기준 날짜로 초기값 세팅
		
		return "calendar/calendar";
	}
			
	/**월 달력 정보와 일정정보를 리턴하는 메소드. jQuery load함수를 통해 불러온다.
	 * @param model
	 * @param calReq
	 * @return
	 */
	@GetMapping(value = "/month")
	public String calendarMonth(Model model, CalReqDTO calReq) {
		log.info("[calendarMonth] Calendar month view");
						
		
		//요청날짜 정보가 없으면 현재날짜로 설정하여 모델에 추가
		Map<String, Integer> todayCal = getCalendarInfo(calReq);
		model.addAttribute("todayCal", todayCal ); 
		
		//년-월에 맞는 일정정보 모델에 추가
		List<SchedulesDispDTO> scheList = calendarService.getSchedulesByMonth(calReq);
		Map<String, List<SchedulesDispDTO>> scheCalMap = CustomCalendarUtil.getScheCalMap(scheList, todayCal);
		 
		Set<String> scheCalMapKeySet = scheCalMap.keySet();
		
		model.addAttribute("scheCalMapKeySet", scheCalMapKeySet);
		model.addAttribute("scheCalMap", scheCalMap);
		model.addAttribute("scheList", scheList);
		
		return "calendar/calendar_month";
	}
	
	/**일 달력 정보와 일정 정보를 리턴하는 메소드. jQuery load함수를 통해 불러온다.
	 * @param model
	 * @param calReq
	 * @return
	 */
	@GetMapping(value = "/day")
	public String calendarDay(Model model, CalReqDTO calReq) {
		log.info("[calendarDay] Calendar day view " + calReq);
		
		//요청날짜 정보가 없으면 현재날짜로 설정하여 모델에 추가
		model.addAttribute("todayCal", getCalendarInfo(calReq) );
		
		//년-월-일에 맞는 일정정보 모델에 추가
		List<SchedulesDispDTO> scheList = calendarService.getSchedulesByDay(calReq);
		log.info("list : " + scheList);
		model.addAttribute("scheList", scheList);
		
		return "calendar/calendar_day";
	}
	
	/**Ajax 통신을 통해 클라이언트에서 작성한 내용을 DB에 저장하는 메소드.
	 * 성공은 1, 실패는 0을 리턴한다.
	 * 
	 * @param json
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/save/schedule", method = RequestMethod.POST)
	public String saveScheduleAjax(@RequestBody String json) throws Exception {
		log.info("[saveScheduleAjax] ajax request ");
		
		SchedulesDispDTO sDDTO = SchedulesDispDTO.convertJsonStringToDTO(json);
		
		sDDTO = calendarService.insertNewSchedules(sDDTO);
		int result = calendarService.insertNewScheDetails(sDDTO);
		
		return result + "";
	}
		
	/**CalReqDTO를 초기화해주는 메소드. DTO에 유효한 날짜가 없으면 조회시점의 날짜로 설정한다.
	 * @param calReq
	 * @return
	 */
	private Map<String, Integer> getCalendarInfo(CalReqDTO calReq){		
		
		//요청날짜 정보가 없으면 현재날짜로 설정
		int reqYear = 0, reqMonth = 0, reqDate = 0;
		try {
			reqYear = (calReq.getReqYear() == 0 )? Calendar.getInstance().get(Calendar.YEAR) : calReq.getReqYear();
			reqMonth = (calReq.getReqMonth() == 0 )?Calendar.getInstance().get(Calendar.MONTH):calReq.getReqMonth();
			reqDate = (calReq.getReqDate() == 0 )?Calendar.getInstance().get(Calendar.DATE):calReq.getReqDate();
		} catch(Exception e) {
			e.printStackTrace();
			log.warn("Exception occured");
		}
		
		return CustomCalendarUtil.getCurrentCalendarInfo(reqYear, reqMonth, reqDate);
	}
}
