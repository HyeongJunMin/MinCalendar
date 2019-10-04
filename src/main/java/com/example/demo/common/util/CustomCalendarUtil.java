package com.example.demo.common.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.example.demo.calendar.model.SchedulesDispDTO;

public class CustomCalendarUtil {

	//요일 배열을 리턴하는 메소드
    public static String[] getDayNames() {
        String[] dayNames = {"일", "월", "화", "수", "목", "금", "토"};
        return dayNames;
    }
    

    /**캘린더 렌더링에 필요한 값을 해시맵 타입으로 리턴하는 메소드
     * 시작 요일, 마지막 날짜, 총 주 수
     * @return
     */
    public static Map<String, Integer> getCurrentCalendarInfo(){
    	
    	Map<String, Integer> calData = new HashMap<String, Integer>();
    	
    	Calendar today = Calendar.getInstance();
    	
    	setMapData(calData, today);
    	
    	return calData;
    }
    
    /**매개변수에 맞는 년, 월, 일에 따라 캘린더 렌더링에 필요한 값을 해시맵 타입으로 리턴하는 메소드
     * 시작 요일, 마지막 날짜, 총 주 수
     * @return
     */
    public static Map<String, Integer> getCurrentCalendarInfo(int year, int month, int date){
    	
    	Map<String, Integer> calData = new HashMap<String, Integer>();
    	
    	Calendar today = Calendar.getInstance();
    	today.set(year, month - 1, date);
    	
    	setMapData(calData, today);
    	
    	return calData;
    }
    
    /**년-월에 맞는 일정정보 리턴. joda.time DateTimeFormatter 활용
     * 키 : yyyy-mm-dd 문자열
     * 밸류 : List<SchedulesDispDTO>
     * @param scheList
     * @return
     */
    public static Map<String, List<SchedulesDispDTO>> getScheCalMap_formatter(List<SchedulesDispDTO> scheList, Map<String, Integer> todayCal) {
    	Map<String, List<SchedulesDispDTO>> scheCalMap = new HashMap<String, List<SchedulesDispDTO>>();
    	//yyyy-mm-dd hh:mm:ss
    	DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
    	
		for(SchedulesDispDTO scheItem : scheList) {

			DateTime date = formatter.parseDateTime(scheItem.getSdate());
						
			String thisMonth = date.getMonthOfYear() + "";

			//현재 조회할 월과 동일하면 유지, 다르면 현재 월에 보여지는 지난월의 첫 날짜로 세팅 
			String sdate = "";
			if(thisMonth.equals( todayCal.get("nowMonth")+"") ) {
				sdate = date.toString("yyyy-MM-dd");
			}else {
				date = formatter.parseDateTime( todayCal.get("lastYear") + "-" + String.format("%02d", todayCal.get("lastMonth")) + "-" + String.format("%02d", ( todayCal.get("lastMonthLastDay") - todayCal.get("dayOfWeek") + 2 ) ) + " 00:00:00" );
				sdate = date.toString("yyyy-MM-dd");
			}

			if( scheCalMap.get(sdate) == null ) {//키가 없는 경우
				scheCalMap.put(sdate, new ArrayList<SchedulesDispDTO>() );
				scheCalMap.get(sdate).add(scheItem);				
			}else {	//키가 있는 경우
				scheCalMap.get(sdate).add(scheItem);
			}
		}
		
		return scheCalMap;
    }
    
    /**년-월에 맞는 일정정보 리턴.
     * 키 : yyyy-mm-dd 문자열
     * 밸류 : List<SchedulesDispDTO>
     * @param scheList
     * @return
     */
    public static Map<String, List<SchedulesDispDTO>> getScheCalMap(List<SchedulesDispDTO> scheList, Map<String, Integer> todayCal) {
    	Map<String, List<SchedulesDispDTO>> scheCalMap = new HashMap<String, List<SchedulesDispDTO>>();
		for(SchedulesDispDTO scheItem : scheList) {
			String sdate = scheItem.getSdate().split(" ")[0];	//키값 산출
			
			String thisMonth = (sdate.split("-")[1].charAt(0) == '0')?sdate.split("-")[1].substring(1, 2):sdate.split("-")[1];
						
			sdate = (thisMonth.equals(todayCal.get("nowMonth")+""))
					?sdate
					:todayCal.get("lastYear") + "-" + String.format("%02d", todayCal.get("lastMonth")) + "-" + String.format("%02d", ( todayCal.get("lastMonthLastDay") - todayCal.get("dayOfWeek") + 2 ));
				    	
			if( scheCalMap.get(sdate) == null ) {//키가 없는 경우
				scheCalMap.put(sdate, new ArrayList<SchedulesDispDTO>() );
				scheCalMap.get(sdate).add(scheItem);				
			}else {	//키가 있는 경우
				scheCalMap.get(sdate).add(scheItem);
			}
		}
		
		return scheCalMap;
    }
    
    /**시작일과 종료일을 매개변수로 받아 일정의 날짜 수를 리턴하는 메소드
     * 형식 : yyyy-mmm-dd
     * @param sDay
     * @param eDay
     * @return
     */
    public static int getDaysOfSchedule(String sDay, String eDay){    	
    	try {
    		// 날짜를 data타입으로 변경
    		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
    		Date sDate = fm.parse(sDay);
    		Date eDate = fm.parse(eDay);
    		
    		// 시간차이를 시간,분,초를 곱한 값으로 나누면 하루 단위가 나옴
    		long diff = eDate.getTime() - sDate.getTime();
    		long diffDays = diff / (24 * 60 * 60 * 1000);
        	
        	return (int)diffDays + 1;    		
    	}catch (Exception e) {
			// TODO: handle exception
    		e.printStackTrace();
    		return 0;
		}
    }
    
    /**캘린더 렌더링에 필요한 값을 해시맵에 저장하는 메소드
     * @param calData
     * @param today
     */
    private static void setMapData(Map<String, Integer> calData, Calendar today) {
    	
    	calData.put("nowYear", today.get(Calendar.YEAR) );
    	calData.put("nowMonth", today.get(Calendar.MONTH) + 1 );
    	calData.put("nowDate", today.get(Calendar.DATE) );
    	calData.put("dayOfWeekToday", today.get(Calendar.DAY_OF_WEEK) );// 현재 날짜 시작요일, 일=1, 토=7
    	today.set(Calendar.DATE, 1);
    	calData.put("dayOfWeek", today.get(Calendar.DAY_OF_WEEK) );// 이번 달의 날짜 시작요일, 일=1, 토=7
    	calData.put("lastDay", today.getActualMaximum(Calendar.DATE));// 이번 달의 마지막 날짜
    	
    	//이전(지난) 월의 마지막 날짜
    	int lastMonth = (today.get(Calendar.MONTH) == 0)?11:(today.get(Calendar.MONTH) - 1);
    	today.set(today.get(Calendar.YEAR), lastMonth, 1);
    	calData.put("lastYear", today.get(Calendar.YEAR) );
    	calData.put("lastMonth", today.get(Calendar.MONTH) + 1 );
    	calData.put("lastMonthLastDay", today.getActualMaximum(Calendar.DATE));
    }
    
}
