<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>



	

<!-- 연속일정 -->
<div class="content-line">
	<div class="event-consecutive-marking"></div>
	<div class="title">
		<h5>일정 1</h5>
		<h7 class="reservation">2019년 9월 15일 – 17일 </h7>
	</div>
</div>
<div class="content-line">
	<i class="material-icons">notes</i>
	<div class="title">
		<h7 class="reservation">스케쥴 메모, 설명이 나타납니다. </h7>
	</div>
</div>



<!-- 반복일정 -->
<div class="content-line">
	<div class="event-repeated-marking"></div>
	<div class="title">
		<h5>일정 1</h5>
		<h7 class="reservation">2019년 9월 15일 – 17일</h7>
		<span class="reservation-time">⋅오후 2:00~ 3:00</span> <span
			class="repeat-message">⋅매월 반복</span>
	</div>
</div>
<div class="content-line">
	<i class="material-icons">notes</i>
	<div class="title">
		<h7 class="reservation">스케쥴 메모, 설명이 나타납니다.</h7>
	</div>
</div>



<!-- 일반일정 -->
<div class="content-line">
	<div class="event-marking"></div>
	<div class="title">
		<h5>일정 1</h5>
		<h7 class="reservation">2019년 9월 15일 – 17일<h7> <span
			class="reservation-time">⋅오후 2:00~ 3:00</span>
	</div>
</div>
<div class="content-line">
	<i class="material-icons"> notes </i>
	<div class="title">
		<h7 class="reservation">스케쥴 메모, 설명이 나타납니다.</h7>
	</div>
</div>

</html>