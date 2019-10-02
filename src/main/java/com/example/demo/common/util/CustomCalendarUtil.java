package com.example.demo.common.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
			
			sdate = (sdate.split("-")[1].equals(todayCal.get("nowMonth")+""))
					?sdate
					:todayCal.get("lastYear") + "-" + String.format("%02d", todayCal.get("lastMonth")) + "-" + String.format("%02d", ( todayCal.get("lastMonthLastDay") - todayCal.get("dayOfWeek") + 2 ));
				    	
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
		
		return scheCalMap;
    }
    
    /**시작일과 종료일을 매개변수로 받아 두 날짜의 차이 일 수를 리턴하는 메소드
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
