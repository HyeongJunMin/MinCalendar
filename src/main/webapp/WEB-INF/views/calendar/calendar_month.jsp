<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%String ctx = request.getContextPath(); %>
<!DOCTYPE html>
<html>

<div class="week weeks-in-month">
	<!-- 이전 월 정보 작성 -->
	<c:forEach begin="${todayCal.lastMonthLastDay - todayCal.dayOfWeek + 2}" step="1" end="${todayCal.lastMonthLastDay}" var="i" varStatus="j">
		
		<fmt:formatNumber var="lastDate" minIntegerDigits="2" value="${i}" type="number"/>
		<fmt:formatNumber var="lastMonth" minIntegerDigits="2" value="${todayCal.lastMonth}" type="number"/>
		<c:set var="dateString" value="${todayCal.lastYear }-${lastMonth}-${lastDate }"/>
		
		<c:choose>
			<c:when test="${fn:contains(scheCalMapKeySet, dateString) }">
				<div class="day prev-day">
					<h3 class="day-label">${i }</h3>
					<div class="event-repeated event-start event-end" data-span="8"
						data-toggle="popover" data-html="true"
						data-content='<div class="content-line"><div class="event-repeated-marking"></div><div class="title"><h5>일정 1</h5>
								<h7 class="reservation">2019년 9월 15일 – 17일<span class="reservation-time">⋅오후 2:00~ 3:00</span><span class="repeat-message">⋅매월 반복</span></div>
				        		</div><div class="content-line"><i class="material-icons">notes</i>
				        		<div class="title"><h7 class="reservation">스케쥴 메모, 설명이 나타납니다.</div>
				        		'>반복 일정 2</div>
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
				<div class="day curr-day">
					<h3 class="day-label">${i }</h3>
					<div class="event-repeated event-start event-end" data-span="8"
						data-toggle="popover" data-html="true"
						data-content='<div class="content-line"><div class="event-repeated-marking"></div><div class="title"><h5>일정 1</h5>
								<h7 class="reservation">2019년 9월 15일 – 17일<span class="reservation-time">⋅오후 2:00~ 3:00</span><span class="repeat-message">⋅매월 반복</span></div>
				        		</div><div class="content-line"><i class="material-icons">notes</i>
				        		<div class="title"><h7 class="reservation">스케쥴 메모, 설명이 나타납니다.</div>
				        		'>반복 일정 2</div>
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
	<!-- 다음 월 정보 작성 -->
	
</div>

<div class="scheMapTestWrap">
	<c:if test="${fn:contains(scheCalMapKeySet, '2019-10-02') }">
		2019-10-02 있음!
	</c:if>
	<h1>맵 테스트</h1>
	<c:forEach items="${scheCalMapKeySet }" var="vv">
		${vv }
		<br>
		<c:set var="scheItems" value="${scheCalMap[vv] }"/>
		<c:forEach items="${scheItems }" var="scheItem" varStatus="i">
			${i.count } : ${scheItem }<br>
		</c:forEach>
		<br>
		
	</c:forEach>
	
</div>


<script type="text/javascript">
	//년 월 표시
	var nowYearAndMonth = $("#_curr_year").val() + '년 '
			+ $("#_curr_month").val() + '월';
	$(".calendar-header h4").text(nowYearAndMonth);
	console.log('now:' + nowYearAndMonth);
</script>

<!-- (i + dayOfWeek - 1 ) % 7 === 0 && i != lastDay -->
<input type="text">
<p>
dayOfWeek : ${todayCal.dayOfWeek } <br>
lastDay : ${todayCal.lastDay }	<br>
nowMonth : ${todayCal.nowMonth }	<br>
nowYear : ${todayCal.nowYear }	<br>
for( i = 1 ; i < dayOfWeek ; i++ ){        
        tdDay = document.createElement('td');
        tdDay.setAttribute('class','tableBlank');
        tdDay.append(' ');    
        trDay.append( tdDay );
}
<br>
lastMonthLastDay : ${todayCal.lastMonthLastDay }
<br>
</p>
<div style="margin-top: 100px;">
	<c:forEach var="i" begin="1" end="${todayCal.lastDay }" step="1">
			<a>yo, i + todayCal.dayOfWeek - 1 % 7 : <c:out value="${ (i + todayCal.dayOfWeek - 1) % 7}"></c:out></a>
	</c:forEach>
	<br><br><br>
	<c:forEach items="${scheList}" var="sche">
		${sche }<br>
	</c:forEach>
</div>
</html>