<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<script src="/js/sub/calendar_new_modal.js"></script>

<div class="modal fade" id="registerSchedule" tabindex="-1" role="dialog" aria-labelledby="registerScheduleLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="registerScheduleLabel">일정 만들기</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="_frm_save_schedule" name="frm_save_schedule">
                    <div class="form-group">
                        <label class="col-form-label">일정 제목</label>
                        <input type="text" name="title" class="form-control" id="recipient-name">
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">일정 설명</label>
                        <textarea class="form-control" name="content" id="message-text"></textarea>
                    </div>
                    <div class="form-row">
                        <div class="col-md-6">
                            <div class="form-group">
                            	<input type="hidden" name="sdate" value="">
                                <label class="col-form-label">일정 시작 날짜</label>
                                <div class="input-group date" id="datetimepicker1" data-target-input="nearest">
                                    <input type="text" name="sdate_ymd" id="_sdate_ymd" class="form-control datetimepicker-input" data-target="#datetimepicker1"/>
                                    <div class="input-group-append" data-target="#datetimepicker1" data-toggle="datetimepicker">
                                        <div class="input-group-text">
                                        	<i class="material-icons">calendar_today</i>
                                        </div>
                                    </div>
                                </div>
                                <!-- 
                                <div class="input-group date" id="datetimepicker1" data-target-input="nearest">
                                    <input type="text" class="form-control datetimepicker-input"
                                           data-target="#datetimepicker1"/>
                                    <div class="input-group-append" data-target="#datetimepicker1"
                                         data-toggle="datetimepicker">
                                        <div class="input-group-text"><i class="material-icons">
                                            calendar_today
                                        </i></div>
                                    </div>
                                </div>    
                                 -->                            
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="col-form-label">일정 시작 시간</label>
                                <div class="input-group date" id="datetimepicker2" data-target-input="nearest">
                                    <input type="text" name="sdate_hm" id="_sdate_hm" class="form-control datetimepicker-input"
                                           data-target="#datetimepicker2"/>
                                    <div class="input-group-append" data-target="#datetimepicker2"
                                         data-toggle="datetimepicker">
                                        <div class="input-group-text"><i class="material-icons">
                                            access_time
                                        </i></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="col-form-label">일정 종료 날짜</label>
                                <div class="input-group date" id="datetimepicker3" data-target-input="nearest">
                                    <input type="text" name="_edate_ymd" id="_edate_ymd" class="form-control datetimepicker-input"
                                           data-target="#datetimepicker3"/>
                                    <div class="input-group-append" data-target="#datetimepicker3"
                                         data-toggle="datetimepicker">
                                        <div class="input-group-text"><i class="material-icons">
                                            calendar_today
                                        </i></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="col-form-label">일정 종료 시간</label>
                                <div class="input-group date" id="datetimepicker4" data-target-input="nearest">
                                    <input type="text" name="_edate_hm" id="_edate_hm" class="form-control datetimepicker-input"
                                           data-target="#datetimepicker4"/>
                                    <div class="input-group-append" data-target="#datetimepicker4"
                                         data-toggle="datetimepicker">
                                        <div class="input-group-text"><i class="material-icons">
                                            access_time
                                        </i></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-check form-check-inline">
                        	
                            <input class="form-check-input" type="checkbox" name="isRepeatedSche" id="_chk_isRepeatedSche" value="repeated">
                            <label class="form-check-label" for="inlineCheckbox1">매월 반복</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="checkbox" id="_chk_isAllDaySche" value="option2">
                            <label class="form-check-label" for="inlineCheckbox2">하루 종일</label>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
                <button type="button" class="btn btn-primary" id="confirm_new_sche">일정 만들기</button>        
            </div>
        </div>
    </div>
</div>


</html>