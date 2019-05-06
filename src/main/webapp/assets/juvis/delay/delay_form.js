/**
 * 사용 페이지  :  연기 신청
 * 사용 페이지 URL  : /hybrid/delay/delay_form
 * 사용 JSP   경로  : /src/main/webapp/WEB-INF/views/delay/delay_form.jsp
 */


/*******************************************************
 * STATIC
 *******************************************************/
var PAGE_CONSTATNT = {
    getTitle : '연기 신청'
}

$(document).ready(function(event){
    NativeInterface.requestChangeTitle(PAGE_CONSTATNT.getTitle);
});
/*******************************************************
 * HYBRID METHOD
 *******************************************************/

var getTermName = function() {
    var termName ;
    var url = window.document.URL.toString();
    if(url.indexOf('?') > -1){
        url = url.split('?')[0]
    }
    termName = url.substr(url.lastIndexOf('/')+1,url.length);
    return termName;
}

/*******************************************************
 * READY
 *******************************************************/

$(document).ready(function(event){
    var termName = getTermName();
    var title = PAGE_CONSTATNT.getTitle[termName];
    if ( title ) {
        NativeInterface.requestChangeTitle(title);
    }

});
/*******************************************************
 * HYBRID EVENT
 *******************************************************/

// 전역 변수
var CHECK_AUTH = false;  // 인증번호 확인 플래그

// 페이지 닫기
$(document).on('click', '#close', function(event) {
    NativeInterface.requestGoFinish();
});

// 인증 번호 요청
$(document).on('click', '#btn_send_auth', function(event) {
    event.preventDefault();

    console.log('brn_send_auth clikck');

    var brcId = $('#brcId').val();
    var memId = $('#memId').val();
    var dlyStartDate = $('#dlyStartDate').val();
    var dlyEndDate = $('#dlyEndDate').val();

    var jsonData = JSON.stringify({'memId' : memId, 'brcId' : brcId, 'dlyStartDate' : dlyStartDate, 'dlyEndDate' : dlyEndDate, 'reqType' : 'delay'});

    JUVIS.ajax({
        url      : JUVIS.API.sendDlyAuthSms(),
        method   : 'POST', // GET, POST, PUT, DELETE
        contentType: "application/json", // xml, html, script, json, jsonp, text
        data     : jsonData,
        success : function (result) {
            if(result.code == '1'){
                $('#msnId').val(result.data);
                alert('인증 번호 전송 성공');
            }else{
                alert('인증 번호 전송 실패');
            }
        },
        error : function(xhr, status, error) {
            alert(error.message);
        }
    });

});

// 인증 번호 확인
$(document).on('click', '#btn_check_auth', function(event) {
    event.preventDefault();

    var memId = $('#memId').val();
    var msnId = $('#msnId').val();
    var authNum = $('#sign_num').val();

    if(msnId == ''){
        alert('인증번호 요청을 먼저 하세요.');
        return;
    }

    var jsonData = JSON.stringify({'memId' : memId, 'msnId' : msnId, 'authNum' :  authNum});

    JUVIS.ajax({
        url      : JUVIS.API.checkDlyAuthNum(),
        method   : 'POST', // GET, POST, PUT, DELETE
        contentType: "application/json", // xml, html, script, json, jsonp, text
        data     : jsonData,
        success : function (result) {
            if(result.code == '1'){
                alert('인증 성공');
                CHECK_AUTH = true;
            }else{
                alert(result.message);
            }
        },
        error : function(xhr, status, error) {
            alert(error.message);
        }
    });

});

// 연기 신청
$(document).on('click', '#btn_insert_delay22', function(event) {
    event.preventDefault();

    console.log('btn_insert_delay clikck');

    var jsonData = JSON.stringify({'memId' : memId});

    // JUVIS.ajax({
    //     url      : JUVIS.API.createDelay(),
    //     method   : 'POST', // GET, POST, PUT, DELETE
    //     contentType: "application/json", // xml, html, script, json, jsonp, text
    //     data     : jsonData,
    //     success : function (result) {
    //         alert(result.data);
    //     },
    //     error : function(xhr, status, error) {
    //         alert(error.message);
    //     },
    //     complete : function (result) {
    //         NativeInterface.requestGoFinish();
    //     }
    // });




});

