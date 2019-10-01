package com.example.demo.common.util;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

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
    	
    	System.out.println("set!!! year:" + year + " , month:" + month);
    	
    	setMapData(calData, today);
    	
    	return calData;
    }
    
    /**캘린더 렌더링에 필요한 값을 해시맵에 저장하는 메소드
     * @param calData
     * @param today
     */
    private static void setMapData(Map<String, Integer> calData, Calendar today) {
    	System.out.println("today!" + today);
    	
    	calData.put("nowYear", today.get(Calendar.YEAR) );
    	calData.put("nowMonth", today.get(Calendar.MONTH) + 1 );
    	calData.put("dayOfWeek", today.get(Calendar.DAY_OF_WEEK) );// 이번 달의 날짜 시작요일, 일=1, 토=7
    	calData.put("lastDay", today.getActualMaximum(Calendar.DATE));// 이번 달의 마지막 날짜
    	    	
    	//이전(지난) 월의 마지막 날짜
    	int lastMonth = (today.get(Calendar.MONTH) == 0)?11:(today.get(Calendar.MONTH) - 1);
    	today.set(today.get(Calendar.YEAR), lastMonth, 1);
    	calData.put("lastMonthLastDay", today.getActualMaximum(Calendar.DATE));
    }
}
