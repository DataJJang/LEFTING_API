/**
 * 사용 페이지  :  회원가입
 * 사용 페이지 URL  : /hybrid/member/join
 * 사용 JSP   경로  : /src/main/webapp/WEB-INF/views/member/join.jsp
 */


/*******************************************************
 * STATIC
 *******************************************************/
var PAGE_CONSTATNT = {
    getTitle : '회원가입',
    getOtpReq : false,
    getOtpCk  : false,
    getMemIdCk  : false,
    getTermUrl : {
                  path : '/hybrid/term/'
                 }
}

/*******************************************************
 * READY
 *******************************************************/

$(document).ready(function(event){
    NativeInterface.requestChangeTitle(PAGE_CONSTATNT.getTitle);
});
/*******************************************************
 * HYBRID METHOD
 *******************************************************/

function optTimer(duration) {

    var timer = duration * 60;
    timer--;
    var minutes, seconds;

    $('.agree_count').removeClass('hidden');
    $('#timer').html('05:00');

    var interval = setInterval(function(){
        minutes = parseInt(timer / 60 % 60, 10);
        seconds = parseInt(timer % 60, 10);

        minutes = minutes < 10 ? "0" + minutes : minutes;
        seconds = seconds < 10 ? "0" + seconds : seconds;

        $('#time-min').text(minutes);
        $('#time-sec').text(seconds);

        if (--timer < 0) {
            timer = 0;
            $('.agree_count').addClass('hidden');

            clearInterval(interval);
        }

        $('#timer').html(minutes+':'+seconds);
        console.log(minutes+':'+seconds);
    }, 1000);
};
//E-Mail 체크
function emailVallid(val) {
    if (JUVIS.Util.isEmpty(val)) {
        false;
    }
    val = val.trim();
    var emailPattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    if (val.match(emailPattern) != null) {
        return true;
    }
    return false;
};

//아이디 체크
function memIdVallid(val) {
    if (JUVIS.Util.isEmpty(val)) {
        false;
    }
    val = val.trim();
    var memIdPattern = /^[A-Za-z0-9+]{6,10}$/;
    if (val && val.match(memIdPattern) != null) {
        var reg = /(?=.*\d)(?=.*[A-Za-z])/
        if ( reg.test(val) ){
            return true;
        }
        return false;
    }
    return false;
};

