<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String ctx = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calendar Main</title>
<jsp:include page="./sub/externalresources.jsp"></jsp:include>
<link href='<%=ctx %>/css/calendar.css' rel='stylesheet' />
<link href='<%=ctx %>/css/calendar_sub.css' rel='stylesheet' />

<script type="text/javascript" src="<%=ctx %>/js/calendar_sub.js"></script>
<script type="text/javascript" src="<%=ctx %>/js/calendar.js"></script>

</head>
<body>

<input type="hidden" id="_curr_year" value="${todayCal.nowYear }">
<input type="hidden" id="_curr_month" value="${todayCal.nowMonth }">
<input type="hidden" id="_curr_date" value="${todayCal.nowDate }">
<div class="calendar-container">
	<div class="calendar-header">
		<button class="btn btn-light" id="btn_show_today">Today</button>
		<div class="ico-arrow">
			<a href="#" data-toggle="tooltip" data-placement="top" title="" data-original-title="이전">
				<i class="material-icons" id="move_prev">chevron_left</i>
			</a>
			<a href="#" data-toggle="tooltip" data-placement="top" title="" data-original-title="다음">
				<i class="material-icons" id="move_next">chevron_right</i>
			</a>
		</div>
		<h4></h4>
		<ul class="nav nav-tabs view-tab" id="view" role="tablist">
			<li class="nav-item">
				<a class="nav-link active show" id="tab-month" data-toggle="tab" href="#month" role="tab" aria-controls="month" aria-selected="true">월</a>
			</li>
			<li class="nav-item">
				<a class="nav-link show" id="tab-day" data-toggle="tab" href="#day" role="tab" aria-controls="day" aria-selected="false">일</a>
			</li>
		</ul>
	</div>
	<div>
	</div>
	<div class="tab-content">
		
		<!-- 월 뷰 -->
		<div class="tab-pane active" id="month" role="tabpanel" aria-labelledby="tab-month">
		<div class="monthly-calendar">
			<div class="week-day">
				<c:forEach items="${weekNames }" var="day">
					<div class="day-name">${day }</div>
				</c:forEach>
			</div>
			<div class="monthly-calendar-body">
				<!-- 달력 초기값 설정 -->
				<script type="text/javascript">getMonthCalendar(${todayCal.nowYear},${todayCal.nowMonth});</script>
			</div>
		</div>
			
			
		</div>
		<!-- 일 뷰 -->
		<div class="tab-pane" id="day" role="tabpanel" aria-labelledby="tab-day">
		<div class="daily-calendar-wrap">
			<!-- 달력 초기값 설정 -->
			<script type="text/javascript">getDayCalendar(${todayCal.nowYear},${todayCal.nowMonth},${todayCal.nowDate});</script>
		</div>
		</div>
	</div>
</div>

<!-- 새 스케쥴 모달 영역 -->
<div id="cal_new_sche_model_wrap">
	<jsp:include page="./sub/calendar_new_modal.jsp"></jsp:include>
</div>


</body>
</html>