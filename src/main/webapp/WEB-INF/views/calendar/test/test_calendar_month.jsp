<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>


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