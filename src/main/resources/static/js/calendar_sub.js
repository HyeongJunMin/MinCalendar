/**
 * 
 */

function getMonthCalendar(year, month){
	
	//현재 달력 삭제
	$(".weeks-in-month").remove();
	
	//조건에 맞는 새 달력 불러오기
	$(".confirm_wrap").append('<div class="frm_personalform"></div>');
	$(".monthly-calendar-body").load('/calendar/month', 'reqYear=' + year + '&reqMonth=' + month);
	
}

$(function(){
	//이전 버튼 클릭 이벤트
	$("#move_prev").click(function(){
		
	});
	
	//다음 버튼 클릭 이벤트
	$("#move_next").click(function(){
		
	});
});