<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String ctx = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calendar Main</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.15.1/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/js/bootstrap-datetimepicker.min.js"></script>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

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
		<button class="btn btn-light">Today</button>
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
		<div class="daily-calendar">
		</div>
		</div>
	</div>
</div>


</body>
</html>