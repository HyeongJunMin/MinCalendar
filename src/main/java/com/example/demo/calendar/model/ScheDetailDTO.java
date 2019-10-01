package com.example.demo.calendar.model;

import java.io.Serializable;

/**스케줄 일정을 확인하기 위한 DTO
 * SCHE_DETAILS와 대응
 * @author minhj
 *
 */
@SuppressWarnings("serial")
public class ScheDetailDTO implements Serializable {
	
	private int id;
	private int id_schedules;
	private String sdate;
	private String edate;
	
	public ScheDetailDTO() { }
	
	public ScheDetailDTO(int id, int id_schedules, String sdate, String edate) {
		this.id = id;
		this.id_schedules = id_schedules;
		this.sdate = sdate;
		this.edate = edate;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_schedules() {
		return id_schedules;
	}
	public void setId_schedules(int id_schedules) {
		this.id_schedules = id_schedules;
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
		return "ScheDetailDTO [id=" + id + ", id_schedules=" + id_schedules + ", sdate=" + sdate + ", edate=" + edate
				+ "]";
	}
	
	
}
