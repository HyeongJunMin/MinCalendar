package com.example.demo.calendar.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.demo.common.util.CustomCalendarUtil;

/**스케줄 정보를 달력에 보여주기 위한 DTO
 * SCHEDULE, SCHE_DETAILS 테이블 모두 사용
 * @author minhj
 *
 */
@SuppressWarnings("serial")
public class SchedulesDispDTO implements Serializable {

	//SCHEDULE 테이블 컬럼
	private int id;			//고유값
	private String title;	//제목
	private String content;	//내용
	private String sche_type;	//일반-연속-주반복-월반복	
	private String rdate;	//등록일시
	private int days;		//유효기간(일)
	
	//SCHE_DATEILS 테이블 컬럼	
	private String sdate;	//시작일
	private String edate;	//종료일
	
	public SchedulesDispDTO() { }

	public SchedulesDispDTO(int id, String title, String content, String sche_type, String rdate,int days, String sdate,	String edate) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.sche_type = sche_type;
		this.rdate = rdate;
		this.days = days;
		this.sdate = sdate;
		this.edate = edate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSche_type() {
		return sche_type;
	}

	public void setSche_type(String sche_type) {
		this.sche_type = sche_type;
	}	

	public String getRdate() {
		return rdate;
	}
	
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	
	public int getDays() {
		return CustomCalendarUtil.getDaysOfSchedule(sdate.split(" ")[0], edate.split(" ")[0]);
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

	@Override
	public String toString() {
		return "SchedulesDispDTO [id=" + id + ", title=" + title + ", content=" + content + ", sche_type=" + sche_type
				+ ", rdate=" + rdate + ", days=" + getDays() + ", sdate=" + sdate + ", edate=" + edate + "]";
	}	
	
	
	/* 연-월-일-시-분 상세내용을 보여줄 수 있는 getter */
	public String getSyear() {
		return sdate.split(" ")[0].substring(0,4);
	}
	
	public String getSmonth() {
		return (sdate.split(" ")[0].substring(5,7).charAt(0) == '0')?sdate.split(" ")[0].substring(6,7):sdate.split(" ")[0].substring(5,7);
	}

	public String getSday() {
		return (sdate.split(" ")[0].substring(8,10).charAt(0) == '0')?sdate.split(" ")[0].substring(9,10):sdate.split(" ")[0].substring(8,10);
	}
	
	public String getShour() {
		return (sdate.split(" ")[1].substring(0,2).charAt(0) == '0')?sdate.split(" ")[1].substring(1,2):sdate.split(" ")[1].substring(0,2);
	}
	
	public String getSminutes() {
		return (sdate.split(" ")[1].substring(3,5).charAt(0) == '0')?sdate.split(" ")[1].substring(4,5):sdate.split(" ")[1].substring(3,5);
	}
	
	public String getEyear() {
		return edate.split(" ")[0].substring(0,4);
	}
	
	public String getEmonth() {
		return (edate.split(" ")[0].substring(5,7).charAt(0) == '0')?edate.split(" ")[0].substring(6,7):edate.split(" ")[0].substring(5,7);
	}

	public String getEday() {
		return (edate.split(" ")[0].substring(8,10).charAt(0) == '0')?edate.split(" ")[0].substring(9,10):edate.split(" ")[0].substring(8,10);
	}
	
	public String getEhour() {
		return (edate.split(" ")[1].substring(0,2).charAt(0) == '0')?edate.split(" ")[1].substring(1,2):edate.split(" ")[1].substring(0,2);
	}
	
	public String getEminutes() {
		return (edate.split(" ")[1].substring(3,5).charAt(0) == '0')?edate.split(" ")[1].substring(4,5):edate.split(" ")[1].substring(3,5);
	}
}
