/** form data
 * 		[DTO] = [input name]
 * 		title = title
 * 		content	=	content
 * 		sdate	=	sdate(#_sdate_ymd + #_sdate_hm)
 * 		(하루종일)	=	#_sdate_ymd + 00:00:00
 * 		edate	=	edate(#_edate_ymd + #_edate_hm)
 * 		(하루종일)	=	#_edate_ymd + 24:00:00
 * 		sche_type	= sche_type(chk?반복:하루)
 * 		
 */

$(function(){
	//입력 후 invalid 제거
	$("#registerSchedule input[type=text], textarea").focusout(function(){
		$(this).removeClass('is-invalid');
	});
	
	//일정 만들기 버튼 클릭 시 이벤트
	$("#confirm_new_sche").click(function(){
		ifHasEmpty();//빈칸검사
		
		
	});	
});

//빈칸검사 함수
function ifHasEmpty(){
	var inputComps = $("#registerSchedule input[type=text], textarea");
	
	for( i = 0 ; i < inputComps.length ; i++ ){
		if( inputComps.eq(i).val().length < 1 ){
			inputComps.eq(i).addClass('is-invalid');
			inputComps.eq(i).focus();
			return;
		}
	}
}

