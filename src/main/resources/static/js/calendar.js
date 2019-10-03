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
	        format: 'LT'
	    });
	    $('#datetimepicker4').datetimepicker({
	        format: 'LT'
	    });
	});
	
	$(".week, .daily-calendar").click(function() {	
		console.log("week : " + $(this));
	    $('#registerSchedule').modal('show');
	});

	$(".event-consecutive, .event, .event-repeated").click(function(event) {
	    event.stopPropagation();
	});
}