$("form#delayForm").submit(function(event) {
    event.preventDefault();

    var formData = new FormData($(this)[0]);
    var checkBox = $('#check_agree').is(":checked");

    var dlyContents = formData.get('dlyContents');
    formData.set('dlyConents', JUVIS.Util.filterXSS(dlyContents));

    if (JUVIS.Util.isEmpty(formData.get('dlyReason'))) {
        alert('연기신청 사유를 확인해주세요.');
        return;
    }

    if (JUVIS.Util.isEmpty(formData.get('dlyContents'))) {
        alert('기타 사유를 확인해주세요.');
        return;
    }

    if (JUVIS.Util.isEmpty(formData.get('dlyStartDate')) || formData.get('dlyStartDate').length != 8) {
        alert('연기신청 기간을 확인해주세요.');
        return;
    }

    if (JUVIS.Util.isEmpty(formData.get('dlyEndDate')) || formData.get('dlyEndDate').length != 8) {
        alert('연기신청 기간을 확인해주세요.');
        return;
    }

    if (JUVIS.Util.isEmpty(formData.get('memSms')) || formData.get('memSms').length < 10 || formData.get('memSms').length > 11) {
        alert('휴대폰 번호를 확인해주세요.');
        return;
    }

    if (JUVIS.Util.isEmpty(formData.get('sign_num')) || formData.get('sign_num').length != 4) {
        alert('인증번호를 확인해주세요.');
        return;
    }

    if (!checkBox) {
        alert('SMS 인증 및 약관에 동의를 확인해주세요.');
        return;
    }

    if (!CHECK_AUTH) {
        alert('인증번호 확인 먼저 해주세요.');
        return;
    }

    $.ajax({
        url: JUVIS.API.createDelay(),
        contentType: false,
        processData: false,
        encrypted: "multipart/form-data",
        method: "POST",
        data: formData,
        success: function (data, form, option) {
            alert(data.message);
        },
        error: function (x, e) {
            console.log(x.status);
            console.log(e)
        }
    });
});

/*******************************************************
 * NATIVE EVENT
 *******************************************************/

//달력테스트 버튼 이벤트
var calendarTarget = '';

$(document).on('click', '#dlyStartDate', function(event) {
    calendarTarget = 'dlyStartDate';

    getRequestChooseDate();
});

$(document).on('click', '#dlyEndDate', function(event) {
    calendarTarget = 'dlyEndDate';

    getRequestChooseDate();
});

$(window).on('date_changed',function(event, yyyymmdd){
    $('#'+calendarTarget).val(yyyymmdd);
});

function getRequestChooseDate() {
    // 현재 날짜 구하기
    var now = new Date();

    var yyyy = now.getFullYear() + "";
    var mm = now.getMonth() + 1;
    var dd = now.getDate();

    if (mm < 10) {
        mm = "0" + mm;
    } else {
        mm = mm + "";
    }

    if (dd < 10) {
        dd = "0" + dd;
    } else {
        dd = dd + ""
    }

    var nowDate = yyyy + mm + dd;
    var minDate = yyyy + mm + dd + "";

    // 프로그램 시작일이 현재 날짜보다 더 크면 프로그램 시작일을 기준일로 바꾼다.
    var ctdStart = $('#ctdStartDate').val();
    var ctdStartDate = new Date(ctdStart);

    if (ctdStartDate > now) {
        minDate = ctdStart;
    }

    minDate = minDate.replace(/\-/gi, '');

    NativeInterface.requestChooseDate(nowDate * 1 , minDate * 1);
}

