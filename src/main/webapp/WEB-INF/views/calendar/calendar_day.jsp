<%@page import="java.util.Map"%>
<%@page import="com.example.demo.common.util.CustomCalendarUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String ctx = request.getContextPath();
	int dayOfWeekNum = Integer.parseInt( ((Map)request.getAttribute("todayCal")).get("dayOfWeekToday") + "" );
	String dayOfWeekStr = CustomCalendarUtil.getDayNames()[dayOfWeekNum-1];
%>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="<%=ctx%>/js/calendar_day.js"></script>
<div class="daily-calendar">
	<span class="day-name">${todayCal.nowDate }일 <%=dayOfWeekStr %>요일</span>
		<div class="day curr-day">
			<h3 class="day-label">${i }</h3>
			<c:forEach var="scheDisp" items="${scheList }">
				<c:set var="isRepeat" value=" "/>
				<c:choose>
					<c:when test="${scheDisp.sche_type == '일반' }"><c:set var="scheClassType" value="event event-start event-end"/><c:set var="scheMarking" value="event-marking"/></c:when>
					<c:when test="${scheDisp.sche_type == '연속' }"><c:set var="scheClassType" value="event-consecutive event-start event-end"/><c:set var="scheMarking" value="event-consecutive-marking"/></c:when>
					<c:when test="${scheDisp.sche_type == '반복' }"><c:set var="scheClassType" value="event-repeated event-start event-end"/><c:set var="scheMarking" value="event-repeated-marking"/><c:set var="isRepeat" value="⋅매월 반복"/></c:when>
				</c:choose>
				<div class="${scheClassType }" data-toggle="popover" data-html="true" data-placement="left"
					data-content='<div class="content-line"><div class="${scheMarking }"></div>
								<div class="title"><h5>${scheDisp.title }</h5>
								<h7 class="reservation">${scheDisp.syear }년 ${scheDisp.smonth }월 ${scheDisp.sday }일 – ${scheDisp.emonth }월 ${scheDisp.eday }일<br/>
								<span class="reservation-time">⋅ ${scheDisp.shour }: ${scheDisp.smonth } ~ ${scheDisp.ehour }: ${scheDisp.emonth }</span><br/>
								<span class="repeat-message">${isRepeat }</span></div>
				        		</div><div class="content-line"><i class="material-icons">notes</i>
				        		<div class="title"><h7 class="reservation">${scheDisp.content }</div></div>
				        		'>${scheDisp.sche_type } 일정</div>
			</c:forEach>
		</div>
</div>

<script type="text/javascript">
$(function () {
    $('[data-toggle="popover"]').popover().on('inserted.bs.popover')
});
</script>

</html>