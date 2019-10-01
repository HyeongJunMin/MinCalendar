<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String ctx = request.getContextPath(); %>
<!DOCTYPE html>
<html>

<div class="week weeks-in-month">
	<!-- 이전 월 정보 작성 -->
	<c:forEach begin="${todayCal.lastMonthLastDay - todayCal.dayOfWeek + 2 }" step="1" end="${todayCal.lastMonthLastDay }" var="i">
		<div class="day prev-day"><h3 class="day-label">${i }</h3></div>
	</c:forEach>
	<!-- 당 월 정보 작성 -->
	<c:forEach var="i" begin="1" end="${todayCal.lastDay }" step="1">		
		<div class="day"><h3 class="day-label">${i }</h3></div>
		<c:if test="${ ((i + todayCal.dayOfWeek - 1) % 7  == 0) and (j != todayCal.lastDay) }">
			<c:out value="</div><div class='week weeks-in-month'>" escapeXml="false"></c:out>			
		</c:if>
	</c:forEach>
	<!-- 다음 월 정보 작성 -->
</div>

<script type="text/javascript">
	//년 월 표시
	var nowYearAndMonth = $("#_curr_year").val() + '년 ' + $("#_curr_month").val() + '월';
	$(".calendar-header h4").text( nowYearAndMonth );
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
</div>
</html>