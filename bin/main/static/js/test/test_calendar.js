/**
 * 
 */

$(function(){
	addEventListners();
});

function addEventListners(){
	
	$(function () {
	    $('[data-toggle="tooltip"]').tooltip()
	});

	$(function () {
	    $('#view li:first-child a').tab('show')
	});

	$(function () {
	    $('[data-toggle="popover"]').popover().on('inserted.bs.popover')
	});
	
	$(function(){
		//$('.dateTimePicker').datetimepicker({format:"YYYY-MM-DD",minDate : moment()});
		$('#dtp111').datetimepicker({
            format:'L'
        });
		$('#datetimepicker1').datetimepicker({
	        format: 'L'	       
	    });
	    $('#datetimepicker3').datetimepicker({
	        format: 'L'
	    });
	    $('#datetimepicker2').datetimepicker({
	        //format: 'LT'
	    	format: 'HH:mm'
	    });
	    $('#datetimepicker4').datetimepicker({
	        //format: 'LT'
	    	format: 'HH:mm'
	    });
	});
	
	//월 달력 클릭 이벤트(일정 추가)
	$(".week").click(function(event){
		var eqNum = getEqInWeek(event);
		console.log("eqNum : " + eqNum);
		console.log($(this).children().eq(eqNum).children().eq(0).text());
		var clkDay = $(this).children().eq(eqNum).children().eq(0).text();
		clkDay = (clkDay.length > 1)?clkDay:'0'+clkDay;
		
		var date = $("#_curr_year").val() + '.';
		date += ($("#_curr_month").val().length > 1)?$("#_curr_month").val():'0' + $("#_curr_month").val();
		date += '.' + clkDay;
		
		$("#_sdate_ymd").val( date );
		$("#_sdate_hm").val("14:00");
		$("#_edate_ymd").val( date );
		$("#_edate_hm").val("14:00");
		
		$('#registerSchedule').modal('show');
	});
	
	//일 달력 클릭 이벤트(일정 추가)
	$(".daily-calendar").click(function( event ) {	
		var date = $("#_curr_year").val() + '.';
		date += ( ($("#_curr_month").val().length > 1)?$("#_curr_month").val():'0' + $("#_curr_month").val() ) + ".";
		date += ( ($("#_curr_date").val().length > 1)?$("#_curr_date").val():'0' + $("#_curr_date").val() );;
		$("#_sdate_ymd").val( date );
		$("#_sdate_hm").val("14:00");
		$("#_edate_ymd").val( date );
		$("#_edate_hm").val("14:00");
		
	    $('#registerSchedule').modal('show');
	});

	$(".event-consecutive, .event, .event-repeated").click(function(event) {
	    event.stopPropagation();
	});
		
}

//월 달력 클릭 이벤트에서 일 칸 수 리턴
function getEqInWeek(event){
    var dWidth = $(this).width();
    
    var locX = event.offsetX;
    var locY = event.offsetY;

    return parseInt(locX / (dWidth/7));
}
