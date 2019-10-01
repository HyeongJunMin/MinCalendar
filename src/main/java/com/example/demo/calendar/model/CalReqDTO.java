package com.example.demo.calendar.model;

import java.io.Serializable;

/**달력값을 요청할 때 연,월,일 정보를 전달하기 위한 용도
 * @author minhj
 *
 */
public class CalReqDTO implements Serializable {

	private int reqYear;
	private int reqMonth;
	private int reqDate;
	
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

	
}
