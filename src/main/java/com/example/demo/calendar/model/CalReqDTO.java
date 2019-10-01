package com.example.demo.calendar.model;

import java.io.Serializable;
import java.util.Calendar;

/**달력값을 요청할 때 연,월,일 정보를 전달하기 위한 용도
 * @author minhj
 *
 */
@SuppressWarnings("serial")
public class CalReqDTO implements Serializable {

	private int reqYear;
	private int reqMonth;
	private int reqDate;
	
	private int lastDay;	//현재 필드에 해당하는 월의 마지막 일
	private String fullFirstDate;	//yyyy-mm-dd 형태의 마지막 일
	private String fullLastDate;	//yyyy-mm-dd 형태의 마지막 일
		
	public CalReqDTO() { }

	public CalReqDTO(int reqYear, int reqMonth, int reqDate) {
		this.reqYear = reqYear;
		this.reqMonth = reqMonth;
		this.reqDate = reqDate;
	}
	
	public int getReqYear() {
		return reqYear;
	}

	public void setReqYear(int reqYear) {
		this.reqYear = reqYear;
	}

	public int getReqMonth() {
		return reqMonth;
	}

	public void setReqMonth(int reqMonth) {
		this.reqMonth = reqMonth;
	}

	public int getReqDate() {
		return reqDate;
	}

	public void setReqDate(int reqDate) {
		this.reqDate = reqDate;
	}

	public int getLastDay() {
		Calendar cal = Calendar.getInstance();
		cal.set(reqYear, reqMonth, reqDate);
		return cal.getActualMaximum(Calendar.DATE);
	}

	public void setLastDay(int lastDay) {
		this.lastDay = lastDay;
	}	

	public String getFullFirstDate() {
		return getReqYear() + "-" + getReqMonth() + "-" + getReqDate();
	}

	public void setFullFirstDate(String fullFirstDate) {
		this.fullFirstDate = fullFirstDate;
	}
	
	public String getFullLastDate() {
		return getReqYear() + "-" + getReqMonth() + "-" + getLastDay();
	}

	public void setFullLastDate(String fullLastDate) {
		this.fullLastDate = fullLastDate;
	}
	
	@Override
	public String toString() {
		return "CalReqDTO [reqYear=" + reqYear + ", reqMonth=" + reqMonth + ", reqDate=" + reqDate + ", lastDay="
				+ lastDay + ", fullFirstDate=" + getFullFirstDate() + ", fullLastDate=" + getFullLastDate() + "]";
	}
	
}
