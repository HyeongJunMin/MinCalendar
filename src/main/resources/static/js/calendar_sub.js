/**
 * 
 */

var currYear;
var currMonth;
var currDate;

$(function(){
	//이전 버튼 클릭 이벤트
	$("#move_prev").click(function(){
		console.log('move_prev');
		initCurrDate();		
		
		if( currView() === 'month' ){	//현재 뷰가 월인 경우 이전 월로 이동		
			console.log('currYear:' + currYear + ', currMonth:' + currMonth);
			var nextMonth = (currMonth == 1)?12:currMonth-1;
			var nextYear = (nextMonth == 12)?currYear-1:currYear;
			console.log('nextYear:' + nextYear + ', nextMonth:' + nextMonth);
			getMonthCalendar(nextYear, nextMonth);
			
			refreshCurrDate(nextYear, nextMonth, 1);	//변경된 내용 설정
			$(".calendar-header h4").text( $("#_curr_year").val() + '년 ' + $("#_curr_month").val() + '월' );
		}else if( currView() === 'day' ){	//현재 뷰가 일인 경우 다음 일로 이동
			
		}
	});
	
	//다음 버튼 클릭 이벤트
	$("#move_next").click(function(){
		initCurrDate();
		
		if( currView() === 'month' ){	//현재 뷰가 월인 경우 다음 월로 이동		
			console.log('currYear:' + currYear + ', currMonth:' + currMonth);
			var nextMonth = (currMonth == 12)?1:currMonth+1;
			var nextYear = (nextMonth == 1)?currYear+1:currYear;
			console.log('nextYear:' + nextYear + ', nextMonth:' + nextMonth);
			getMonthCalendar(nextYear, nextMonth);
			
			refreshCurrDate(nextYear, nextMonth, 1);	//변경된 내용 설정
			$(".calendar-header h4").text( $("#_curr_year").val() + '년 ' + $("#_curr_month").val() + '월' );
		}else if( currView() === 'day' ){	//현재 뷰가 일인 경우 다음 일로 이동
			
		}
	});
});

function getMonthCalendar(year, month){
	
	//현재 달력 삭제
	$(".weeks-in-month").remove();
	
	//조건에 맞는 새 달력 불러오기
	$(".confirm_wrap").append('<div class="frm_personalform"></div>');
	$(".monthly-calendar-body").load('/calendar/month', 'reqYear=' + year + '&reqMonth=' + month);
	
}

function currView(){
	if( $("#month").attr('class').includes( 'active' ) === true ){
		return 'month';
	}else{
		return 'day';
	}
}

function initCurrDate(){
	currYear = parseInt($("#_curr_year").val());
	currMonth =  parseInt($("#_curr_month").val());
}

function refreshCurrDate(year, month, date){
	$("#_curr_year").val(year);
	$("#_curr_month").val(month);
	$("#_curr_date").val(date);	
}