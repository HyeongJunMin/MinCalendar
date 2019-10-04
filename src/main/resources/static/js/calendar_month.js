/**
 * 
 */

$(function(){
	//일정 바 마우스아웃 이벤트 : 상세내용 삭제
	addMouseOutEventListenerToEventBar();
	$(".week .event-start").mouseout(function(){
		$(this).popover('hide');
	});
});