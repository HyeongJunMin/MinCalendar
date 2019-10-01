<%@page import="java.util.Map"%>
<%@page import="com.example.demo.common.util.CustomCalendarUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String ctx = request.getContextPath();
	int dayOfWeekNum = Integer.parseInt( ((Map)request.getAttribute("todayCal")).get("dayOfWeek") + "" );
	String dayOfWeekStr = CustomCalendarUtil.getDayNames()[dayOfWeekNum-1];
%>
<!DOCTYPE html>
<html>
<div class="daily-calendar">
	<span class="day-name">${todayCal.nowDate }일 <%=dayOfWeekStr %>요일</span>
	<div class="event-consecutive event-start event-end"
		data-toggle="popover" data-html="true" data-placement="left"
		data-content="<div class=&quot;content-line&quot;><div class=&quot;event-consecutive-marking&quot;></div><div class=&quot;title&quot;><h5>일정 1</h5><h7 class=&quot;reservation&quot;>2019년 9월 15일 – 17일</div>
	        </div><div class=&quot;content-line&quot;><i class=&quot;material-icons&quot;>
	notes
	</i><div class=&quot;title&quot;><h7 class=&quot;reservation&quot;>스케쥴 메모, 설명이 나타납니다.</div>"
		data-original-title="" title="">연속 일정 1</div>
	<div class="event-consecutive event-start event-end"
		data-toggle="popover" data-html="true" data-placement="left"
		data-content="<div class=&quot;content-line&quot;><div class=&quot;event-consecutive-marking&quot;></div><div class=&quot;title&quot;><h5>일정 1</h5><h7 class=&quot;reservation&quot;>2019년 9월 15일 – 17일</div>
	        </div><div class=&quot;content-line&quot;><i class=&quot;material-icons&quot;>
	notes
	</i><div class=&quot;title&quot;><h7 class=&quot;reservation&quot;>스케쥴 메모, 설명이 나타납니다.</div>"
		data-original-title="" title="">연속 일정 2</div>
	<div class="event event-start event-end" data-toggle="popover"
		data-html="true" data-placement="left"
		data-content="<div class=&quot;content-line&quot;><div class=&quot;event-marking&quot;></div><div class=&quot;title&quot;><h5>일정 1</h5><h7 class=&quot;reservation&quot;>2019년 9월 15일 – 17일<span class=&quot;reservation-time&quot;>⋅오후 2:00~ 3:00</span></div>
	        </div><div class=&quot;content-line&quot;><i class=&quot;material-icons&quot;>
	notes
	</i><div class=&quot;title&quot;><h7 class=&quot;reservation&quot;>스케쥴 메모, 설명이 나타납니다.</div>"
		data-original-title="" title="">일반 일정 3</div>
	<div class="event-repeated event-start event-end" data-toggle="popover"
		data-html="true" data-placement="left"
		data-content="<div class=&quot;content-line&quot;><div class=&quot;event-repeated-marking&quot;></div><div class=&quot;title&quot;><h5>일정 1</h5><h7 class=&quot;reservation&quot;>2019년 9월 15일 – 17일<span class=&quot;reservation-time&quot;>⋅오후 2:00~ 3:00</span><span class=&quot;repeat-message&quot;>⋅매월 반복</span></div>
	        </div><div class=&quot;content-line&quot;><i class=&quot;material-icons&quot;>
	notes
	</i><div class=&quot;title&quot;><h7 class=&quot;reservation&quot;>스케쥴 메모, 설명이 나타납니다.</div>"
		data-original-title="" title="">반복 일정 1</div>
</div>
</html>