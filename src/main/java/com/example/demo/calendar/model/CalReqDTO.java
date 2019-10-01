package com.example.demo.calendar.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**달력값을 요청할 때 연,월,일 정보를 전달하기 위한 용도
 * @author minhj
 *
 */
@Getter
@Setter
@ToString
@Builder
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
}
