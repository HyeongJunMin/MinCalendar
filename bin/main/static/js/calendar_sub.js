/**
 * 
 */

function getMonthCalendar(){
	    
	//현재 달력 삭제
	$(".weeks-in-month").remove();
	
	//조건에 맞는 새 달력 불러오기
	$(".confirm_wrap").append('<div class="frm_personalform"></div>');
	$(".monthly-calendar-body").load('/calendar/month');
	
}

