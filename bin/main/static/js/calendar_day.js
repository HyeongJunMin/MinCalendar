/**
 * 
 */
$(function(){
	//일 달력 클릭 이벤트(일정 추가)
	$(".daily-calendar").click(function( event ) {	
		var date = $("#_curr_year").val() + '.';
		date += ( ($("#_curr_month").val().length > 1)?$("#_curr_month").val():'0' + $("#_curr_month").val() ) + ".";
		date += ( ($("#_curr_date").val().length > 1)?$("#_curr_date").val():'0' + $("#_curr_date").val() );;
		$("#_sdate_ymd").val( date );
		$("#_sdate_hm").val("14:00");
		
	    $('#registerSchedule').modal('show');
	});
});