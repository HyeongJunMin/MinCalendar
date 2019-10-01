package com.example.demo.calendar.model;

import java.io.Serializable;

/**스케줄 정보를 달력에 보여주기 위한 DTO
 * SCHEDULE, SCHE_DETAILS 테이블 모두 사용
 * @author minhj
 *
 */
@SuppressWarnings("serial")
public class SchedulesDispDTO implements Serializable {

	//SCHEDULE 테이블 컬럼
	private int id;	
	private String title;
	private String content;
	private String rdate;
	
	//SCHE_DATEILS 테이블 컬럼	
	private String sdate;
	private String edate;
	
	public SchedulesDispDTO() { }

	public SchedulesDispDTO(int id, String title, String content, String rdate, String sdate, String edate) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.rdate = rdate;
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

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
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
		return "SchedulesDispDTO [id=" + id + ", title=" + title + ", content=" + content + ", rdate=" + rdate
				+ ", sdate=" + sdate + ", edate=" + edate + "]";
	}
	
}