//비밀번호 체크
function memPwVallid(val) {
    if (JUVIS.Util.isEmpty(val)) {
        false;
    }
    val = val.trim();
    console.log(val);
    var memPwPattern =  /^[A-Za-z0-9~@!?@~$%<>^&*\()\-=+\'+]{8,20}$/;
    if (val && val.match(memPwPattern) != null) {
        var reg = /(?=.*\d)(?=.*[A-Za-z])(?=.*[~@!?@~$%<>^&*\()\-=+\'+])/
        if ( reg.test(val) ){
            return true;
        }
        return false;
    }
    return false;
};

//생일 체크
function memBirthVallid(val) {
    var date_pattern = /^(19|20)\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[0-1])$/;
    var isTime = moment(val).isValid();
    if ( date_pattern.test(val) && isTime ){
        var age = moment().diff(moment(val,'YYYY-MM-DD'),'year');
        if ( age > 99 || age < 11 ) {
            return false;
        }
        if ( age == 11 ) {
            var dayAge = moment().diff( moment(val,'YYYY-MM-DD').add('years',11),'day');
            if ( dayAge < 1 ) {
                return false;
            }
        }
        return true;
    }
    return false;
};



//스텝2 초기화
function initSecondPage() {
    $('.join_box input').not('[name="mb_name"]').val('');
     PAGE_CONSTATNT.getMemIdCk = false;
    $('input[name="sex"]').prop('checked', false);
}
/*******************************************************
 * HYBRID EVENT
 *******************************************************/
// 값체크
$(document).on('input', 'input', function(event) {
    var validVal = String($(this).val());
    var mxLength = $(this).data('mxlength'); // attr가 아니라 data
    var inpType = $(this).data('type');
    if (inpType && inpType == 'number') {
        validVal = validVal.replace(/[^0-9]/g, "");
    }
    if (mxLength && mxLength < validVal.length) {
        validVal = validVal.substr(0, mxLength);
    }
    validVal = validVal.trim();
    $(this).val(validVal);

    var nm = $(this).attr('name');
    $('input[name="'+nm+'"]').val(validVal);
});


$(document).on('click', '.termsCk', function(event) {
   var ctgry = $(this).val();
   var ck = $(this).is(":checked");
   var clsName = $(this).attr("class");
   if ( ctgry == 'all_agree' && ck ) {
       $('.termsCk').prop('checked', true);
       return;
   } else if ( ctgry == 'all_agree') {
       $('.termsCk').prop('checked', false);
       return;
   }

   if ( !ck ) {
        $('.termsCk[value="all_agree"]').prop('checked', false);
   }

   if ( ctgry ==  'marketing_term' && ck ) {
       $('.marketing_termsCk').prop('checked', true);
   } else if ( ctgry ==  'marketing_term' && !ck ) {
       $('.marketing_termsCk').prop('checked', false);
   }

   if ( clsName.indexOf('marketing_term') > -1 && !ck ){
       $('.marketing_termsCk[value="marketing_term"]').prop('checked', false);
   }
   var allCk = 0;
   var allln = 0;
   var mkln = 0;
   var mkCk = 0;

   $('.termsCk').each(function (node) {
       var clsName = $(this).attr('class');
       var isCk =  $(this).is(":checked");
       allln ++;
       if ( isCk ) {
           allCk++;
       }
       if ( clsName.indexOf('marketing_term') > -1 ){
           mkln++;
           if ( isCk ) {
               mkCk++;
           }
       }
   });
   if (   mkln-1  <=  mkCk) {
        if (!$('.marketing_termsCk[value="marketing_term"]').is(":checked")) {
            allCk++;
        }
        $('.marketing_termsCk[value="marketing_term"]').prop('checked', true);
   }
   if (   allln-1  <=  allCk) {
       $('.termsCk[value="all_agree"]').prop('checked', true);
   }
});



//인증번호 요청
$(document).on('click', '.btn_cert1', function(event) {

    var clsName = $('.agree_count').attr('class');
    if ( clsName.indexOf('hidden') ==  -1  ) {
        alert('5분내 재요청이 불가능 합니다.');
        return;
    }

    var memName = $('#mb_name_step1').val();
    if (JUVIS.Util.isEmpty(memName)){
        alert('이름을 입력해 주세요.');
        return;
    }

    var memSms = $('#mb_tel').val();
    if (JUVIS.Util.isEmpty(memSms) ){
        alert('휴대폰 번호를 입력해 주세요.');
        return;
    }
    if (memSms.length < 10 ){
        alert('휴대폰 번호를 확인해주세요.');
        return;
    }

    var jsonData = JSON.stringify({"memName":memName,"memSms":memSms});
    JUVIS.ajax({
        url      : JUVIS.API.getOtp('join'),
        method   : 'POST', // GET, POST, PUT, DELETE
        contentType: "application/json", // xml, html, script, json, jsonp, text
        data     : jsonData,
        success : function (result) {
            alert('인증번호가 발송되었습니다.');
            PAGE_CONSTATNT.getOtpReq = true;
        },
        error : function(xhr, status, error) {
            alert(error.message);
        }
    });
});

//인증번호 확인
$(document).on('click', '.btn_cert2', function(event) {
    
    if (!PAGE_CONSTATNT.getOtpReq) {
        alert('인증번호를 요청해 주세요.');
        return;
    }
    
    
    var clsName = $('.agree_count').attr('class');
    if ( clsName.indexOf('hidden') ==  -1  ) {
        alert('5분내 재요청이 불가능 합니다.');
        return;
    }

    var memName = $('#mb_name_step1').val();
    if (JUVIS.Util.isEmpty(memName)){
        alert('이름을 입력해 주세요.');
        return;
    }

    var memSms = $('#mb_tel').val();
    if (JUVIS.Util.isEmpty(memSms) ){
        alert('휴대폰 번호를 입력해 주세요.');
        return;
    }
    if (memSms.length < 10 ){
        alert('휴대폰 번호를 확인해주세요.');
        return;
    }

    var otpnum = $('#otpNum').val();
    if (JUVIS.Util.isEmpty(otpnum) ){
        alert('인증 번호를 입력해 주세요.');
        return;
    }
    if (otpnum.length != 4 ){
        alert('인증 번호를 확인해주세요.');
        return;
    }

    var jsonData = JSON.stringify({"memName":memName,"memSms":memSms,"otpNum":otpnum});
    JUVIS.ajax({
        url      : JUVIS.API.validOtp('join'),
        method   : 'POST', // GET, POST, PUT, DELETE
        contentType: "application/json", // xml, html, script, json, jsonp, text
        data     : jsonData,
        success : function (result) {
            alert('인증 되었습니다.');
            PAGE_CONSTATNT.getOtpCk = true;
        },
        'error' : function(xhr, status, error) {
            if ( xhr.status == 204 ) {
                alert('잘못된 인증 번호 입니다.\n인증번호를 확인해주세요.');
                PAGE_CONSTATNT.getOtpCk = false;
            }
        }
    });
});

$(document).on('click', '#submit_agree', function(event) {
    event.preventDefault();
    if ( !PAGE_CONSTATNT.getOtpCk ) {
        alert('인증번호를 확인해 주세요.');
        return;
    }
    var termCk = true;
    $('.term_necessary').each(function (node) {
        var isCk =  $(this).is(":checked");
        if ( !isCk ) {
            termCk = false;
        }
    });

    if (!termCk) {
        alert('필수 약관 동의처리가 되어있지 않습니다.');
        return;
    }


    $('.agree_box').addClass('hidden');
    $('.join_box').removeClass('hidden');

    NativeInterface.requestBackClickProxy();


});

$(document).on('click', '#btn_same_id', function(event) {
   var memId = $('input[name="mb_id"]').val();
   if (JUVIS.Util.isEmpty(memId)) {
       alert('아이디를 입력해 주세요.');
       return;
   }
   if (!memIdVallid(memId)) {
       alert('아이디를 확인 해주세요.');
       return;
   }
    var jsonData = JSON.stringify({"memId":memId});
    JUVIS.ajax({
        url      : JUVIS.API.validMemId(),
        method   : 'POST', // GET, POST, PUT, DELETE
        contentType: "application/json", // xml, html, script, json, jsonp, text
        data     : jsonData,
        success : function (result) {
            alert(result.message);
            PAGE_CONSTATNT.getMemIdCk = true;
        },
        'error' : function(xhr, status, error) {
            if ( error && error.code == '9201' ) {
                alert(error.message);
            }
            PAGE_CONSTATNT.getMemIdCk = false;
        }
    });
});

$(document).on('input', 'input[name="mb_id"]', function(event) {
    PAGE_CONSTATNT.getMemIdCk = false;
});


$(document).on('input', 'input[name="mb_tel"]', function(event) {
    PAGE_CONSTATNT.getOtpReq = false;
    PAGE_CONSTATNT.getOtpCk = false;
});

$(document).on('click', '.termDetail', function(event) {
    var termctgry = $(this).data('termctgry');
    var termUrl = PAGE_CONSTATNT.getTermUrl.path + termctgry;
    if (termctgry) {
        NativeInterface.requestGoPage(termUrl);
    }
});

$(document).on('click', '#submit_join', function(event) {
    event.preventDefault();
    var memId = $('input[name="mb_id"]').val();
    var memName = $('#mb_name').val();
    var memPw = $('#mb_pw').val();
    var memPwSub = $('#mb_pw2').val();
    var birthDay = $('#mb_y').val()+'-'+$('#mb_m').val()+'-'+$('#mb_d').val();
    var memEmail = $('#mb_email').val();
    var memSex = $('input[name="sex"]:checked').attr('id');
    var memSms = $('#mb_tel').val();
    var emailYn = $('#email_term').is(":checked")?'Y':'N';
    var smsYn = $('#sms_term').is(":checked")?'Y':'N';
    var memNewsYN = $('#sms_term').is(":checked") || $('#email_term').is(":checked") ?'Y':'N';
    var memJoinPath = $('#site_root').val();



    if (!PAGE_CONSTATNT.getMemIdCk ) {
        alert('아이디 중복 체크 해주세요.')
        return;
    }
    if (!memIdVallid(memId)) {
        alert('아이디를 확인 해주세요.');
        return;
    }

    if (!memIdVallid(memId)) {
        alert('아이디를 확인 해주세요.');
        return;
    }
    if (JUVIS.Util.isEmpty(memName)) {
        alert('이름을 입력해 주세요.');
        return;
    }


    if (JUVIS.Util.isEmpty(memName)) {
        alert('이름을 입력해 주세요.');
        return;
    }

    if (!memBirthVallid(birthDay)) {
        alert('생년월일을 확인해주세요');
        return;
    }

    if (!memPwVallid(memPw)) {
        alert('비밀번호를 확인해 주세요.');
        return;
    }

    if (memPw != memPwSub) {
        alert('같은 비밀번호를 입력해 주세요.');
        return;
    }

    if (JUVIS.Util.isEmpty(memEmail)) {
        alert('이메일을 입력해 주세요.');
        return;
    }

    if (!emailVallid(memEmail)) {
        alert('이메일을 확인해 주세요.');
        return;
    }
    if (JUVIS.Util.isEmpty(memSex)) {
        alert('성별을 입력해 주세요.');
        return;
    }

    if (JUVIS.Util.isEmpty(memSms)) {
        alert('휴대폰 번호를 입력해 주세요.');
        return;
    }

    if (memSms.length < 10 ){
        alert('휴대폰 번호를 확인해주세요.');
        return;
    }

    if (JUVIS.Util.isEmpty(memJoinPath)) {
        alert('가입 경로를 입력해주세요.');
        return;
    }

    var data = {
        "memId" : memId,
        "memName" : memName,
        "memPwd" : memPw,
        "memEmail" : memEmail,
        "memSmsYN" : smsYn,
        "memEmailYN" : emailYn,
        "memNewsYN" : memNewsYN,
        "memSex" : memSex,
        "memBirthday" : birthDay,
        "memBirthType" : 'S',
        "memSms" : memSms,
        "memJoinPath"  : memJoinPath

    };

    var jsonData = JSON.stringify(data);
    JUVIS.ajax({
        url      : JUVIS.API.createMember(),
        method   : 'POST', // GET, POST, PUT, DELETE
        contentType: "application/json", // xml, html, script, json, jsonp, text
        data     : jsonData,
        success : function (result) {
            alert('가입이 완료 되었습니다.');
            NativeInterface.requestGoFinish();
        },
        error : function(xhr, status, error) {
            if ( error.message ) {
                alert(error.message);
            }
        }
    });


});


/*******************************************************
 * NATIVE EVENT
 *******************************************************/
$(window).on('back_key_clicked',function(e){
    $('.join_box').addClass('hidden');
    $('.agree_box').removeClass('hidden');
    NativeInterface.cancelBackClickProxy();
    initSecondPage();
    $('#mb_name_step1').trigger('input');

});