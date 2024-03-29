/** 달력을 그리기 위한 기능을 담은 js 파일
 * 
 */

var currYear;
var currMonth;
var currDate;

$(function(){
		
	//today 버튼 클릭 이벤트
	$("#btn_show_today").click(function(){
		loadCurrentCalendar();
	});
	
	//이전 버튼 클릭 이벤트
	$("#move_prev").click(function(){
		initCurrDate();		
		
		var now_date = new Date(currYear + '-' + setMonth(currMonth) + '-' + currDate);
				
		if( currView() === 'month' ){	//현재 뷰가 월인 경우 이전 월로 이동		
			now_date.setMonth(now_date.getMonth() - 1);	//month --
			
			getMonthCalendar(now_date.getFullYear(), now_date.getMonth() + 1);
			
			refreshCurrDate(now_date.getFullYear(), now_date.getMonth() + 1, 1);	//변경된 내용 설정
			$(".calendar-header h4").text( $("#_curr_year").val() + '년 ' + $("#_curr_month").val() + '월' );
		}else if( currView() === 'day' ){	//현재 뷰가 일인 경우 다음 일로 이동		
			now_date.setDate(now_date.getDate() - 1);	//date --
			
			getDayCalendar(now_date.getFullYear(), now_date.getMonth() + 1, now_date.getDate());
			
			refreshCurrDate(now_date.getFullYear(), now_date.getMonth() + 1, now_date.getDate());	//변경된 내용 설정
			$(".calendar-header h4").text( $("#_curr_year").val() + '년 ' + $("#_curr_month").val() + '월' );
		}
	});
	
	//다음 버튼 클릭 이벤트
	$("#move_next").click(function(){
		initCurrDate();
		var now_date = new Date(currYear + '-' + setMonth(currMonth) + '-' + currDate);
		
		if( currView() === 'month' ){	//현재 뷰가 월인 경우 다음 월로 이동	
			now_date.setMonth(now_date.getMonth() + 1);	//month --
			
			getMonthCalendar(now_date.getFullYear(), now_date.getMonth() + 1);
			
			refreshCurrDate(now_date.getFullYear(), now_date.getMonth() + 1, 1);	//변경된 내용 설정
			$(".calendar-header h4").text( $("#_curr_year").val() + '년 ' + $("#_curr_month").val() + '월' );
		}else if( currView() === 'day' ){	//현재 뷰가 일인 경우 다음 일로 이동
			now_date.setDate(now_date.getDate() + 1);	//date ++
			
			getDayCalendar(now_date.getFullYear(), now_date.getMonth() + 1, now_date.getDate());
			
			refreshCurrDate(now_date.getFullYear(), now_date.getMonth() + 1, now_date.getDate());	//변경된 내용 설정
			$(".calendar-header h4").text( $("#_curr_year").val() + '년 ' + $("#_curr_month").val() + '월' );
		}
	});
	
	//월 버튼 클릭 이벤트
	$("#tab-month").click(function(){
		$(".daily-calendar").hide();
		$(".weeks-in-month").show();
	});
	//일 버튼 클릭 이벤트
	$("#tab-day").click(function(){
		$(".weeks-in-month").hide();
		$(".daily-calendar").show();
	});
	
});

//현재 날짜에 맞는 뷰 로드
function loadCurrentCalendar(){
	if( currView() === 'month' ){	//현재 뷰가 월인 경우			
		var now_date = new Date();

	    currYear = now_date.getFullYear();
	    currMonth = (now_date.getMonth()+1)>9 ? ''+(now_date.getMonth()+1) : '0'+(now_date.getMonth()+1);
		
		getMonthCalendar(currYear, currMonth);
		
		refreshCurrDate(currYear, currMonth, 1);	//변경된 내용 설정
		$(".calendar-header h4").text( $("#_curr_year").val() + '년 ' + $("#_curr_month").val() + '월' );
	}else if( currView() === 'day' ){	//현재 뷰가 일인 경우
		var now_date = new Date();

	    currYear = now_date.getFullYear();
	    currMonth = (now_date.getMonth()+1)>9 ? ''+(now_date.getMonth()+1) : '0'+(now_date.getMonth()+1);
		currDate = now_date.getDate();
	    
	    getDayCalendar(currYear, currMonth, currDate);
		
		refreshCurrDate(currYear, currMonth, currDate);	//변경된 내용 설정
		$(".calendar-header h4").text( $("#_curr_year").val() + '년 ' + $("#_curr_month").val() + '월' );
	}
}

//일정 바 마우스아웃 이벤트 : 상세내용 삭제
function addMouseOutEventListenerToEventBar(){
	$(".event-start").mouseout(function(){

	});
}

//월 달력 load
function getMonthCalendar(year, month){	
	$(".daily-calendar").hide();
	$(".weeks-in-month").show();
	//현재 달력 삭제
	$(".weeks-in-month").remove();	
	//조건에 맞는 새 달력 불러오기
	$(".monthly-calendar-body").load('/calendar/month', 'reqYear=' + year + '&reqMonth=' + month);	
}

//일 달력 load
function getDayCalendar(year, month, date){
	$(".weeks-in-month").hide();
	$(".daily-calendar").show();
	
	//현재 달력 삭제
	$(".daily-calendar").remove();
	//조건에 맞는 새 달력 불러오기
	var calInfo = 'reqYear=' + year + '&reqMonth=' + month + '&reqDate=' + date;
	$(".daily-calendar-wrap").load('/calendar/day', calInfo);
}

//새 스케쥴 추가를 위한 모달창 load
function getNewScheModalView(){
	$("#cal_new_sche_model_wrap").load('/calendar/newsche');
}

function currView(){	//현재 뷰가 month인지 day인지 문자열로 리턴
	if( $("#month").attr('class').includes( 'active' ) === true ){
		return 'month';
	}else{
		return 'day';
	}
}

function initCurrDate(){	//웹페이지 값을 javascript로 복사
	currYear = parseInt($("#_curr_year").val());
	currMonth =  parseInt($("#_curr_month").val());
	currDate = parseInt($("#_curr_date").val());
}

function refreshCurrDate(year, month, date){	//매개변수 값으로 웹페이지 값 갱신
	$("#_curr_year").val(year);
	$("#_curr_month").val(month);
	$("#_curr_date").val(date);	
}

function setMonth(month){	//month 자리 수 조정
	if(month < 10){
		return '0' + month;
	}
	return month;
}