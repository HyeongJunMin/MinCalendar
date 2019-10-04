<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%String ctx = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="<%=ctx%>/js/calendar_month.js"></script>
</head>
<div class="week weeks-in-month">
	<!-- 이전 월 정보 작성 -->
	<c:forEach begin="${todayCal.lastMonthLastDay - todayCal.dayOfWeek + 2}" step="1" end="${todayCal.lastMonthLastDay}" var="i" varStatus="j">
		<fmt:formatNumber var="lastDate" minIntegerDigits="2" value="${i}" type="number"/>
		<fmt:formatNumber var="lastMonth" minIntegerDigits="2" value="${todayCal.lastMonth}" type="number"/>
		<c:set var="dateString" value="${todayCal.lastYear }-${lastMonth}-${lastDate }"/>
		
		<c:choose>
			<c:when test="${fn:contains(scheCalMapKeySet, dateString) }">
				<c:set var="scheDisp" value="${scheCalMap[dateString][0]}"/>
				<c:set var="isRepeat" value=" "/>
				<c:choose>
					<c:when test="${scheDisp.sche_type == '일반' }"><c:set var="scheClassType" value="event event-start event-end"/><c:set var="scheMarking" value="event-marking"/></c:when>
					<c:when test="${scheDisp.sche_type == '연속' }"><c:set var="scheClassType" value="event-consecutive event-start event-end"/><c:set var="scheMarking" value="event-consecutive-marking"/></c:when>
					<c:when test="${scheDisp.sche_type == '반복' }"><c:set var="scheClassType" value="event-repeated event-start event-end"/><c:set var="scheMarking" value="event-repeated-marking"/><c:set var="isRepeat" value="⋅매월 반복"/></c:when>
				</c:choose>
				<div class="day prev-day">
					<h3 class="day-label">${i }</h3>
					<div class="${scheClassType }" data-span="${scheDisp.days }"
						data-toggle="popover" data-html="true"
						data-content='<div class="content-line"><div class="${scheMarking }"></div>
								<div class="title"><h5>${scheDisp.title }</h5>
								<h7 class="reservation">${scheDisp.syear }년 ${scheDisp.smonth }월 ${scheDisp.sday }일 – 17일<br/>
								<span class="reservation-time">⋅오후 2:00~ 3:00</span><br/>
								<span class="repeat-message">${isRepeat }</span></div>
				        		</div><div class="content-line"><i class="material-icons">notes</i>
				        		<div class="title"><h7 class="reservation">${scheDisp.content }</div></div>
				        		'>${scheDisp.sche_type } 일정</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="day prev-day"><h3 class="day-label">${i }</h3></div>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<!-- 당 월 정보 작성 -->
	<c:forEach var="i" begin="1" end="${todayCal.lastDay }" step="1">	
		<fmt:formatNumber var="nowDate" minIntegerDigits="2" value="${i}" type="number"/>
		<fmt:formatNumber var="nowMonth" minIntegerDigits="2" value="${todayCal.nowMonth}" type="number"/>
		<c:set var="dateString" value="${todayCal.nowYear }-${nowMonth}-${nowDate }"/>		
		
		<c:choose>
			<c:when test="${fn:contains(scheCalMapKeySet, dateString) }">
				<c:set var="scheDispList" value="${scheCalMap[dateString] }"/>
				
					<div class="day curr-day">
						<h3 class="day-label">${i }</h3>
						<c:forEach var="scheDisp" items="${scheDispList }">
							<c:set var="isRepeat" value=" "/>
							<c:choose>
								<c:when test="${scheDisp.sche_type == '일반' }"><c:set var="scheClassType" value="event event-start event-end"/><c:set var="scheMarking" value="event-marking"/></c:when>
								<c:when test="${scheDisp.sche_type == '연속' }"><c:set var="scheClassType" value="event-consecutive event-start event-end"/><c:set var="scheMarking" value="event-consecutive-marking"/></c:when>
								<c:when test="${scheDisp.sche_type == '반복' }"><c:set var="scheClassType" value="event-repeated event-start event-end"/><c:set var="scheMarking" value="event-repeated-marking"/><c:set var="isRepeat" value="⋅매월 반복"/></c:when>
							</c:choose>
							<div class="${scheClassType }" data-span="${scheDisp.days }"
								data-toggle="popover" data-html="true"
								data-content='<div class="content-line"><div class="${scheMarking }"></div>
								<div class="title"><h5>${scheDisp.title }</h5>
								<h7 class="reservation">⋅${scheDisp.syear }년 ${scheDisp.smonth }월 ${scheDisp.sday }일 – ${scheDisp.emonth }월 ${scheDisp.eday }일<br/>
								<span class="reservation-time">⋅ ${scheDisp.shour }: ${scheDisp.smonth } ~ ${scheDisp.ehour }: ${scheDisp.emonth }</span><br/>
								<span class="repeat-message">${isRepeat }</span></div>
				        		</div><div class="content-line"><i class="material-icons">notes</i>
				        		<div class="title"><h7 class="reservation">${scheDisp.content }</div></div>
				        		'>${scheDisp.sche_type } 일정</div>
						</c:forEach>
					</div>				
			</c:when>
			<c:otherwise>
				<div class="day curr-day"><h3 class="day-label">${i }</h3></div>	
			</c:otherwise>
		</c:choose>	
		
		<c:if test="${ ((i + todayCal.dayOfWeek - 1) % 7  == 0) and (j != todayCal.lastDay) }">
			<c:out value="</div><div class='week weeks-in-month'>" escapeXml="false"></c:out>			
		</c:if>

	</c:forEach>		
</div>
<script type="text/javascript">
	//년 월 표시
	var nowYearAndMonth = $("#_curr_year").val() + '년 '
			+ $("#_curr_month").val() + '월';
	$(".calendar-header h4").text(nowYearAndMonth);
	addEventListners();
</script>
</html>