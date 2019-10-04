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
	
	//하루종일 체크 시 시간설정
	$("#_chk_isAllDaySche").change(function(){		
		if( true === $("#_chk_isAllDaySche").is(":checked") ){
			$("#_sdate_hm").val('00:00');
			$("#_edate_hm").val('23:59');
			$("#_edate_hm, #_sdate_hm").attr('readonly','readonly');
		}else{
		}
	});
	
	//일정 만들기 버튼 클릭 시 이벤트
	$("#confirm_new_sche").click(function(){
		if( ifHasEmpty() == false ){//빈칸검사
			return;
		}
		saveSchedule();
		
	});	
});

function saveSchedule(){
	
	//폼 직렬화 설정
	var queryString = $("form[name=frm_save_schedule]").serialize() ;
	
	$.ajax({
		contentType : 'application/json',
		dataType : 'json',
		url : '/calendar/save/schedule',
		type : 'post',
		async : false,
		data : queryString,
		success : function( resp ) {
			if(resp === '1' || resp === 1){//통신에 성공하여 DB저장까지 성공한 경우
				loadCurrentCalendar();
			}
		},
		error : function() {
			alert('통신에러 발생.');
		}
	});
}

//ajax통신으로 보낼 데이터 세팅
function setViewData(){
	var viewData = {};
	// data[키] = 밸류
	viewData["head"] = 'sdfsdfsdf';	
	
	return viewData;
}
//빈칸검사 함수
function ifHasEmpty(){
	var inputComps = $("#registerSchedule input[type=text], textarea");
	
	for( i = 0 ; i < inputComps.length ; i++ ){
		if( inputComps.eq(i).val().length < 1 ){
			inputComps.eq(i).addClass('is-invalid');
			inputComps.eq(i).focus();
			return false;
		}
	}
	
	return true;
}

