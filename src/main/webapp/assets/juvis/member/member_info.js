/**
 * 사용 페이지  :  회원가입/인증/아이디찾기 등
 * 사용 페이지 URL  : /hybrid/member
  */


/*******************************************************
 * STATIC
 *******************************************************/
var PAGE_CONSTATNT = {
    rangeSize : 10
}


/*******************************************************
 * PRIVATE or PUBLIC VARIABLE
 *******************************************************/
var _req_otp_yn = false;

/*******************************************************
 * HYBRID METHOD
 *******************************************************/

function validation_for_otp(_type, _jsonData) {
    if ( _type == 'pwd'){
        if ( JUVIS.Util.isEmpty(_jsonData.memId)){
            alert('아이디를 입력하세요.');
            return false;
        }
    }

    if ( JUVIS.Util.isEmpty(_jsonData.memName)){
        alert('이름을 입력하세요.');
        return false;
    }

    if ( JUVIS.Util.isEmpty(_jsonData.memSms) ){
        alert('전화번호를 입력하세요.');
        return false;
    }

    return true;
}

function validation_for_confirm(_type, _jsonData) {
    if ( _type == 'pwd'){
        if ( JUVIS.Util.isEmpty(_jsonData.memId)){
            alert('아이디를 입력하세요..');
            return false;
        }
    }

    if ( !_req_otp_yn ){
        alert('인증번호 요청을 먼저하세요.');
        return false;
    }

    if ( JUVIS.Util.isEmpty(_jsonData.memName)){
        alert('이름을 입력하세요.');
        return false;
    }

    if ( JUVIS.Util.isEmpty(_jsonData.memSms) ){
        alert('전화번호를 입력하세요.');
        return false;
    }

    if ( JUVIS.Util.isEmpty(_jsonData.otpNum) ){
        alert('인증번호를 입력하세요.');
        return false;
    }
    return true;
}

function getOtp(_type){
    var jsonData = {
        'memName' : $('#find' + _type + '-wrap').find('#inp_name').val()
        ,'memSms' : $('#find' + _type + '-wrap').find('#inp_tel').val()
    };

    if ( _type == 'pwd'){
        jsonData.memId = $('#find' + _type + '-wrap').find('#inp_id').val();
    }

    if ( validation_for_otp(_type, jsonData) ){
        JUVIS.ajax({
                url      : JUVIS.API.getOtp(_type),
                method   : 'POST', // GET, POST, PUT, DELETE
                contentType: "application/json", // xml, html, script, json, jsonp, text
                data     : JSON.stringify(jsonData),
                success : function (result) {
                    _req_otp_yn = true;
                    JUVIS.console.log(result);
                    alert('인증번호를 발송하였습니다.');
                },
                error : function (xhr, status, err){
                    _req_otp_yn = false;
                    alert('입력하신 가입정보가 없습니다.');
                }
        });
    }
}

function validOtp(_type){
    var jsonData = {
        'memName' : $('#find' + _type + '-wrap').find('#inp_name').val()
        ,'memSms' : $('#find' + _type + '-wrap').find('#inp_tel').val()
        ,'otpNum': $('#find' + _type + '-wrap').find('#inp_otp_num').val()
    };

    if ( _type == 'pwd'){
        jsonData.memId = $('#find' + _type + '-wrap').find('#inp_id').val();
    }

    if ( validation_for_confirm(_type, jsonData) ){
        JUVIS.ajax({
                url      : JUVIS.API.validOtp(_type),
                method   : 'POST', // GET, POST, PUT, DELETE
                contentType: "application/json", // xml, html, script, json, jsonp, text
                data     : JSON.stringify(jsonData),
                success : function (result) {
                    JUVIS.console.log(result);
                    var _msg = '고객님의 ID는 ' + result.data + ' 입니다.';
                    if ( _type == 'pwd'){
                        msg = '고객님의 임시비밀번호는 ' + result.data + ' 입니다.';
                    }
                    alert(_msg);

                    //initialize input data
                    $('#find' + _type + '-wrap').find('input').val('');
                    _req_otp_yn = false;
                },
                error : function (xhr, status, err){
                    alert('인증번호 확인이 실패하였습니다.');
                }
        });
    }
}


/*******************************************************
 * HYBRID EVENT
 *******************************************************/
$(document).ready(function(e){
    var _url = window.location.pathname;
    $('.tab_select').removeClass('tab_select');
    if ( _url.indexOf("/id") > 0){
        $('.header_tab')[0].click();
    }else{
        $('.header_tab')[1].click();
    }
});

$(document).on('submit', 'form', function(e){
    return false;
});

$(document).on('click', '#btnGetOtp', function(e){
    var _type = $(this).data('ftype');
    getOtp(_type);
});

$(document).on('click', '#btnConfirm', function(e){
    var _type = $(this).data('ftype');
    validOtp(_type);
});


//헤더 탭 선택
$(document).on('click','.header_tab',function(e){
    $('.tab_select').removeClass('tab_select');
    $(this).addClass('tab_select');
    var currentView = $(this).data('ctgry')+'-wrap';
    $('.input_newbox').addClass('hidden');
    $('#'+currentView).removeClass('hidden');
});

//네이티브 인터페이스 테스트
$(document).on('click','#test2',function(e){
    alert('call start')
    NativeInterface.loadingStart()
    setTimeout(function(){
        // 1초 후 작동해야할 코드
        alert('call end')
        NativeInterface.loadingEnd()
    }, 2000);
});

//스크롤 이벤트
$(window).scroll(function(event){
    var scrollT = $(this).scrollTop(); //스크롤바의 상단위치
    var scrollH = $(this).height(); //스크롤바를 갖는 div의 높이
    var ctgry = $('.tab_select').data('ctgry');
    var contentH = $('#'+ctgry+'-wrap').height()+$('.point_tab').height(); //문서 전체 내용을 갖는 div의 높이


    if(scrollT + scrollH >= contentH) { // 스크롤바가 맨 아래에 위치할 때
        var nextYn = $('.'+ctgry+'_body').attr('data-nextyn');
        if ( PAGE_CONSTATNT.listCallYn  == 'Y' || nextYn == 'N' ) {
            return;
        }
        if ( PAGE_CONSTATNT.listCallYn != 'Y' && nextYn != 'N') {
            PAGE_CONSTATNT.listCallYn = 'Y';
            PAGE_CONSTATNT.listCall[ctgry]();

        }
    }
});

/*******************************************************
 * NATIVE EVENT
 *******************************************************/